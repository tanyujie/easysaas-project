package org.easymis.easysaas.open.entitys.mybatis.dto;

import java.io.Serializable;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
　 * <p>Title: CompanyStaff</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月29日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyStaff implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 任职人员id
     */
    private Long staffId;

    /**
     * 任职类型代码
     */
    private Integer staffType;

    /**
     * 任职类型名称
     */
    private String staffTypeName;

    /**
     * 薪酬
     */
    private String staffSalary;

    /**
     * 持股数
     */
    private String staffStakeNum;

    /**
     * 其他信息
     */
    private String staffOtherInfo;


}
