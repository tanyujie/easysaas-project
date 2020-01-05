package org.easymis.easysaas.core.security.userdetail;


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
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 不包含域名的路径
     */
    private String endPoint;

    /**
     * 返回类
     */
    private String returnClass;

    /**
     * 名称
     */
    private String resourceName;

    /**
     * 上一级资源
     */
    private String parentId;

    /**
     * 是否返回的是文件
     */
    private Boolean returnFile;


}
