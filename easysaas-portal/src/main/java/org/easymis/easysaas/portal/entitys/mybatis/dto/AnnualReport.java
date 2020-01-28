package org.easymis.easysaas.portal.entitys.mybatis.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonSerialize(nullsUsing = SeventeenTableJsonSerializer.class)
public class AnnualReport implements Serializable {

	private String id;
	@ApiModelProperty(value = "公司id")
	private String companyId;
	@ApiModelProperty(value = "年报年度")
	private String reportYear;
	@ApiModelProperty(value = "企业名称")
	private String companyName;
	@ApiModelProperty(value = "统一社会信用代码")
	private String creditCode;
	@ApiModelProperty(value = "注册号")
	private String regNumber;
	@ApiModelProperty(value = "企业联系电话")
	private String phoneNumber;
	@ApiModelProperty(value = "邮政编码")
	private String postcode;
	@ApiModelProperty(value = "企业通信地址")
	private String postalAddress;
	@ApiModelProperty(value = "电子邮箱")
	private String email;
	@ApiModelProperty(value = "企业经营状态")
	private String manageState;
	@ApiModelProperty(value = "从业人数")
	private String employeeNum;
	@ApiModelProperty(value = "经营者名称")
	private String operatorName;
	@ApiModelProperty(value = "资产总额")
	private String totalAssets;
	@ApiModelProperty(value = "所有者权益合计")
	private String totalEquity;
	@ApiModelProperty(value = "销售总额(营业总收入)")
	private String totalSales;
	@ApiModelProperty(value = "利润总额")
	private String totalProfit;
	@ApiModelProperty(value = "主营业务收入")
	private String primeBusProfit;
	@ApiModelProperty(value = "净利润")
	private String retainedProfit;
	@ApiModelProperty(value = "纳税总额")
	private String totalTax;
	@ApiModelProperty(value = "负债总额")
	private String totalLiability;
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	@ApiModelProperty("年报变更信息") // 一对多
	private List<ReportChangeRecord> reportChangeRecords;

	@ApiModelProperty("年报股权变更")
	private List<ReportEquityChangeInfo> reportEquityChangeInfos;

	@ApiModelProperty("年报对外投资")
	private List<ReportOutboundInvestment> reportOutboundInvestments;

	@ApiModelProperty("年报股东及出资信息")
	private List<ReportShareholder> reportShareholders;

	@ApiModelProperty("年报社保信息")
	private List<ReportSocialSecurityInfo> reportSocialSecurityInfos;

	@ApiModelProperty("年报对外担保")
	private List<ReportOutGuaranteeInfo> reportOutGuaranteeInfos;

	@ApiModelProperty("网站网店")
	private List<ReportWebinfo> reportWebinfos;

}