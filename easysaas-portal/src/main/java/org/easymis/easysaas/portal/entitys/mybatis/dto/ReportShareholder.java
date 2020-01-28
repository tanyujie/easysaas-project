package org.easymis.easysaas.portal.entitys.mybatis.dto;

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
　 * <p>Title: 股东及出资信息</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class ReportShareholder implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 年报id
     */
    private Long annualReportId;

    /**
     * 股东名称
     */
    @ApiModelProperty("股东名称")
    private String investorName;

    /**
     * 认缴出资额
     */
    @ApiModelProperty("认缴出资额")
    private String subscribeAmount;

    /**
     * 认缴出资时间
     */
    @ApiModelProperty("认缴出资时间")
    private LocalDateTime subscribeTime;

    /**
     * 认缴出资方式
     */
    @ApiModelProperty("认缴出资方式")
    private String subscribeType;

    /**
     * 实缴出资额
     */
    @ApiModelProperty("实缴出资额")
    private String paidAmount;

    /**
     * 实缴出资时间
     */
    @ApiModelProperty("实缴出资时间")
    private LocalDateTime paidTime;

    /**
     * 实缴出资方式
     */
    @ApiModelProperty("实缴出资方式")
    private String paidType;

 
    private LocalDateTime createTime;


}
