/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.warehouse.entity.WarehouseProduct;
import com.jeesite.modules.warehouse.dao.WarehouseProductDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 货品信息表Service
 * @author yzh
 * @version 2018-09-20
 */
@Service
@Transactional(readOnly=true)
public class WarehouseProductService extends CrudService<WarehouseProductDao, WarehouseProduct> {
	
	/**
	 * 获取单条数据
	 * @param warehouseProduct
	 * @return
	 */
	@Override
	public WarehouseProduct get(WarehouseProduct warehouseProduct) {
		return super.get(warehouseProduct);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param warehouseProduct
	 * @return
	 */
	@Override
	public Page<WarehouseProduct> findPage(Page<WarehouseProduct> page, WarehouseProduct warehouseProduct) {
		return super.findPage(page, warehouseProduct);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param warehouseProduct
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WarehouseProduct warehouseProduct) {
		super.save(warehouseProduct);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(warehouseProduct.getId(), "warehouseProduct_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(warehouseProduct.getId(), "warehouseProduct_file");
	}
	
	/**
	 * 更新状态
	 * @param warehouseProduct
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(WarehouseProduct warehouseProduct) {
		super.updateStatus(warehouseProduct);
	}
	
	/**
	 * 删除数据
	 * @param warehouseProduct
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(WarehouseProduct warehouseProduct) {
		super.delete(warehouseProduct);
	}
	
}