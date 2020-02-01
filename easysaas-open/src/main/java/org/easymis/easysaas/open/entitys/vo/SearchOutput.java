package org.easymis.easysaas.open.entitys.vo;

import io.searchbox.annotations.JestId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class SearchOutput {
    @ApiModelProperty(value = "公司id")
    @JestId
    private String companyId;
    @ApiModelProperty(value = "公司简称")
    private String alias;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "法人姓名")
    private String legalPersonName;
    @ApiModelProperty(value = "公司名称(高亮)")
    private String nameHighlight;
    @ApiModelProperty(value = "法人名称(高亮)")
    private String legalPersonNameHighlight;
    
    @ApiModelProperty(value = "联系电话")
    private String telephone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "网站")
    private String website;
    @ApiModelProperty(value = "地址")
    private String address;
    
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区")
    private String district;
    
    @ApiModelProperty(value = "统一社会信用代码")
    private String  creditCode;
    
}
