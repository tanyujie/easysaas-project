package org.easymis.easysaas.portal.entitys.vo;

import javax.validation.constraints.Min;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing = SeventeenTableJsonSerializer.class)
public class DishonestSearchVo {
	private String name;
	private Integer type;
	
    @Range(min = 1, max = 30, message = "每页最大数量为30")
    public Integer pageSize = 10;
    @Min(value = 1, message = "pageNo大于等于1")
    public Integer pageNo = 1;
}
