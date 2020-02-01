package org.easymis.easysaas.open.entitys.mybatis.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
　 * <p>Title:  对外提供保证担保信息</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class ReportOutGuaranteeInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 年报id
     */
    private Long annualreportId;

    /**
     * 债权人
     */
    @ApiModelProperty("债权人")
    private String creditor;

    /**
     * 债务人
     */
    @ApiModelProperty("债务人")
    private String obligor;

    /**
     * 主债权种类
     */
    @ApiModelProperty("主债权种类")
    private String creditoType;

    /**
     * 主债权数额
     */
    @ApiModelProperty("主债权数额")
    private String creditoAmount;

    /**
     * 履行债务的期限
     */
    @ApiModelProperty("履行债务的期限")
    private String creditoTerm;

    /**
     * 保证的期间
     */
    @ApiModelProperty("保证的期间")
    private String guaranteeTerm;

    /**
     * 保证的方式
     */
    @ApiModelProperty("保证的方式")
    private String guaranteeWay;

    /**
     * 保证担保的范围
     */
    @ApiModelProperty("保证担保的范围")
    private String guaranteeScope;

    private LocalDateTime createTime;


}
