/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 货品信息表Entity
 * @author yzh
 * @version 2018-09-20
 */
@Table(name="warehouse_product", alias="a", columns={
		@Column(name="id", attrName="id", label="商品ID", isPK=true),
		@Column(name="product_name", attrName="productName", label="商品名称", queryType=QueryType.LIKE),
		@Column(name="type_id", attrName="typeId", label="货品分类ID"),
		@Column(name="type_name", attrName="typeName", label="所属分类", queryType=QueryType.LIKE),
		@Column(name="unit", attrName="unit", label="单位"),
		@Column(name="specification", attrName="specification", label="规格"),
		@Column(name="retail_price", attrName="retailPrice", label="零售价"),
		@Column(name="wholesale_price", attrName="wholesalePrice", label="批发价"),
		@Column(name="discount_rate", attrName="discountRate", label="折扣率"),
		@Column(name="cost_price", attrName="costPrice", label="成本价"),
		@Column(includeEntity=DataEntity.class),
		@Column(name="inventory_num", attrName="inventoryNum", label="库存数量"),
	}, orderBy="a.update_date DESC"
)
public class WarehouseProduct extends DataEntity<WarehouseProduct> {
	
	private static final long serialVersionUID = 1L;
	private String productName;		// 商品名称
	private String typeId;		// 货品分类ID
	private String typeName;		// 所属分类
	private String unit;		// 单位
	private String specification;		// 规格
	private Double retailPrice;		// 零售价
	private Double wholesalePrice;		// 批发价
	private Double discountRate;		// 折扣率
	private Double costPrice;		// 成本价
	private Long inventoryNum;		// 库存数量
	
	public WarehouseProduct() {
		this(null);
	}

	public WarehouseProduct(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="商品名称长度不能超过 255 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	@Length(min=0, max=255, message="所属分类长度不能超过 255 个字符")
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	@Length(min=0, max=255, message="单位长度不能超过 255 个字符")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Length(min=0, max=255, message="规格长度不能超过 255 个字符")
	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	public Double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(Double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}
	
	public Double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}
	
	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	
	public Long getInventoryNum() {
		return inventoryNum;
	}

	public void setInventoryNum(Long inventoryNum) {
		this.inventoryNum = inventoryNum;
	}
	
}