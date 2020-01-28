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
　 * <p>Title: 企业公示行政许可</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月28日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyLicenseEntpub implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 公司id
     */
    private Long companyid;

    /**
     * 许可证名称
     */
    @ApiModelProperty("许可证名称")
    private String licencename;

    /**
     * 许可证编号
     */
    @ApiModelProperty("许可证编号")
    private String licencenumber;

    /**
     * 许可内容
     */
    @ApiModelProperty("许可内容")
    private String scope;

    /**
     * 起始日期
     */
    @ApiModelProperty("起始日期")
    private String fromdate;

    /**
     * 到期日期
     */
    @ApiModelProperty("到期日期")
    private String todate;

    /**
     * 发证机关
     */
    @ApiModelProperty("发证机关")
    private String department;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private String state;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;


}
