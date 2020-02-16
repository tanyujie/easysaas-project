package org.easymis.easysaas.portal.entitys.mybatis.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公司变更信息
 * </p>
 *
 * @author zh
 * @since 2019-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyChangeInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 变更事项
     */
    private String changeItem;

    /**
     * 变更前内容
     */
    private String contentBefore;

    /**
     * 变更后内容
     */
    private String contentAfter;

    /**
     * 变更日期
     */
    private LocalDateTime changeTime;


    private LocalDateTime createTime;


}
