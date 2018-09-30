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
 * @version 2018-09-20
 */
@Table(name="warehouse_order_product", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="product_id", attrName="productId", label="货品ID"),
		@Column(name="product_name", attrName="productName", label="货品名称", queryType=QueryType.LIKE),
		@Column(name="product_num", attrName="productNum", label="货品数量"),
		@Column(name="order_id", attrName="orderId.id", label="订单ID"),
		@Column(name="order_name", attrName="orderName", label="订单名称", queryType=QueryType.LIKE),
		@Column(name="price", attrName="price", label="单价"),
		@Column(name="subtotal", attrName="subtotal", label="小计"),
	}, orderBy="a.id ASC"
)
public class WarehouseOrderProduct extends DataEntity<WarehouseOrderProduct> {
	
	private static final long serialVersionUID = 1L;
	private String productId;		// 货品ID
	private String productName;		// 货品名称
	private Long productNum;		// 货品数量
	private WarehouseOutboundOrder orderId;		// 订单ID 父类
	private String orderName;		// 订单名称
	private Double price;		// 单价
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
	
	public Long getProductNum() {
		return productNum;
	}

	public void setProductNum(Long productNum) {
		this.productNum = productNum;
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
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	
}