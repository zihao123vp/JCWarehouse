/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.service.outboundorder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.warehouse.entity.outboundorder.WarehouseOutboundOrder;
import com.jeesite.modules.warehouse.dao.outboundorder.WarehouseOutboundOrderDao;
import com.jeesite.modules.warehouse.entity.outboundorder.WarehouseOrderProduct;
import com.jeesite.modules.warehouse.dao.outboundorder.WarehouseOrderProductDao;

/**
 * 出库单表Service
 * @author yzh
 * @version 2018-10-22
 */
@Service
@Transactional(readOnly=true)
public class WarehouseOutboundOrderService extends CrudService<WarehouseOutboundOrderDao, WarehouseOutboundOrder> {
	
	@Autowired
	private WarehouseOrderProductDao warehouseOrderProductDao;
	
	/**
	 * 获取单条数据
	 * @param warehouseOutboundOrder
	 * @return
	 */
	@Override
	public WarehouseOutboundOrder get(WarehouseOutboundOrder warehouseOutboundOrder) {
		WarehouseOutboundOrder entity = super.get(warehouseOutboundOrder);
		if (entity != null){
			WarehouseOrderProduct warehouseOrderProduct = new WarehouseOrderProduct(entity);
			warehouseOrderProduct.setStatus(WarehouseOrderProduct.STATUS_NORMAL);
			entity.setWarehouseOrderProductList(warehouseOrderProductDao.findList(warehouseOrderProduct));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param warehouseOutboundOrder
	 * @return
	 */
	@Override
	public Page<WarehouseOutboundOrder> findPage(Page<WarehouseOutboundOrder> page, WarehouseOutboundOrder warehouseOutboundOrder) {
		return super.findPage(page, warehouseOutboundOrder);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param warehouseOutboundOrder
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WarehouseOutboundOrder warehouseOutboundOrder) {
		super.save(warehouseOutboundOrder);
		// 保存 WarehouseOutboundOrder子表
		for (WarehouseOrderProduct warehouseOrderProduct : warehouseOutboundOrder.getWarehouseOrderProductList()){
			if (!WarehouseOrderProduct.STATUS_DELETE.equals(warehouseOrderProduct.getStatus())){
				warehouseOrderProduct.setOrderId(warehouseOutboundOrder);
				if (warehouseOrderProduct.getIsNewRecord()){
					warehouseOrderProduct.preInsert();
					warehouseOrderProductDao.insert(warehouseOrderProduct);
				}else{
					warehouseOrderProduct.preUpdate();
					warehouseOrderProductDao.update(warehouseOrderProduct);
				}
			}else{
				warehouseOrderProductDao.delete(warehouseOrderProduct);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param warehouseOutboundOrder
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(WarehouseOutboundOrder warehouseOutboundOrder) {
		super.updateStatus(warehouseOutboundOrder);
	}
	
	/**
	 * 删除数据
	 * @param warehouseOutboundOrder
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(WarehouseOutboundOrder warehouseOutboundOrder) {
		super.delete(warehouseOutboundOrder);
		WarehouseOrderProduct warehouseOrderProduct = new WarehouseOrderProduct();
		warehouseOrderProduct.setOrderId(warehouseOutboundOrder);
		warehouseOrderProductDao.delete(warehouseOrderProduct);
	}
	
}