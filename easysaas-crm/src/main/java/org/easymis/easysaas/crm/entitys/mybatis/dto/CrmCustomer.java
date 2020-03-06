package org.easymis.easysaas.crm.entitys.mybatis.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CrmCustomer implements Serializable {
	//@GenField(labelname = "完整地址", column = "address", length = 255, isnull = true)
	private String address;
	//@GenField(labelname = "年营业额", column = "annual_revenue", length = 45, isnull = true)
	private String annualRevenue;
	//@GenField(labelname = "开户行", column = "bank_name", length = 60, isnull = true)
	private String bankName;
	//@GenField(labelname = "银行账号", column = "bank_no", length = 45, isnull = true)
	private String bankNo;
	//@GenField(labelname = "级别:1A(重点客户),B(普通客户),C(非优先客户)", column = "category_id", length = 40, isnull = true)
	private String categoryId;
	//@GenField(labelname = "所属城市", column = "city_id", length = 20, isnull = true)
	private String cityId;
	//@GenField(labelname = "企业编码|身份证号", column = "code", length = 45, isnull = true)
	private String code;
	//@GenField(labelname = "所属国家-------", column = "country_id", length = 20, isnull = true)
	private String countryId;
	//@GenField(labelname = "建立时间", column = "create_time", isnull = false)
	private Date createTime;
	//@GenField(labelname = "创建者id", column = "creator_id", length = 40, isnull = false)
	private String creatorId;
	//@GenField(labelname = "客户id", column = "customer_id", id = true, length = 40, isnull = false)
	private String customerId;
	//@GenField(labelname = "企业名称|姓名", column = "customer_name", length = 100, isnull = false)
	private String customerName;
	//@GenField(labelname = "删除人id", column = "delete_id", length = 20, isnull = true)
	private String deleteId;
	//@GenField(labelname = "删除时间", column = "delete_time", isnull = true)
	private Date deleteTime;
	//@GenField(labelname = "备注", column = "depict", length = 65535, isnull = true)
	private String depict;
	//@GenField(labelname = "区", column = "district_id", length = 20, isnull = true)
	private String districtId;
	//@GenField(labelname = "电子邮箱", column = "email", length = 45, isnull = true)
	private String email;
	//@GenField(labelname = "传真", column = "fax", length = 45, isnull = true)
	private String fax;
	//@GenField(labelname = "", column = "industry_id", length = 40, isnull = true)
	private String industryId;
	//@GenField(labelname = "1个人客户2企业客户", column = "kind_id", isnull = true)
	private Integer kindId;
	//@GenField(labelname = "行业", column = "level1_industry_id", length = 20, isnull = true)
	private String level1IndustryId;
	//@GenField(labelname = "行业2级", column = "level2_industry_id", length = 20, isnull = true)
	private String level2IndustryId;
	//@GenField(labelname = "行业3级", column = "level3_industry_id", length = 20, isnull = true)
	private String level3IndustryId;
	//@GenField(labelname = "是否锁定1锁定", column = "locked", isnull = true)
	private Integer locked;
	//@GenField(labelname = "组织机构代码", column = "org_id", length = 45, isnull = false)
	private String orgId;
	//@GenField(labelname = "客户信息来源", column = "origin_id", length = 150, isnull = true)
	private String originId;
	//@GenField(labelname = "所有者|负责人id", column = "owner_id", length = 40, isnull = true)
	private String ownerId;
	//@GenField(labelname = "企业类型(1外资(欧美),2外资(非欧美),3合资,4国企5民营公司6外企代表处7政府机关,8事业单位9非营利组织10上市公司11创业公司)", column = "ownership", isnull = true)
	private Integer ownership;
	//@GenField(labelname = "联系电话", column = "phone", length = 100, isnull = true)
	private String phone;
	//@GenField(labelname = "所属省份", column = "province_id", length = 20, isnull = true)
	private String provinceId;
	//@GenField(labelname = "企业qq", column = "qq", length = 45, isnull = true)
	private String qq;
	//@GenField(labelname = "", column = "rating", length = 150, isnull = true)
	private String rating;
	//@GenField(labelname = "注册地址|身份证地址", column = "register_address", length = 255, isnull = true)
	private String registerAddress;
	//@GenField(labelname = "状态0删除1基础2潜在3成功4冻结5失败", column = "status", isnull = true)
	private Integer status;
	//@GenField(labelname = "通信地址|客户联系地址[街道信息]", column = "street", length = 100, isnull = true)
	private String street;
	//@GenField(labelname = "税号", column = "tax_no", length = 45, isnull = true)
	private String taxNo;
	//@GenField(labelname = "修改人id", column = "update_id", length = 20, isnull = true)
	private String updateId;
	//@GenField(labelname = "更新时间", column = "update_time", isnull = true)
	private Date updateTime;
	//@GenField(labelname = "网站", column = "url", length = 45, isnull = true)
	private String url;
	//@GenField(labelname = "邮编", column = "zip_code", length = 20, isnull = true)
	private String zipCode;

}