package org.easymis.easycrm.common.entitys.mybatis.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.easymis.easycrm.common.utils.json.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zh
 * @title: CompanyAllInfoOutputDTO
 * @projectName companydata
 * @description: 企业信息输出
 * @date 2019/7/13 9:31
 */
@Data
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyAllInfoOutputVo {
	private Long id;

	@ApiModelProperty("上级机构ID")
	private Long parentId;

	@ApiModelProperty("归属省份的首字母小写")
	private String base;

	@ApiModelProperty("公司名称")
	private String name;

	@ApiModelProperty("法人ID")
	private Long legalPersonId;

	@ApiModelProperty("法人姓名")
	private String legalPersonName;

	@ApiModelProperty("法人类型，1 人 2 公司")
	private Integer legalPersonType;

	@ApiModelProperty("注册号")
	private String regNumber;

	@ApiModelProperty("公司类型代码")
	private Integer companyType;

	@ApiModelProperty("公司类型")
	private String companyOrgType;

	@ApiModelProperty("注册地址")
	private String regLocation;

	@ApiModelProperty("成立日期")
	private LocalDateTime estiblishTime;

	@ApiModelProperty("营业期限开始日期")
	private LocalDateTime fromTime;

	@ApiModelProperty("营业期限终止日期")
	private LocalDateTime toTime;

	@ApiModelProperty("经营范围")
	private String businessScope;

	@ApiModelProperty("登记机关")
	private String regInstitute;

	@ApiModelProperty("核准日期")
	private LocalDateTime approvedTime;

	@ApiModelProperty("企业状态")
	private String regStatus;

	@ApiModelProperty("组织机构代码")
	private String orgNumber;

	@ApiModelProperty("上级机构ID")
	private String orgApprovedInstitute;

	@ApiModelProperty("上市代码")
	private String listCode;

	@ApiModelProperty("母公司控股比例")
	private String ownershipStake;
	@ApiModelProperty("更新时间")
	private LocalDateTime updatetime;

	@ApiModelProperty("注册资本")
	private String regCapital;

	@ApiModelProperty("实缴资本")
	private String actualCapital;

	/*****************业态信息******************/
	@ApiModelProperty("业态编码")
	private String categoryCode;
	@ApiModelProperty("门类")
	private String cate1;
	@ApiModelProperty("大类")
	private String cate2;
	@ApiModelProperty("中类")
	private String cate3;
	/*****************区域信息******************/
	@ApiModelProperty("地区码")
	private String areaCode;
	@ApiModelProperty("省")
	private String province;
	@ApiModelProperty("市")
	private String city;
	@ApiModelProperty("区")
	private String district;
	/*****************GPS******************/
	@ApiModelProperty("经度")
	private BigDecimal lat;
	@ApiModelProperty("纬度")
	private BigDecimal lng;
	/*********cleanInfo*******************/
	@ApiModelProperty("实收资本计算来源 1工商基本信息 2股东出资实缴总额 3实缴制企业实收资本=注册资本")
	private Integer actualCapitalSource;

	@ApiModelProperty("纳税人资质")
	private String taxQualification;

	@ApiModelProperty("人员规模（如1000-4999）")
	private String staffNumRange;

	@ApiModelProperty("人员规模计算来源 1招聘 2社保参保人数")
	private Integer staffNumRangeSource;

	@ApiModelProperty("社保参保人数")
	private Integer socialSecurityStaffNum;

	@ApiModelProperty("是否是小微企业 0不是 1是")
	private Integer isMicroEnt;

	@ApiModelProperty("简称")
	private String alias;

	@ApiModelProperty("经营地址")
	private String businessAddress;

	@ApiModelProperty("统一社会信用代码")
	private String property1;

	@ApiModelProperty("新公司名id")
	private String property2;

	@ApiModelProperty("英文名")
	private String property3;

	@ApiModelProperty("纳税人识别号")
	private String property4;

	@ApiModelProperty("logo地址")
	private String logoUrl;


}
