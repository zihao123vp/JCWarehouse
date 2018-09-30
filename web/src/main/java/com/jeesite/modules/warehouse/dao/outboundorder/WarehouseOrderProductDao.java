/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.dao.outboundorder;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.warehouse.entity.outboundorder.WarehouseOrderProduct;

/**
 * 出库单表DAO接口
 * @author yzh
 * @version 2018-09-20
 */
@MyBatisDao
public interface WarehouseOrderProductDao extends CrudDao<WarehouseOrderProduct> {
	
}