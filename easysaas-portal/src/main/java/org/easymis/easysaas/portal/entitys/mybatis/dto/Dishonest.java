package org.easymis.easysaas.portal.entitys.mybatis.dto;

import java.util.List;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class Dishonest {
	private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "失信人类型1代表公司,2代表人")
    private Integer dishonestType;
    @ApiModelProperty(value = "身份证号码/公司信用代码")
    private String cardCode;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "出生年份")
    private String birthYear;
    @ApiModelProperty(value = "出生区县")
    private String birthDistrict;
    
    private PageInfo execPage;

    private Integer execListCout;
	public Integer getExecListCout() {
		if (execPage!=null&&execPage.getList()!=null)
			return execPage.getList().size();
		else
			return 0;
	}
}
