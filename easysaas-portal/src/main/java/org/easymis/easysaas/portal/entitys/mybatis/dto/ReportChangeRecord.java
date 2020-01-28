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
 * <p>
 * 年报变更记录
 * </p>
 *
 * @author zh
 * @since 2019-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class ReportChangeRecord implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 年报id
     */
    private Long annualreportId;

    /**
     * 修改事项
     */
    @ApiModelProperty("修改事项")
    private String changeItem;

    /**
     * 修改前
     */
    @ApiModelProperty("修改前")
    private String contentBefore;

    /**
     * 修改后
     */
    @ApiModelProperty("修改后")
    private String contentAfter;

    /**
     * 修改日期
     */
    @ApiModelProperty("修改日期")
    private LocalDateTime changeTime;


    private LocalDateTime createTime;


}
