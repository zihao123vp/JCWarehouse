/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.web.outboundorder;

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
import com.jeesite.modules.warehouse.entity.outboundorder.WarehouseOutboundOrder;
import com.jeesite.modules.warehouse.service.outboundorder.WarehouseOutboundOrderService;

/**
 * 出库单表Controller
 * @author yzh
 * @version 2018-09-20
 */
@Controller
@RequestMapping(value = "${adminPath}/warehouse/outboundorder/warehouseOutboundOrder")
public class WarehouseOutboundOrderController extends BaseController {

	@Autowired
	private WarehouseOutboundOrderService warehouseOutboundOrderService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public WarehouseOutboundOrder get(String id, boolean isNewRecord) {
		return warehouseOutboundOrderService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("warehouse:outboundorder:warehouseOutboundOrder:view")
	@RequestMapping(value = {"list", ""})
	public String list(WarehouseOutboundOrder warehouseOutboundOrder, Model model) {
		model.addAttribute("warehouseOutboundOrder", warehouseOutboundOrder);
		return "modules/warehouse/outboundorder/warehouseOutboundOrderList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("warehouse:outboundorder:warehouseOutboundOrder:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<WarehouseOutboundOrder> listData(WarehouseOutboundOrder warehouseOutboundOrder, HttpServletRequest request, HttpServletResponse response) {
		Page<WarehouseOutboundOrder> page = warehouseOutboundOrderService.findPage(new Page<WarehouseOutboundOrder>(request, response), warehouseOutboundOrder); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("warehouse:outboundorder:warehouseOutboundOrder:view")
	@RequestMapping(value = "form")
	public String form(WarehouseOutboundOrder warehouseOutboundOrder, Model model) {
		model.addAttribute("warehouseOutboundOrder", warehouseOutboundOrder);
		return "modules/warehouse/outboundorder/warehouseOutboundOrderForm";
	}

	/**
	 * 保存出库单表
	 */
	@RequiresPermissions("warehouseOutboundOrder:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated WarehouseOutboundOrder warehouseOutboundOrder) {
		warehouseOutboundOrderService.save(warehouseOutboundOrder);
		return renderResult(Global.TRUE, text("保存出库单表成功！"));
	}
	
	/**
	 * 删除出库单表
	 */
	@RequiresPermissions("warehouseOutboundOrder:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(WarehouseOutboundOrder warehouseOutboundOrder) {
		warehouseOutboundOrderService.delete(warehouseOutboundOrder);
		return renderResult(Global.TRUE, text("删除出库单表成功！"));
	}
	
}