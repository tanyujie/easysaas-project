package org.easymis.easysaas.open.entitys.mybatis.dto;
import java.io.Serializable;
import java.util.Date;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors; 
 
  
  
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class) 
public class CompanyIcp implements Serializable {

	private String id;
	@ApiModelProperty("如果存在 company_id 为真是id，如果不存在但是是企业  company_id为1 ，如果是个人则为0")
	private String companyId;
	@ApiModelProperty(" icp_id ")
	private Integer icpId;
	@ApiModelProperty("")
	private String companyName;
	@ApiModelProperty("")
	private String companyType;
	@ApiModelProperty("")
	private String liscense;
	@ApiModelProperty("")
	private String webName;
	@ApiModelProperty("")
	private String webSite;
	@ApiModelProperty("")
	private String examineDate;
	@ApiModelProperty("主办单位名称（个人，企业）")
	private String organizerName;
	@ApiModelProperty("主体id")
	private Integer organizerId;
	@ApiModelProperty("单位性质（个人，企业）")
	private String organizerKind;
	@ApiModelProperty("主体备案/许可证号")
	private String icpMain;
	@ApiModelProperty("网站id")
	private Integer webSiteId;
	@ApiModelProperty("网站名称")
	private String webSiteName;
	@ApiModelProperty("网站负责人")
	private String responsible;
	@ApiModelProperty("网站首页网址")
	private String siteUrl;
	@ApiModelProperty("域名")
	private String domainName;
	@ApiModelProperty("网站备案/许可证号")
	private String icpNo;
	@ApiModelProperty("审核时间")
	private Date checkTime;
	@ApiModelProperty("省")
	private String provinceId;
	@ApiModelProperty("市")
	private String cityId;
	@ApiModelProperty("县")
	private String districtId;
	@ApiModelProperty("地址")
	private String address;
	@ApiModelProperty("域名id")
	private Integer domainId;
	@ApiModelProperty("更新时间")
	private Date updateTime;
	@ApiModelProperty("")
	private Date createTime;

}