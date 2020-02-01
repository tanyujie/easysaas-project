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
　 * <p>Title: 股东股权变更信息</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class ReportEquityChangeInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 年报id
     */
    private Long annualreportId;

    /**
     * 股东（发起人）
     */
    @ApiModelProperty("股东")
    private String investorName;

    /**
     * 变更前股权比例
     */
    @ApiModelProperty("变更前股权比例")
    private String ratioBefore;

    /**
     * 变更后股权比例
     */
    @ApiModelProperty("变更后股权比例")
    private String ratioAfter;

    /**
     * 股权变更日期
     */
    @ApiModelProperty("股权变更日期")
    private LocalDateTime changeTime;

    private LocalDateTime createTime;


}
