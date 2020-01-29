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
@JsonSerialize(nullsUsing = SeventeenTableJsonSerializer.class)
public class SoftwareCopyright implements Serializable {
	private String id;
	private String companyId;
	@ApiModelProperty("登记号")
	private String registerNo;
	@ApiModelProperty("分类号")
	private String categoryNo;
	@ApiModelProperty("")
	private String fullName;
	@ApiModelProperty("")
	private String simpleName;
	@ApiModelProperty("版本号")
	private String version;
	@ApiModelProperty("著作权人(国籍)")
	private String authorNationality;
	@ApiModelProperty("首次发表时间")
	private Date publishTime;
	@ApiModelProperty("登记时间")
	private Date registerTime;
	@ApiModelProperty("是否删除 0否 1是")
	private Boolean deleted;
	@ApiModelProperty("")
	private Date updateTime;
	@ApiModelProperty("")
	private Date createTime;

}