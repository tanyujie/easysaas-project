package org.easymis.easysaas.portal.entitys.mybatis.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class CompanyExport implements Serializable {

	private String id;
	@ApiModelProperty("md5查询条件")
	private String queryConditionMd5;
	@ApiModelProperty("查询条件")
	private String queryCondition;
	@ApiModelProperty("跳过指定数量的数据")
	private Integer skip;
	@ApiModelProperty("查询的条数")
	private Integer queryNumber;
	@ApiModelProperty("用户编号")
	private String memberId;
	@ApiModelProperty("创建时间")
	private LocalDateTime createTime;
	@ApiModelProperty("接口url")
	private String url;
	@ApiModelProperty("查询关键字")
	private String keyword;
	@ApiModelProperty("记录编号")
	private String recordNo;
	@ApiModelProperty("七牛云地址")
	private String qiniuAddress;
	@ApiModelProperty("目的地")
	private String toMail;
	@ApiModelProperty("权限")
	private String roleSn;

}