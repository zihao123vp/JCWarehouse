/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.dao.merchant;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.warehouse.entity.merchant.WarehouseMerchant;

/**
 * 经销商信息表DAO接口
 * @author yzh
 * @version 2018-09-20
 */
@MyBatisDao
public interface WarehouseMerchantDao extends CrudDao<WarehouseMerchant> {
	
}