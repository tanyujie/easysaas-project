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
　 * <p>Title: 对外投资</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class ReportOutboundInvestment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 年报id
     */

    private Long annualReportId;

    /**
     * 对外投资企业id
     */
    @ApiModelProperty("对外投资企业id")
    private Long outcompanyId;

    /**
     * 对外投资企业名称
     */
    @ApiModelProperty("对外投资企业名称")
    private String outcompanyName;

    /**
     * 注册号
     */
    @ApiModelProperty("注册号")
    private String regNum;

    /**
     * 统一信用代码
     */
    @ApiModelProperty("统一信用代码")
    private String creditCode;

    private LocalDateTime createTime;


}
