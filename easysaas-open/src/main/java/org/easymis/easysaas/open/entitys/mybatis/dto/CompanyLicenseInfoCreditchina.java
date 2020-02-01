package org.easymis.easysaas.open.entitys.mybatis.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
　 * <p>Title: 行政许可</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyLicenseInfoCreditchina implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 企业或自然人名称
     */
    private String companyName;

    /**
     * 许可证号
     */
    @ApiModelProperty("许可证号")
    private String licenceNumber;

    /**
     * 许可状态
     */
    @ApiModelProperty("许可状态")
    private String licenceStatus;

    /**
     * 审核类型
     */
    @ApiModelProperty("审核类型")
    private String auditYpe;

    /**
     * 法定代表人（负责人）姓名
     */
    @ApiModelProperty("法定代表人")
    private String legalPersonName;

    /**
     * 内容许可
     */
    @ApiModelProperty("内容许可")
    private String licenceContent;

    /**
     * 许可有效期
     */
    @ApiModelProperty("许可有效期")
    private String validityTime;

    /**
     * 许可决定日期
     */
    @ApiModelProperty("许可决定日期")
    private LocalDate decisionDate;

    /**
     * 许可截止日期
     */
    @ApiModelProperty("许可截止日期")
    private LocalDate endDate;

    /**
     * 地方编码
     */
    @ApiModelProperty("地方编码")
    private String localCode;

    /**
     * 许可机关
     */
    @ApiModelProperty("许可机关")
    private String department;

    /**
     * 区域
     */
    @ApiModelProperty("区域")
    private String areaName;

    /**
     * 概要
     */
    @ApiModelProperty("概要")
    private String resume;

    /**
     * 数据更新时间
     */
    @ApiModelProperty("数据更新时间")
    private LocalDate dataUpdateTime;

    /**
     * 抓取时间
     */
    @ApiModelProperty("抓取时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 0：显示 1：不显示
     */
    private Integer deleted;

    /**
     * 与官网保持一致[0:官网还存在 1:官网不存在]
     */
    private Integer status;

    /**
     * 核准时间
     */

    @ApiModelProperty("核准时间")
    private LocalDateTime approTime;


}
