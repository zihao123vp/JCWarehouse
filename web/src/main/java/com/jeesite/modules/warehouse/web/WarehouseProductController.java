/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.warehouse.entity.WarehouseProduct;
import com.jeesite.modules.warehouse.service.WarehouseProductService;

/**
 * 货品信息表Controller
 * @author yzh
 * @version 2018-09-20
 */
@Controller("warehouseProduct")
@RequestMapping(value = "${adminPath}/warehouse/warehouseProduct")
public class WarehouseProductController extends BaseController {

	@Autowired
	private WarehouseProductService warehouseProductService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public WarehouseProduct get(String id, boolean isNewRecord) {
		return warehouseProductService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("warehouse:warehouseProduct:view")
	@RequestMapping(value = {"list", ""})
	public String list(WarehouseProduct warehouseProduct, Model model) {
		model.addAttribute("warehouseProduct", warehouseProduct);
		return "modules/warehouse/warehouseProductList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("warehouse:warehouseProduct:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<WarehouseProduct> listData(WarehouseProduct warehouseProduct, HttpServletRequest request, HttpServletResponse response) {
		Page<WarehouseProduct> page = warehouseProductService.findPage(new Page<WarehouseProduct>(request, response), warehouseProduct); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("warehouse:warehouseProduct:view")
	@RequestMapping(value = "form")
	public String form(WarehouseProduct warehouseProduct, Model model) {
		model.addAttribute("warehouseProduct", warehouseProduct);
		return "modules/warehouse/warehouseProductForm";
	}

	/**
	 * 保存货品信息表
	 */
	@RequiresPermissions("warehouse:warehouseProduct:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated WarehouseProduct warehouseProduct) {
		warehouseProductService.save(warehouseProduct);
		return renderResult(Global.TRUE, text("保存货品信息表成功！"));
	}
	
	/**
	 * 停用货品信息表
	 */
	@RequiresPermissions("warehouse:warehouseProduct:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(WarehouseProduct warehouseProduct) {
		warehouseProduct.setStatus(WarehouseProduct.STATUS_DISABLE);
		warehouseProductService.updateStatus(warehouseProduct);
		return renderResult(Global.TRUE, text("停用货品信息表成功"));
	}
	
	/**
	 * 启用货品信息表
	 */
	@RequiresPermissions("warehouse:warehouseProduct:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(WarehouseProduct warehouseProduct) {
		warehouseProduct.setStatus(WarehouseProduct.STATUS_NORMAL);
		warehouseProductService.updateStatus(warehouseProduct);
		return renderResult(Global.TRUE, text("启用货品信息表成功"));
	}
	
	/**
	 * 删除货品信息表
	 */
	@RequiresPermissions("warehouse:warehouseProduct:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(WarehouseProduct warehouseProduct) {
		warehouseProductService.delete(warehouseProduct);
		return renderResult(Global.TRUE, text("删除货品信息表成功！"));
	}
	
}