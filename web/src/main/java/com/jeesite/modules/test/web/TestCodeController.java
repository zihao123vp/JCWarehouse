/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.test.entity.TestCode;
import com.jeesite.modules.test.service.TestCodeService;

/**
 * test_codeController
 * @author yzh
 * @version 2018-09-11
 */
@Controller
@RequestMapping(value = "${adminPath}/test/testCode")
public class TestCodeController extends BaseController {

	@Autowired
	private TestCodeService testCodeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TestCode get(String id, boolean isNewRecord) {
		return testCodeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("test:testCode:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestCode testCode, Model model) {
		model.addAttribute("testCode", testCode);
		return "modules/test/testCodeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("test:testCode:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TestCode> listData(TestCode testCode, HttpServletRequest request, HttpServletResponse response) {
		Page<TestCode> page = testCodeService.findPage(new Page<TestCode>(request, response), testCode); 
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("test:testCode:view")
	@RequestMapping(value = "form")
	public String form(TestCode testCode, Model model) {
		model.addAttribute("testCode", testCode);
		return "modules/test/testCodeForm";
	}

	/**
	 * 保存test_code
	 */
	@RequiresPermissions("test:testCode:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TestCode testCode) {
		testCodeService.save(testCode);
		return renderResult(Global.TRUE, text("保存test_code成功！"));
	}
	
	/**
	 * 删除test_code
	 */
	@RequiresPermissions("test:testCode:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TestCode testCode) {
		testCodeService.delete(testCode);
		return renderResult(Global.TRUE, text("删除test_code成功！"));
	}
	
}