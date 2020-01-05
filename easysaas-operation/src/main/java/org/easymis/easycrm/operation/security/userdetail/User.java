package org.easymis.easycrm.operation.security.userdetail;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zh
 * @since 2019-08-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private String name;

    /**
     * id
     */
    private Integer id;

    /**
     * user编号
     */
    private String userNo;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 部门
     */
    private String department;

    /**
     * 职位
     */
    private String position;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像地址
     */
    private String headUrl;

    /**
     * 电话号码
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    private Boolean enabled;
    



}
