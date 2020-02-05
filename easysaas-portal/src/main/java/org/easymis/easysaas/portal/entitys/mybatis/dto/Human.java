package org.easymis.easysaas.portal.entitys.mybatis.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
　 * <p>Title: Human</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月29日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class Human implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 人员类型，101代表自然人，102代表律师
     */
    private Integer type;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 描述
     */
    private String description;

    /**
     * 人员来源标志
     */
    private String sourceflag;

    /**
     * 学历
     */
    private String education;

    /**
     * 年龄
     */
    private Integer age;

    private String property1;

    private String property2;

    private String property3;

    private String property4;

    private String property5;

    private LocalDateTime updatetime;


}
