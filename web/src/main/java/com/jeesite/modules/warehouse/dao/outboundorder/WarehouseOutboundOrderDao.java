/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.dao.outboundorder;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.warehouse.entity.outboundorder.WarehouseOutboundOrder;

/**
 * 出库单表DAO接口
 * @author yzh
 * @version 2018-10-22
 */
@MyBatisDao
public interface WarehouseOutboundOrderDao extends CrudDao<WarehouseOutboundOrder> {
	
}