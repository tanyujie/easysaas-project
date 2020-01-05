package org.easymis.easycrm.web.security.service;

import java.util.List;

import org.easymis.easycrm.web.security.userdetail.ExpireDateGrantedAuthority;
import org.easymis.easycrm.web.security.userdetail.UserRole;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zh
 * @since 2019-09-02
 */
public interface UserRoleService{


    String roleUser = "ROLE_USER";  // 默认的用户权限

    String guest = "ROLE_ANONYMOUS";


    List<ExpireDateGrantedAuthority> getGrantedAuthorityByUserNo(String userNo);
    List<UserRole> findByUserNo(String userNo);


}
