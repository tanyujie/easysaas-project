package org.easymis.easysaas.open.entitys.mybatis.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class ReportSocialSecurityInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 年报id
     */
    private Long annaulreportId;

    /**
     * 城镇职工基本养老保险
     */
    @ApiModelProperty("城镇职工基本养老保险")
    private String endowmentInsurance;

    /**
     * 失业保险
     */
    @ApiModelProperty("失业保险")
    private String unemploymentInsurance;

    /**
     * 职工基本医疗保险
     */
    @ApiModelProperty("职工基本医疗保险")
    private String medicalInsurance;

    /**
     * 工伤保险
     */
    @ApiModelProperty("工伤保险")
    private String employmentInjuryInsurance;

    /**
     * 生育保险
     */
    @ApiModelProperty("生育保险")
    private String maternityInsurance;

    /**
     * 单位参加城镇职工基本养老保险缴费基数
     */
    @ApiModelProperty("单位参加城镇职工基本养老保险缴费基数")
    private String endowmentInsuranceBase;

    /**
     * 单位参加失业保险缴费基数
     */
    @ApiModelProperty("单位参加失业保险缴费基数")
    private String unemploymentInsuranceBase;

    /**
     * 单位参加职工基本医疗保险缴费基数
     */
    @ApiModelProperty("单位参加职工基本医疗保险缴费基数")
    private String medicalInsuranceBase;

    /**
     * 单位参加生育保险缴费基数
     */
    @ApiModelProperty("单位参加生育保险缴费基数")
    private String maternityInsuranceBase;

    /**
     * 参加城镇职工基本养老保险本期实际缴费金额
     */
    @ApiModelProperty("参加城镇职工基本养老保险本期实际缴费金额")
    private String endowmentInsurancePayAmount;

    /**
     * 参加失业保险本期实际缴费金额
     */
    @ApiModelProperty("参加失业保险本期实际缴费金额")
    private String unemploymentInsurancePayAmount;

    /**
     * 参加职工基本医疗保险本期实际缴费金额
     */
    @ApiModelProperty("参加职工基本医疗保险本期实际缴费金额")
    private String medicalInsurancePayAmount;

    /**
     * 参加工伤保险本期实际缴费金额
     */
    @ApiModelProperty("参加工伤保险本期实际缴费金额")
    private String employmentInjuryInsurancePayAmount;

    /**
     * 参加生育保险本期实际缴费金额
     */
    @ApiModelProperty("参加生育保险本期实际缴费金额")
    private String maternityInsurancePayAmount;

    /**
     * 单位参加城镇职工基本养老保险累计欠缴金额
     */
    @ApiModelProperty("单位参加城镇职工基本养老保险累计欠缴金额")
    private String endowmentInsuranceOweAmount;

    /**
     * 单位参加失业保险累计欠缴金额
     */
    @ApiModelProperty("单位参加失业保险累计欠缴金额")
    private String unemploymentInsuranceOweAmount;

    /**
     * 单位参加职工基本医疗保险累计欠缴金额
     */
    @ApiModelProperty("单位参加职工基本医疗保险累计欠缴金额")
    private String medicalInsuranceOweAmount;

    /**
     * 单位参加工伤保险累计欠缴金额
     */
    @ApiModelProperty("单位参加工伤保险累计欠缴金额")
    private String employmentInjuryInsuranceOweAmount;

    /**
     * 单位参加生育保险累计欠缴金额
     */
    @ApiModelProperty("单位参加生育保险累计欠缴金额")
    private String maternityInsuranceOweAmount;

    private LocalDateTime createTime;


}
