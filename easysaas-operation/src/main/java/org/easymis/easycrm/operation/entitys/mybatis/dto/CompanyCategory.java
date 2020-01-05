package org.easymis.easycrm.operation.entitys.mybatis.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.easymis.easycrm.operation.utils.json.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 新版公司-行业数据。注意：所有没有经营范围的公司都不会插入到数据库之中，因为单依据公司名字进行预测，结果并不十分可靠；相应代码对应的行业门类详见表：company_category_code_20170411；
程浩修改于20170503。
 * </p>
 *
 * @author zh
 * @since 2019-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
/*@TableName("company_category")*/
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long companyId;

    private String categoryCode;

    /**
     * status==0：训练数据（也有错误）；status==1：批量预测结果；status==2：批量预测结果（遗珠）；status==3：增量爬取公司预测结果；status==4：手工修改；
     */
    private Integer status;

    private LocalDateTime updatetime;


}
