/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.dao.warehousetype;

import com.jeesite.common.dao.TreeDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.warehouse.entity.warehousetype.WarehouseType;

/**
 * 库存类型表DAO接口
 * @author yzh
 * @version 2018-09-20
 */
@MyBatisDao
public interface WarehouseTypeDao extends TreeDao<WarehouseType> {
	
}