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
 public class CopyrightWorks implements Serializable{  

      private String id; 
      @ApiModelProperty("公司id")
      private String companyId; 
      @ApiModelProperty("登记号")
      private String registerNo; 
      @ApiModelProperty("作品名称")
      private String name; 
      @ApiModelProperty("作品类别") 
      private String type; 
      @ApiModelProperty("著作权人姓名/名称")
      private String author; 
      @ApiModelProperty("创作完成日期") 
      private Date finishTime; 
      @ApiModelProperty("首次发表日期")
      private Date firstPublishTime; 
      @ApiModelProperty("登记日期")
      private Date registerTime; 
      @ApiModelProperty("发布日期")
      private Date publishTime; 
      @ApiModelProperty("国籍") 
      private String country; 
      @ApiModelProperty("省份")
      private String province; 
      @ApiModelProperty("城市")
      private String city; 
      @ApiModelProperty("作者姓名/名称")
      private String writer; 
      @ApiModelProperty("来源链接")
      private String sourceUrl; 
      @ApiModelProperty("是否删除 0否 1是") 
      private Boolean deleted; 
      @ApiModelProperty("抓取时间")
      private Date updateTime; 
      @ApiModelProperty("创建时间")
      private Date createTime; 
      
}