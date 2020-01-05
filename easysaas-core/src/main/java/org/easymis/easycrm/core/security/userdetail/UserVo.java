package org.easymis.easycrm.core.security.userdetail;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserVo implements Serializable {


     //默认是手机号码 或者邮箱
    @ApiModelProperty("名称")
    private String  username;

    @ApiModelProperty("头像地址")
    private String  headUrl;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * user编号
     */
    @ApiModelProperty("user编号")
    private String userNo;

    /**
     * 电话号码
     */
    @ApiModelProperty("电话号码")
    private String phoneNumber;


    private String token;

    private String name;



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
     * 修改时间
     */
    private LocalDateTime modifyTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    @ApiModelProperty("角色名称")
    private String roleName;



    @ApiModelProperty("过期时间")
    private String expireTime;


    private Boolean isVip;
    


}
