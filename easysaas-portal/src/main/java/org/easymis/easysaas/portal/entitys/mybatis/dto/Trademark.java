package org.easymis.easysaas.portal.entitys.mybatis.dto;
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
 public class Trademark implements Serializable{  

      private String id; 
      @ApiModelProperty("公司id")
      private String companyId; 
      @ApiModelProperty("注册号") 
      private String registerNo; 
      @ApiModelProperty("国际分类")
      private Integer internationalCategory; 
      @ApiModelProperty("商标名")
      private String tradeName; 
      @ApiModelProperty("申请日期") 
      private Date appDate; 
      @ApiModelProperty("申请人中文") 
      private String applicantCn; 
      @ApiModelProperty("申请人地址中文")
      private String addressCn; 
      @ApiModelProperty("共有申请人1")
      private String applicantOther1; 
      @ApiModelProperty("共有申请人2")
      private String applicantOther2; 
      @ApiModelProperty("申请人英文")
      private String applicantEn; 
      @ApiModelProperty("申请人地址英文") 
      private String addressEn; 
      @ApiModelProperty("初审公告期号")
      private Integer announcemenIssue; 
      @ApiModelProperty("初审公告日期")
      private Date announcementDate; 
      @ApiModelProperty("注册公告期号")
      private Integer registerIssue; 
      @ApiModelProperty("注册公告日期") 
      private Date registerDate; 
      @ApiModelProperty("专用权期限开始日期")
      private Date privateDateStart; 
      @ApiModelProperty("专用权期限结束日期")
      private Date privateDateEnd; 
      @ApiModelProperty("代理人名称") 
      private String agent; 
      @ApiModelProperty("商标类型 0-普通商标 1-特殊商标 2-集体商标 3-证明商标 4-立体商标 5-声音商标")
      private Integer category; 
      @ApiModelProperty("后期指定日期") 
      private String lateSpecifiedDate; 
      @ApiModelProperty("国际注册日期")
      private String internationalRegisterDate; 
      @ApiModelProperty("优先权日期")
      private String priorityDate; 
      @ApiModelProperty("指定颜色")
      private String color; 
      @ApiModelProperty("商标状态 1:有效；2:无效；3:待审；4:不定  5-未知状态")
      private Integer status; 
      @ApiModelProperty("商标来源")
      private String source; 
      @ApiModelProperty("入库时间")
      private Date crawlTime; 
      @ApiModelProperty("更新时间") 
      private Date updateTime; 
      @ApiModelProperty("0不删除 1删除") 
      private Boolean deleted; 
     
}