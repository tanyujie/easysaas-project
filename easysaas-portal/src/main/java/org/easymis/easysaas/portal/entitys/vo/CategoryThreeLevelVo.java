package org.easymis.easysaas.portal.entitys.vo;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

@Data
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CategoryThreeLevelVo {
	private String name;
	private String code;
	private String nickName;
}
