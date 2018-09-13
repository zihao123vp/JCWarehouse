/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.test.entity.TestCode;
import com.jeesite.modules.test.dao.TestCodeDao;

/**
 * test_codeService
 * @author yzh
 * @version 2018-09-11
 */
@Service
@Transactional(readOnly=true)
public class TestCodeService extends CrudService<TestCodeDao, TestCode> {
	
	/**
	 * 获取单条数据
	 * @param testCode
	 * @return
	 */
	@Override
	public TestCode get(TestCode testCode) {
		return super.get(testCode);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param testCode
	 * @return
	 */
	@Override
	public Page<TestCode> findPage(Page<TestCode> page, TestCode testCode) {
		return super.findPage(page, testCode);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param testCode
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TestCode testCode) {
		super.save(testCode);
	}
	
	/**
	 * 更新状态
	 * @param testCode
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TestCode testCode) {
		super.updateStatus(testCode);
	}
	
	/**
	 * 删除数据
	 * @param testCode
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TestCode testCode) {
		super.delete(testCode);
	}
	
}