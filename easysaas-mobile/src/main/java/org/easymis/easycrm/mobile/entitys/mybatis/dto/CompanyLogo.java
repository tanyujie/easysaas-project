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
 * @since 2019-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyLogo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 公司名
     */
    private String companyName;

    /**
     * logo在oss上的地址
     */
    private String logoAddress;

    /**
     * logo在oss上的另一个无水印地址
     */
    private String logoAddressOut;

    /**
     * logo来源可以是可以是 lagou liepin 等
     */
    private String source;

    private String sourceUrl;

    /**
     * logo抓取的时间
     */
    private LocalDateTime crawledTime;

    private LocalDateTime updateTime;

    private String deleted;


}
