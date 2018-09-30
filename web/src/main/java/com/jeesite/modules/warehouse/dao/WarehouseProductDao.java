/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.warehouse.entity.WarehouseProduct;

/**
 * 货品信息表DAO接口
 * @author yzh
 * @version 2018-09-20
 */
@MyBatisDao
public interface WarehouseProductDao extends CrudDao<WarehouseProduct> {
	
}