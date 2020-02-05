package org.easymis.easysaas.portal.entitys.mybatis.dto;

import java.time.LocalDateTime;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class IdentityCardAddress {
	private String code;
	private String parentCode;
	private String province;
	private String base;
	private String city;
	private String district;
	private String depict;

}
