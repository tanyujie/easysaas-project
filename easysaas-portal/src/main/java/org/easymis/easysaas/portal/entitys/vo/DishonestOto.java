package org.easymis.easysaas.portal.entitys.vo;

import io.searchbox.annotations.JestId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class DishonestOto {
    @ApiModelProperty(value = "id")
    @JestId
    private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "名称(高亮)")
    private String nameHighlight;
    @ApiModelProperty(value = "姓")
    private String familyName;
    @ApiModelProperty(value = "身份证号码/公司信用代码")
    private String cardCode;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "失信人类型1代表公司,2代表人")
    private Integer dishonestType;
    @ApiModelProperty(value = "出生年份")
    private String birthYear;
    
	public String getFamilyName() {
		if (dishonestType!=null&&dishonestType == 2)
			return name.substring(0, 1);
		else
			return "";
	}
	public String getBirthYear() {
		if (dishonestType!=null&&dishonestType == 2)
			return cardCode.substring(6, 10)+"年出生";
		else
			return "";
	}
    
}
