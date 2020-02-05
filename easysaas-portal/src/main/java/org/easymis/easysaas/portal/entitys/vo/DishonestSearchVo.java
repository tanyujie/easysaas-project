package org.easymis.easysaas.portal.entitys.vo;

import javax.validation.constraints.Min;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.pagehelper.util.StringUtil;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing = SeventeenTableJsonSerializer.class)
public class DishonestSearchVo {
	private String name;
	@ApiModelProperty(value = "所属省份")
	private String province;
	@ApiModelProperty(value = "所属省份名称")
	private String provinceName;
    @ApiModelProperty(value = "出生年份")
    private Integer birthYear;
    @ApiModelProperty(value = "出生年份")
    private String birthYearDepict;
    @ApiModelProperty(value = "性别")
    private Integer sex;
    @ApiModelProperty(value = "性别")
    private String sexDepict;
	private Integer type=2;
	private String filterScope="no";
	private String filterBirthYearSex="no";
	
    @Range(min = 1, max = 30, message = "每页最大数量为30")
    public Integer pageSize = 10;
    @Min(value = 1, message = "pageNo大于等于1")
    public Integer pageNo = 1;
	public String getProvince() {
		if(StringUtil.isEmpty(province))
			return null;
		return province;
	}
	public String getFilterScope() {
		if(StringUtil.isEmpty(province)&&birthYear==null&&sex==null)
			return "yes";
		return filterScope;
	}
	public String getFilterBirthYearSex() {
		if(birthYear!=null&&sex!=null)
			return "yes";
		return filterBirthYearSex;
	}
	public String getBirthYearDepict() {
		if(birthYear!=null&&birthYear==-1)
			return "全部";
		else if(birthYear!=null&&birthYear>0)
			return birthYear+"年";
		else
			return null;
	}
	public String getSexDepict() {
		if(sex!=null&&sex==-1)
			return "全部";
		else if(sex!=null&&sex==1)
			return "男";
		else if(sex!=null&&sex==2)
			return "女";
		else
			return null;
	}
}
