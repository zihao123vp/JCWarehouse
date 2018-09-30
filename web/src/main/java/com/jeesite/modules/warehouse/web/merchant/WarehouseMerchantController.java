/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.web.merchant;

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
import com.jeesite.modules.warehouse.entity.merchant.WarehouseMerchant;
import com.jeesite.modules.warehouse.service.merchant.WarehouseMerchantService;

/**
 * 经销商信息表Controller
 * @author yzh
 * @version 2018-09-20
 */
@Controller
@RequestMapping(value = "${adminPath}/warehouse/merchant/warehouseMerchant")
public class WarehouseMerchantController extends BaseController {

	@Autowired
	private WarehouseMerchantService warehouseMerchantService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public WarehouseMerchant get(String id, boolean isNewRecord) {
		return warehouseMerchantService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("warehouse:merchant:warehouseMerchant:view")
	@RequestMapping(value = {"list", ""})
	public String list(WarehouseMerchant warehouseMerchant, Model model) {
		model.addAttribute("warehouseMerchant", warehouseMerchant);
		return "modules/warehouse/merchant/warehouseMerchantList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("warehouse:merchant:warehouseMerchant:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<WarehouseMerchant> listData(WarehouseMerchant warehouseMerchant, HttpServletRequest request, HttpServletResponse response) {
		Page<WarehouseMerchant> page = warehouseMerchantService.findPage(new Page<WarehouseMerchant>(request, response), warehouseMerchant); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("warehouse:merchant:warehouseMerchant:view")
	@RequestMapping(value = "form")
	public String form(WarehouseMerchant warehouseMerchant, Model model) {
		model.addAttribute("warehouseMerchant", warehouseMerchant);
		return "modules/warehouse/merchant/warehouseMerchantForm";
	}

	/**
	 * 保存经销商信息表
	 */
	@RequiresPermissions("warehouse:merchant:warehouseMerchant:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated WarehouseMerchant warehouseMerchant) {
		warehouseMerchantService.save(warehouseMerchant);
		return renderResult(Global.TRUE, text("保存经销商信息表成功！"));
	}
	
	/**
	 * 停用经销商信息表
	 */
	@RequiresPermissions("warehouse:merchant:warehouseMerchant:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(WarehouseMerchant warehouseMerchant) {
		warehouseMerchant.setStatus(WarehouseMerchant.STATUS_DISABLE);
		warehouseMerchantService.updateStatus(warehouseMerchant);
		return renderResult(Global.TRUE, text("停用经销商信息表成功"));
	}
	
	/**
	 * 启用经销商信息表
	 */
	@RequiresPermissions("warehouse:merchant:warehouseMerchant:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(WarehouseMerchant warehouseMerchant) {
		warehouseMerchant.setStatus(WarehouseMerchant.STATUS_NORMAL);
		warehouseMerchantService.updateStatus(warehouseMerchant);
		return renderResult(Global.TRUE, text("启用经销商信息表成功"));
	}
	
	/**
	 * 删除经销商信息表
	 */
	@RequiresPermissions("warehouse:merchant:warehouseMerchant:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(WarehouseMerchant warehouseMerchant) {
		warehouseMerchantService.delete(warehouseMerchant);
		return renderResult(Global.TRUE, text("删除经销商信息表成功！"));
	}
	
}