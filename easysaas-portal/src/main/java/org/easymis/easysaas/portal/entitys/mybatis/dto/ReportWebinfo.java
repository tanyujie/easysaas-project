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
　 * <p>Title: 网站或网店信息</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class ReportWebinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 年报id
     */
    private Long annualreportId;

    /**
     * 网站类型
     */
    @ApiModelProperty("网站类型")
    private String webType;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 网址
     */
    @ApiModelProperty("网址")
    private String website;


    private LocalDateTime createTime;


}
