package org.easymis.easysaas.security.userdetail;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @@author zh
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 资源 id
     */
    private String resourceId;

    /**
     * 返回字段,分隔
     */
    private String returnField;

    /**
     * role_id
     */
    private String	 roleId;

    /**
     * 条数
     */
    private Integer exportNumber;

    /**
     *  查询条数
     *
     */
    private Integer queryNumber;


}
