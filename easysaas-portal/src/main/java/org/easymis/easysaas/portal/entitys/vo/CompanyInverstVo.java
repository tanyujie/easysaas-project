package org.easymis.easysaas.portal.entitys.vo;

import java.time.LocalDateTime;
import java.util.Date;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyInverstVo {
	private String companyId;
	private String companyName;
	//被投资企业名称	
    @ApiModelProperty(value = "法人ID")
    private String legalPersonId; 
    @ApiModelProperty(value = "法人姓名") 
    private String legalPersonName; 
	//成立日期	
    @ApiModelProperty(value = "成立日期")
    private Date estiblishTime; 
	//投资数额	
	//投资比例	
    private String holdProportion;
	//经营状态	
	//关联产品	
	//关联机构

}
