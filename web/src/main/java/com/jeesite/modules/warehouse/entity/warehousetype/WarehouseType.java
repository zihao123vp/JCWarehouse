/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.entity.warehousetype;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.entity.TreeEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 库存类型表Entity
 * @author yzh
 * @version 2018-09-20
 */
@Table(name="warehouse_type", alias="a", columns={
		@Column(name="tree_code", attrName="treeCode", label="节点编码", isPK=true),
		@Column(includeEntity=TreeEntity.class),
		@Column(name="tree_name", attrName="treeName", label="节点名称", queryType=QueryType.LIKE, isTreeName=true),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.tree_sorts, a.tree_code"
)
public class WarehouseType extends TreeEntity<WarehouseType> {
	
	private static final long serialVersionUID = 1L;
	private String treeCode;		// 节点编码
	private String treeName;		// 节点名称
	
	public WarehouseType() {
		this(null);
	}

	public WarehouseType(String id){
		super(id);
	}
	
	@Override
	public WarehouseType getParent() {
		return parent;
	}

	@Override
	public void setParent(WarehouseType parent) {
		this.parent = parent;
	}
	
	public String getTreeCode() {
		return treeCode;
	}

	public void setTreeCode(String treeCode) {
		this.treeCode = treeCode;
	}
	
	@NotBlank(message="节点名称不能为空")
	@Length(min=0, max=200, message="节点名称长度不能超过 200 个字符")
	public String getTreeName() {
		return treeName;
	}

	public void setTreeName(String treeName) {
		this.treeName = treeName;
	}
	
}