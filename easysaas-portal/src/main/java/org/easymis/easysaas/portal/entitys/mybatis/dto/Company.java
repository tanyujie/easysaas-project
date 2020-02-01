package org.easymis.easysaas.portal.entitys.mybatis.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;


    private String companyId; 
    @ApiModelProperty(value = "归属省份的首字母小写") 
    private String base; 
    @ApiModelProperty(value = "公司名称") 
    private String companyName; 
    @ApiModelProperty(value = "法人ID")
    private Integer legalPersonId; 
    @ApiModelProperty(value = "法人姓名") 
    private String legalPersonName; 
    @ApiModelProperty(value = "法人类型，1 人 2 公司")
    private Integer legalPersonType; 
    @ApiModelProperty(value = "注册号")
    private String registerNumber; 
    @ApiModelProperty(value = "公司类型代码")
    private Integer companyType; 
    @ApiModelProperty(value = "公司类型")
    private String companyOrgType; 
    @ApiModelProperty(value = "注册地址")
    private String registerLocation; 
    @ApiModelProperty(value = "成立日期")
    private Date estiblishTime; 
    @ApiModelProperty(value = "营业期限开始日期") 
    private Date fromTime; 
    @ApiModelProperty(value = "营业期限终止日期")
    private Date toTime; 
    @ApiModelProperty(value = "经营范围") 
    private String businessScope; 
    @ApiModelProperty(value = "登记机关")
    private String registerInstitute; 
    @ApiModelProperty(value = "核准日期")
    private Date approvedTime; 
    @ApiModelProperty(value = "企业状态")
    private String registerStatus; 
    @ApiModelProperty(value = "注册资金")
    private String registerCapital; 
    @ApiModelProperty(value = "组织机构代码") 
    private String orgNumber; 
    @ApiModelProperty(value = "")
    private String orgApprovedInstitute; 
    @ApiModelProperty(value = "1表示parse过，0表示没parse，3表示parse出错")
    private String flag; 
    @ApiModelProperty(value = "上级机构ID")
    private Integer parentId; 
    @ApiModelProperty(value = "修改时间")
    private Date updateTime; 
    @ApiModelProperty(value = "上市代码")
    private String listCode; 
    @ApiModelProperty(value = "母公司控股比例")
    private String ownershipStake; 
    @ApiModelProperty(value = "数据来源标志")
    private String sourceFlag; 
    @ApiModelProperty(value = "根据名称parse出的公司后缀类型")
    private String nameSuffix; 
    @ApiModelProperty(value = "统一社会信用代码")
    private String creditCode; 
    @ApiModelProperty(value = "新公司名id")
    private String property2; 
    @ApiModelProperty(value = "英文名") 
    private String property3; 
    @ApiModelProperty(value = "纳税人识别号")
    private String property4; 
    @ApiModelProperty(value = "通过工商app抓取时间")
    private String property5; 
    @ApiModelProperty(value = "解析完成时间")
    private Date crawledtime; 
    @ApiModelProperty(value = "实收注册资金")
    private String actualCapital; 
    @ApiModelProperty(value = "联系电话")
    private String phone; 
    @ApiModelProperty(value = "邮件")
    private String email; 
    @ApiModelProperty(value = "省")
    private String province; 
    @ApiModelProperty(value = "城市") 
    private String city; 
    @ApiModelProperty(value = "区县") 
    private String district; 
    @ApiModelProperty(value = "")
    private String categoryCode; 
    @ApiModelProperty(value = "第一业态")
    private String categoryFirst; 
    @ApiModelProperty(value = "第二业态") 
    private String categorySecond; 
    @ApiModelProperty(value = "第三业态") 
    private String categoryThird; 
    @ApiModelProperty(value = "简称") 
    private String alias; 
}
