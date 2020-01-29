package org.easymis.easysaas.portal.entitys.vo;

import io.searchbox.annotations.JestId;
import io.swagger.annotations.ApiModelProperty;

public class SearchOutput {
    @ApiModelProperty(value = "公司id")
    @JestId
    private Long companyId;
    @ApiModelProperty(value = "公司简称")
    private String alias;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区")
    private String district;
    
    @ApiModelProperty(value = "统一社会信用代码")
    private String  creditCode;
    
}
