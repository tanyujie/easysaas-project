package org.easymis.easycrm.operation.entitys.mybatis.dto;

import java.io.Serializable;

import org.easymis.easycrm.operation.utils.json.SeventeenTableJsonSerializer;

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
/*@TableName("company_category_code")*/
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyCategoryCode implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String categoryCode;

    /**
     * 对应《国民经济行业分类》2013年最新版的中类
     */
    private String cate3;

    /**
     * 对应《国民经济行业分类》2013年最新版的大类
     */
    private String cate2;

    /**
     * 对应《国民经济行业分类》2013年最新版的门类
     */

    private String cate1;


}
