package org.easymis.easysaas.portal.entitys.mybatis.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class Dishonest {
	private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "失信人类型1代表公司,2代表人")
    private Integer dishonestType;
}
