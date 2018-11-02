/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.entity.outboundorder;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 出库单表Entity
 * @author yzh
 * @version 2018-10-22
 */
@Table(name="warehouse_order_product", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="product_id", attrName="productId", label="货品ID"),
		@Column(name="product_name", attrName="productName", label="货品名称", queryType=QueryType.LIKE),
		@Column(name="product_num_order", attrName="productNumOrder", label="货品数量"),
		@Column(name="order_id", attrName="orderId.id", label="订单ID"),
		@Column(name="order_name", attrName="orderName", label="订单名称", queryType=QueryType.LIKE),
		@Column(name="unit", attrName="unit", label="单位"),
		@Column(name="price", attrName="price", label="零售价"),
		@Column(name="discount_rate", attrName="discountRate", label="折扣率"),
		@Column(name="exfactory_price", attrName="exfactoryPrice", label="拿货价"),
		@Column(name="subtotal", attrName="subtotal", label="小计"),
	}, orderBy="a.id ASC"
)
public class WarehouseOrderProduct extends DataEntity<WarehouseOrderProduct> {
	
	private static final long serialVersionUID = 1L;
	private String productId;		// 货品ID
	private String productName;		// 货品名称
	private Long productNumOrder;		// 货品数量
	private WarehouseOutboundOrder orderId;		// 订单ID 父类
	private String orderName;		// 订单名称
	private String unit;		// 单位
	private Double price;		// 零售价
	private Double discountRate;		// 折扣率
	private Double exfactoryPrice;		// 拿货价
	private Double subtotal;		// 小计
	
	public WarehouseOrderProduct() {
		this(null);
	}


	public WarehouseOrderProduct(WarehouseOutboundOrder orderId){
		this.orderId = orderId;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	@Length(min=0, max=255, message="货品名称长度不能超过 255 个字符")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Long getProductNumOrder() {
		return productNumOrder;
	}

	public void setProductNumOrder(Long productNumOrder) {
		this.productNumOrder = productNumOrder;
	}
	
	public WarehouseOutboundOrder getOrderId() {
		return orderId;
	}

	public void setOrderId(WarehouseOutboundOrder orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	@Length(min=0, max=50, message="单位长度不能超过 50 个字符")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}
	
	public Double getExfactoryPrice() {
		return exfactoryPrice;
	}

	public void setExfactoryPrice(Double exfactoryPrice) {
		this.exfactoryPrice = exfactoryPrice;
	}
	
	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
}