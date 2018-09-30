/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.service.merchant;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.warehouse.entity.merchant.WarehouseMerchant;
import com.jeesite.modules.warehouse.dao.merchant.WarehouseMerchantDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 经销商信息表Service
 * @author yzh
 * @version 2018-09-20
 */
@Service
@Transactional(readOnly=true)
public class WarehouseMerchantService extends CrudService<WarehouseMerchantDao, WarehouseMerchant> {
	
	/**
	 * 获取单条数据
	 * @param warehouseMerchant
	 * @return
	 */
	@Override
	public WarehouseMerchant get(WarehouseMerchant warehouseMerchant) {
		return super.get(warehouseMerchant);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param warehouseMerchant
	 * @return
	 */
	@Override
	public Page<WarehouseMerchant> findPage(Page<WarehouseMerchant> page, WarehouseMerchant warehouseMerchant) {
		return super.findPage(page, warehouseMerchant);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param warehouseMerchant
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WarehouseMerchant warehouseMerchant) {
		super.save(warehouseMerchant);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(warehouseMerchant.getId(), "warehouseMerchant_image");
	}
	
	/**
	 * 更新状态
	 * @param warehouseMerchant
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(WarehouseMerchant warehouseMerchant) {
		super.updateStatus(warehouseMerchant);
	}
	
	/**
	 * 删除数据
	 * @param warehouseMerchant
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(WarehouseMerchant warehouseMerchant) {
		super.delete(warehouseMerchant);
	}
	
}