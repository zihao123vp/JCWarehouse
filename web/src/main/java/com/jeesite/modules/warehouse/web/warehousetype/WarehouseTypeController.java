/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.web.warehousetype;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.warehouse.entity.warehousetype.WarehouseType;
import com.jeesite.modules.warehouse.service.warehousetype.WarehouseTypeService;

/**
 * 库存类型表Controller
 * @author yzh
 * @version 2018-09-20
 */
@Controller
@RequestMapping(value = "${adminPath}/warehouse/warehousetype/warehouseType")
public class WarehouseTypeController extends BaseController {

	@Autowired
	private WarehouseTypeService warehouseTypeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public WarehouseType get(String treeCode, boolean isNewRecord) {
		return warehouseTypeService.get(treeCode, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("warehouse:warehousetype:warehouseType:view")
	@RequestMapping(value = {"list", ""})
	public String list(WarehouseType warehouseType, Model model) {
		model.addAttribute("warehouseType", warehouseType);
		return "modules/warehouse/warehousetype/warehouseTypeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("warehouse:warehousetype:warehouseType:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public List<WarehouseType> listData(WarehouseType warehouseType) {
		if (StringUtils.isBlank(warehouseType.getParentCode())) {
			warehouseType.setParentCode(WarehouseType.ROOT_CODE);
		}
		if (StringUtils.isNotBlank(warehouseType.getTreeName())){
			warehouseType.setParentCode(null);
		}
		if (StringUtils.isNotBlank(warehouseType.getStatus())){
			warehouseType.setParentCode(null);
		}
		if (StringUtils.isNotBlank(warehouseType.getRemarks())){
			warehouseType.setParentCode(null);
		}
		List<WarehouseType> list = warehouseTypeService.findList(warehouseType);
		return list;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("warehouse:warehousetype:warehouseType:view")
	@RequestMapping(value = "form")
	public String form(WarehouseType warehouseType, Model model) {
		// 创建并初始化下一个节点信息
		warehouseType = createNextNode(warehouseType);
		model.addAttribute("warehouseType", warehouseType);
		return "modules/warehouse/warehousetype/warehouseTypeForm";
	}
	
	/**
	 * 创建并初始化下一个节点信息，如：排序号、默认值
	 */
	@RequiresPermissions("warehouse:warehousetype:warehouseType:edit")
	@RequestMapping(value = "createNextNode")
	@ResponseBody
	public WarehouseType createNextNode(WarehouseType warehouseType) {
		if (StringUtils.isNotBlank(warehouseType.getParentCode())){
			warehouseType.setParent(warehouseTypeService.get(warehouseType.getParentCode()));
		}
		if (warehouseType.getIsNewRecord()) {
			WarehouseType where = new WarehouseType();
			where.setParentCode(warehouseType.getParentCode());
			WarehouseType last = warehouseTypeService.getLastByParentCode(where);
			// 获取到下级最后一个节点
			if (last != null){
				warehouseType.setTreeSort(last.getTreeSort() + 30);
				warehouseType.setTreeCode(IdGen.nextCode(last.getTreeCode()));
			}else if (warehouseType.getParent() != null){
				warehouseType.setTreeCode(warehouseType.getParent().getTreeCode() + "001");
			}
		}
		// 以下设置表单默认数据
		if (warehouseType.getTreeSort() == null){
			warehouseType.setTreeSort(WarehouseType.DEFAULT_TREE_SORT);
		}
		return warehouseType;
	}

	/**
	 * 保存库存类型表
	 */
	@RequiresPermissions("warehouse:warehousetype:warehouseType:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated WarehouseType warehouseType) {
		warehouseTypeService.save(warehouseType);
		return renderResult(Global.TRUE, text("保存库存类型表成功！"));
	}
	
	/**
	 * 删除库存类型表
	 */
	@RequiresPermissions("warehouse:warehousetype:warehouseType:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(WarehouseType warehouseType) {
		warehouseTypeService.delete(warehouseType);
		return renderResult(Global.TRUE, text("删除库存类型表成功！"));
	}
	
	/**
	 * 获取树结构数据
	 * @param excludeCode 排除的Code
	 * @param isShowCode 是否显示编码（true or 1：显示在左侧；2：显示在右侧；false or null：不显示）
	 * @return
	 */
	@RequiresPermissions("warehouse:warehousetype:warehouseType:view")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData(String excludeCode, String isShowCode) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		List<WarehouseType> list = warehouseTypeService.findList(new WarehouseType());
		for (int i=0; i<list.size(); i++){
			WarehouseType e = list.get(i);
			// 过滤非正常的数据
			if (!WarehouseType.STATUS_NORMAL.equals(e.getStatus())){
				continue;
			}
			// 过滤被排除的编码（包括所有子级）
			if (StringUtils.isNotBlank(excludeCode)){
				if (e.getId().equals(excludeCode)){
					continue;
				}
				if (e.getParentCodes().contains("," + excludeCode + ",")){
					continue;
				}
			}
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", e.getId());
			map.put("pId", e.getParentCode());
			map.put("name", StringUtils.getTreeNodeName(isShowCode, e.getTreeCode(), e.getTreeName()));
			mapList.add(map);
		}
		return mapList;
	}

	/**
	 * 修复表结构相关数据
	 */
	@RequiresPermissions("warehouse:warehousetype:warehouseType:edit")
	@RequestMapping(value = "fixTreeData")
	@ResponseBody
	public String fixTreeData(WarehouseType warehouseType){
		if (!UserUtils.getUser().isAdmin()){
			return renderResult(Global.FALSE, "操作失败，只有管理员才能进行修复！");
		}
		warehouseTypeService.fixTreeData();
		return renderResult(Global.TRUE, "数据修复成功");
	}
	
}