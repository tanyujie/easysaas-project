package org.easymis.easycrm.common.security.repository;


import java.util.Objects;

import org.easymis.easycrm.common.security.exception.PrincipalNotFundException;
import org.easymis.easycrm.common.security.exception.UnknownPrincipalException;
import org.easymis.easycrm.common.security.userdetail.ExpireDateGrantedAuthority;
import org.easymis.easycrm.common.security.userdetail.Permit;
import org.easymis.easycrm.common.security.userdetail.SecurityUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public interface IdentityRepository {


    /**
     * 获取 Principal
     *
     * @return permit
     */
    default SecurityUserDetails getPrincipalByAuthentication() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (Objects.isNull(principal)) {
            throw new PrincipalNotFundException("not fund  user in authentication", Permit.class);
        } else {
            if (principal instanceof SecurityUserDetails) {
                return (SecurityUserDetails) principal;
            } else {   //表示 permit
                throw new UnknownPrincipalException();
            }
        }
    }

    default String getRoleSn(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (Objects.isNull(principal)) {
            throw new PrincipalNotFundException("not fund  user in authentication", Permit.class);
        } else {
            if (principal instanceof SecurityUserDetails) {
                return ((SecurityUserDetails) principal).getEffactiveAuthority().getAuthority();
            } else {   //表示 permit
                return ExpireDateGrantedAuthority.anonymous;
            }
        }
    }

    /**
     * 获取 主要的身份特征;
     *
     * @return
     */

    default String getIdentityFeature() {
        SecurityUserDetails permit = this.getPrincipalByAuthentication();
        return permit.getUserNo();
    }
}
