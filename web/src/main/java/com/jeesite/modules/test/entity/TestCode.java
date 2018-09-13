/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.test.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * test_codeEntity
 * @author yzh
 * @version 2018-09-11
 */
@Table(name="test_code", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="name", attrName="name", label="name", queryType=QueryType.LIKE),
		@Column(name="age", attrName="age", label="age"),
	}, orderBy="a.id DESC"
)
public class TestCode extends DataEntity<TestCode> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String age;		// age
	
	public TestCode() {
		this(null);
	}

	public TestCode(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="name长度不能超过 255 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=255, message="age长度不能超过 255 个字符")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}