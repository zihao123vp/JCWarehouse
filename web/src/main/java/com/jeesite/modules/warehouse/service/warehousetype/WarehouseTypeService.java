/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.service.warehousetype;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.TreeService;
import com.jeesite.modules.warehouse.entity.warehousetype.WarehouseType;
import com.jeesite.modules.warehouse.dao.warehousetype.WarehouseTypeDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 库存类型表Service
 * @author yzh
 * @version 2018-09-20
 */
@Service
@Transactional(readOnly=true)
public class WarehouseTypeService extends TreeService<WarehouseTypeDao, WarehouseType> {
	
	/**
	 * 获取单条数据
	 * @param warehouseType
	 * @return
	 */
	@Override
	public WarehouseType get(WarehouseType warehouseType) {
		return super.get(warehouseType);
	}
	
	/**
	 * 查询列表数据
	 * @param warehouseType
	 * @return
	 */
	@Override
	public List<WarehouseType> findList(WarehouseType warehouseType) {
		return super.findList(warehouseType);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param warehouseType
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WarehouseType warehouseType) {
		super.save(warehouseType);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(warehouseType.getId(), "warehouseType_image");
	}
	
	/**
	 * 更新状态
	 * @param warehouseType
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(WarehouseType warehouseType) {
		super.updateStatus(warehouseType);
	}
	
	/**
	 * 删除数据
	 * @param warehouseType
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(WarehouseType warehouseType) {
		super.delete(warehouseType);
	}
	
}