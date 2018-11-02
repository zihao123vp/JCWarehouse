/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.web.outboundorder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

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
 * @version 2018-10-22
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
	 * 查询列表：待发货
	 */
	@RequestMapping(value = {"list", ""})
	public String list(WarehouseOutboundOrder warehouseOutboundOrder, Model model) {
		model.addAttribute("warehouseOutboundOrder", warehouseOutboundOrder);
		return "modules/warehouse/outboundorder/warehouseOutboundOrderList";
	}
	
	/**
	 * 查询列表：待审核
	 */
	@RequestMapping(value = {"list_dsh", ""})
	public String list_dsh(WarehouseOutboundOrder warehouseOutboundOrder, Model model) {
		model.addAttribute("warehouseOutboundOrder", warehouseOutboundOrder);
		return "modules/warehouse/outboundorder/warehouseOutboundOrderList_dsh";
	}
	
	/**
	 * 查询列表：已审核
	 */
	@RequestMapping(value = {"list_ysh", ""})
	public String list_ysh(WarehouseOutboundOrder warehouseOutboundOrder, Model model) {
		model.addAttribute("warehouseOutboundOrder", warehouseOutboundOrder);
		return "modules/warehouse/outboundorder/warehouseOutboundOrderList_ysh";
	}
	
	/**
	 * 查询列表数据：待发货
	 */
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<WarehouseOutboundOrder> listData(WarehouseOutboundOrder warehouseOutboundOrder, HttpServletRequest request, HttpServletResponse response) {
		warehouseOutboundOrder.setApprovalStatus("待发货");
		Page<WarehouseOutboundOrder> page = warehouseOutboundOrderService.findPage(new Page<WarehouseOutboundOrder>(request, response), warehouseOutboundOrder); 
		return page;
	}
	
	/**
	 * 查询列表数据：待审核
	 */
	@RequestMapping(value = "listData_dsh")
	@ResponseBody
	public Page<WarehouseOutboundOrder> listData_dsh(WarehouseOutboundOrder warehouseOutboundOrder, HttpServletRequest request, HttpServletResponse response) {
		warehouseOutboundOrder.setApprovalStatus("待审核");
		Page<WarehouseOutboundOrder> page = warehouseOutboundOrderService.findPage(new Page<WarehouseOutboundOrder>(request, response), warehouseOutboundOrder); 
		return page;
	}
	
	/**
	 * 查询列表数据：已审核
	 */
	@RequestMapping(value = "listData_ysh")
	@ResponseBody
	public Page<WarehouseOutboundOrder> listData_ysh(WarehouseOutboundOrder warehouseOutboundOrder, HttpServletRequest request, HttpServletResponse response) {
		warehouseOutboundOrder.setApprovalStatus("已审核");
		Page<WarehouseOutboundOrder> page = warehouseOutboundOrderService.findPage(new Page<WarehouseOutboundOrder>(request, response), warehouseOutboundOrder); 
		return page;
	}

	/**
	 * 查看编辑表单：待发货
	 */
	@RequiresPermissions("warehouse:outboundorder:warehouseOutboundOrder:view")
	@RequestMapping(value = "form")
	public String form(WarehouseOutboundOrder warehouseOutboundOrder, Model model) {
		if(warehouseOutboundOrder.getOrderName()==null||warehouseOutboundOrder.getOrderName().equals("")){
			String orderName = "";
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mmssSSS");//设置日期格式
			orderName = "HZJC-"+LocalDateTime.now().format(fmt);
			warehouseOutboundOrder.setOrderName(orderName);
			warehouseOutboundOrder.setApprovalStatus("待发货");
		}
		model.addAttribute("warehouseOutboundOrder", warehouseOutboundOrder);
		return "modules/warehouse/outboundorder/warehouseOutboundOrderForm";
	}
	
	/**
	 * 查看编辑表单：待审核
	 */
	@RequiresPermissions("warehouse:outboundorder:warehouseOutboundOrder:view")
	@RequestMapping(value = "form_dsh")
	public String form_dsh(WarehouseOutboundOrder warehouseOutboundOrder, Model model) {
		model.addAttribute("warehouseOutboundOrder", warehouseOutboundOrder);
		return "modules/warehouse/outboundorder/warehouseOutboundOrderForm_dsh";
	}
	
	/**
	 * 查看编辑表单：已审核
	 */
	@RequiresPermissions("warehouse:outboundorder:warehouseOutboundOrder:view")
	@RequestMapping(value = "form_ysh")
	public String form_ysh(WarehouseOutboundOrder warehouseOutboundOrder, Model model) {
		model.addAttribute("warehouseOutboundOrder", warehouseOutboundOrder);
		return "modules/warehouse/outboundorder/warehouseOutboundOrderForm_ysh";
	}
	
	/**
	 * 查看编辑表单：打印
	 */
	@RequiresPermissions("warehouse:outboundorder:warehouseOutboundOrder:view")
	@RequestMapping(value = "form_print")
	public String form_print(WarehouseOutboundOrder warehouseOutboundOrder, Model model) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy年MM月dd日");//设置日期格式
		warehouseOutboundOrder.setRemarks(LocalDateTime.now().format(fmt));
		model.addAttribute("warehouseOutboundOrder", warehouseOutboundOrder);
		return "modules/warehouse/outboundorder/warehouseOutboundOrderForm_print";
	}

	/**
	 * 保存出库单表
	 */
	//@RequiresPermissions("warehouse:outboundorder:warehouseOutboundOrder:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated WarehouseOutboundOrder warehouseOutboundOrder) {
		warehouseOutboundOrderService.save(warehouseOutboundOrder);
		return renderResult(Global.TRUE, text("保存出库单表成功！"));
	}
	
	/**
	 * 删除出库单表
	 */
	//@RequiresPermissions("warehouse:outboundorder:warehouseOutboundOrder:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(WarehouseOutboundOrder warehouseOutboundOrder) {
		warehouseOutboundOrderService.delete(warehouseOutboundOrder);
		return renderResult(Global.TRUE, text("删除出库单表成功！"));
	}
	
	/**
	 * 发货
	 */
	@RequestMapping(value = "shipments")
	@ResponseBody
	public String shipments(WarehouseOutboundOrder warehouseOutboundOrder) {
		warehouseOutboundOrder = this.get(warehouseOutboundOrder.getId(), false);
		warehouseOutboundOrder.setApprovalStatus("待审核");
		warehouseOutboundOrderService.save(warehouseOutboundOrder);
		return renderResult(Global.TRUE, text("出库单发货成功！"));
	}
	
	/**
	 * 同意
	 */
	@RequestMapping(value = "agree")
	@ResponseBody
	public String agree(WarehouseOutboundOrder warehouseOutboundOrder) {
		warehouseOutboundOrder = this.get(warehouseOutboundOrder.getId(), false);
		warehouseOutboundOrder.setApprovalStatus("已审核");
		warehouseOutboundOrderService.save(warehouseOutboundOrder);
		return renderResult(Global.TRUE, text("审核同意成功！"));
	}
	
	/**
	 * 驳回
	 */
	@RequestMapping(value = "rejected")
	@ResponseBody
	public String rejected(WarehouseOutboundOrder warehouseOutboundOrder) {
		warehouseOutboundOrder = this.get(warehouseOutboundOrder.getId(), false);
		warehouseOutboundOrder.setApprovalStatus("待发货");
		warehouseOutboundOrderService.save(warehouseOutboundOrder);
		return renderResult(Global.TRUE, text("审核驳回成功！"));
	}
	
}