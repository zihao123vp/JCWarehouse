/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.entity.outboundorder;

import org.hibernate.validator.constraints.Length;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 出库单表Entity
 * @author yzh
 * @version 2018-10-22
 */
@Table(name="warehouse_outbound_order", alias="a", columns={
		@Column(name="id", attrName="id", label="订单ID", isPK=true),
		@Column(name="order_name", attrName="orderName", label="订单名称", queryType=QueryType.LIKE),
		@Column(name="outbound_type", attrName="outboundType", label="出库单类型"),
		@Column(name="payment_status", attrName="paymentStatus", label="付款状态"),
		@Column(name="payment_type", attrName="paymentType", label="付款方式"),
		@Column(name="merchant_id", attrName="merchantId", label="经销商ID"),
		@Column(name="merchant_name", attrName="merchantName", label="经销商名称", queryType=QueryType.LIKE),
		@Column(name="merchant_phone", attrName="merchantPhone", label="联系电话"),
		@Column(name="merchant_address", attrName="merchantAddress", label="联系地址"),
		@Column(name="product_num", attrName="productNum", label="订单商品数"),
		@Column(name="order_price", attrName="orderPrice", label="订单总价"),
		@Column(name="merchant_price_receivable", attrName="merchantPriceReceivable", label="应付金额"),
		@Column(name="merchant_price_received", attrName="merchantPriceReceived", label="收款金额"),
		@Column(name="discount", attrName="discount", label="优惠=应收-实收"),
		@Column(name="approval_status", attrName="approvalStatus", label="审批状态", comment="审批状态：待发货、待审核、已审核"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class WarehouseOutboundOrder extends DataEntity<WarehouseOutboundOrder> {
	
	private static final long serialVersionUID = 1L;
	private String orderName;		// 订单名称
	private String outboundType;		// 出库单类型
	private String paymentStatus;		// 付款状态
	private String paymentType;		// 付款方式
	private String merchantId;		// 经销商ID
	private String merchantName;		// 经销商名称
	private String merchantPhone;		// 联系电话
	private String merchantAddress;		// 联系地址
	private Long productNum;		// 订单商品数
	private Double orderPrice;		// 订单总价
	private Double merchantPriceReceivable;		// 应付金额
	private Double merchantPriceReceived;		// 收款金额
	private Double discount;		// 优惠=应收-实收
	private String approvalStatus;		// 审批状态：待发货、待审核、已审核
	private List<WarehouseOrderProduct> warehouseOrderProductList = ListUtils.newArrayList();		// 子表列表
	
	public WarehouseOutboundOrder() {
		this(null);
	}

	public WarehouseOutboundOrder(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="订单名称长度不能超过 255 个字符")
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	@Length(min=0, max=255, message="出库单类型长度不能超过 255 个字符")
	public String getOutboundType() {
		return outboundType;
	}

	public void setOutboundType(String outboundType) {
		this.outboundType = outboundType;
	}
	
	@Length(min=0, max=50, message="付款状态长度不能超过 50 个字符")
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	@Length(min=0, max=50, message="付款方式长度不能超过 50 个字符")
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	
	@Length(min=0, max=255, message="经销商名称长度不能超过 255 个字符")
	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	@Length(min=0, max=30, message="联系电话长度不能超过 30 个字符")
	public String getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}
	
	@Length(min=0, max=255, message="联系地址长度不能超过 255 个字符")
	public String getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}
	
	public Long getProductNum() {
		return productNum;
	}

	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	
	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public Double getMerchantPriceReceivable() {
		return merchantPriceReceivable;
	}

	public void setMerchantPriceReceivable(Double merchantPriceReceivable) {
		this.merchantPriceReceivable = merchantPriceReceivable;
	}
	
	public Double getMerchantPriceReceived() {
		return merchantPriceReceived;
	}

	public void setMerchantPriceReceived(Double merchantPriceReceived) {
		this.merchantPriceReceived = merchantPriceReceived;
	}
	
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	@Length(min=0, max=10, message="审批状态长度不能超过 10 个字符")
	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	public List<WarehouseOrderProduct> getWarehouseOrderProductList() {
		return warehouseOrderProductList;
	}

	public void setWarehouseOrderProductList(List<WarehouseOrderProduct> warehouseOrderProductList) {
		this.warehouseOrderProductList = warehouseOrderProductList;
	}
	
}