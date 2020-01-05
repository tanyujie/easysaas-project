package org.easymis.easycrm.common.security.userdetail;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zh
 * @since 2019-09-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * user_no
     */
    private String userNo;

    /**
     * role_name
     */
    private String roleName;

    /**
     * 有效期起始
     */
    private LocalDateTime fromTime;

    /**
     * 有效期结束
     */
    private LocalDateTime toTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是不是免费的
     */
    private Boolean free;


    private Integer payFee;

    private String  gdeOrderNo;

    private String freeOperationPhone;


}
