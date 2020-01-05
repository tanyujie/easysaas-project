package org.easymis.easycrm.mobile.entitys.mybatis.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

import org.easymis.easycrm.mobile.utils.json.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zh
 * @since 2019-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    
    private String companyId;

    /**
     * 归属省份的首字母小写
     */
    private String base;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 法人ID
     */
    private Long legalPersonId;

    /**
     * 法人姓名
     */
    private String legalPersonName;

    /**
     * 法人类型，1 人 2 公司
     */
    private Integer legalPersonType;

    /**
     * 注册号
     */
    private String regNumber;

    /**
     * 公司类型代码
     */
    private Integer companyType;

    /**
     * 公司类型
     */
    private String companyOrgType;

    /**
     * 注册地址
     */
    private String regLocation;

    /**
     * 成立日期
     */
    private LocalDateTime estiblishTime;

    /**
     * 营业期限开始日期
     */
    private LocalDateTime fromTime;

    /**
     * 营业期限终止日期
     */
    private LocalDateTime toTime;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 登记机关
     */
    private String regInstitute;

    /**
     * 核准日期
     */
    private LocalDateTime approvedTime;

    /**
     * 企业状态
     */
    private String regStatus;

    /**
     * 注册资金
     */
    private String regCapital;

    /**
     * 实收注册资金
     */
    private String actualCapital;

    /**
     * 组织机构代码
     */
    private String orgNumber;

    private String orgApprovedInstitute;

    /**
     * 1表示parse过，0表示没parse，3表示parse出错
     */
    private Integer flag;

    /**
     * 上级机构ID
     */
    private Long parentId;

    private LocalDateTime updatetime;

    /**
     * 上市代码
     */
    private String listCode;

    /**
     * 母公司控股比例
     */
    private String ownershipStake;

    /**
     * 数据来源标志
     */
    private String sourceFlag;

    /**
     * 根据名称parse出的公司后缀类型
     */
    private String nameSuffix;

    /**
     * 统一社会信用代码
     */
    private String property1;

    /**
     * 新公司名id
     */
    private String property2;

    /**
     * 英文名
     */
    private String property3;

    /**
     * 纳税人识别号
     */
    private String property4;

    /**
     * 通过工商app抓取时间
     */
    private String property5;

    /**
     * 解析完成时间
     */
    private LocalDateTime crawledtime;


}
