/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.test.entity.TestCode;

/**
 * test_codeDAO接口
 * @author yzh
 * @version 2018-09-11
 */
@MyBatisDao
public interface TestCodeDao extends CrudDao<TestCode> {
	
}