/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.warehouse.entity.merchant;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 经销商信息表Entity
 * @author yzh
 * @version 2018-09-20
 */
@Table(name="warehouse_merchant", alias="a", columns={
		@Column(name="id", attrName="id", label="经销商ID", isPK=true),
		@Column(name="merchant_name", attrName="merchantName", label="经销商名称", queryType=QueryType.LIKE),
		@Column(name="merchant_contact", attrName="merchantContact", label="经销商联系人"),
		@Column(name="address", attrName="address", label="地址"),
		@Column(name="phone", attrName="phone", label="联系方式"),
		@Column(name="province_id", attrName="provinceId", label="省ID"),
		@Column(name="province_name", attrName="provinceName", label="省", queryType=QueryType.LIKE),
		@Column(name="city_id", attrName="cityId", label="城市ID"),
		@Column(name="city_name", attrName="cityName", label="城市", queryType=QueryType.LIKE),
		@Column(name="fixed_discount", attrName="fixedDiscount", label="经销商固定折扣"),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class WarehouseMerchant extends DataEntity<WarehouseMerchant> {
	
	private static final long serialVersionUID = 1L;
	private String merchantName;		// 经销商名称
	private String merchantContact;		// 经销商联系人
	private String address;		// 地址
	private String phone;		// 联系方式
	private String provinceId;		// 省ID
	private String provinceName;		// 省
	private String cityId;		// 城市ID
	private String cityName;		// 城市
	private Double fixedDiscount;		// 经销商固定折扣
	
	public WarehouseMerchant() {
		this(null);
	}

	public WarehouseMerchant(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="经销商名称长度不能超过 255 个字符")
	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	@Length(min=0, max=64, message="经销商联系人长度不能超过 64 个字符")
	public String getMerchantContact() {
		return merchantContact;
	}

	public void setMerchantContact(String merchantContact) {
		this.merchantContact = merchantContact;
	}
	
	@Length(min=0, max=255, message="地址长度不能超过 255 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=20, message="联系方式长度不能超过 20 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
	@Length(min=0, max=64, message="省长度不能超过 64 个字符")
	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	@Length(min=0, max=64, message="城市长度不能超过 64 个字符")
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public Double getFixedDiscount() {
		return fixedDiscount;
	}

	public void setFixedDiscount(Double fixedDiscount) {
		this.fixedDiscount = fixedDiscount;
	}
	
}