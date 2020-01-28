package org.easymis.easysaas.portal.entitys.mybatis.dto;
import java.io.Serializable;
import java.util.Date;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data; 
 
  
@Data
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
 public class AnnualReport implements Serializable{  

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
      private Date createTime; 
     
}