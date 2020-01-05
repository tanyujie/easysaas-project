package org.easymis.easycrm.web.security.userdetail;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class SecurityUserDetails implements UserDetails {

    private static final long serialVersionUID = 5100023042L;

    private String username;
    @JsonIgnore
    private String password;

    private String userNo;
    // userId
    private Integer id;

    //m默认是手机号码 或者邮箱
    private String name;

    private String headUrl;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;


    /**
     * 电话号码
     */
    private String phoneNumber;

    private boolean enabled;

    @JsonIgnore
    private String token;

    private List<ExpireDateGrantedAuthority> expireDateGrantedAuthorityList;


    @Override
    public Collection<ExpireDateGrantedAuthority> getAuthorities() {
        return this.expireDateGrantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }


    public ExpireDateGrantedAuthority getEffactiveAuthority() {
        ExpireDateGrantedAuthority effactive = ExpireDateGrantedAuthority.defaultGrantedAuthority();
        List<ExpireDateGrantedAuthority> authorities = this.getExpireDateGrantedAuthorityList();
        if (Objects.isNull(authorities)) {
            return effactive;
        } else {
            for (ExpireDateGrantedAuthority authority : authorities) {
                if (!authority.isExpire()) {
                    effactive = authority;
                    break;
                }
            }
            return effactive;
        }

    }

    public ExpireDateGrantedAuthority getLastEffactiveAuthority() {
        ExpireDateGrantedAuthority effactive = ExpireDateGrantedAuthority.defaultGrantedAuthority();
        List<ExpireDateGrantedAuthority> authorities = this.getExpireDateGrantedAuthorityList();
        if (Objects.isNull(authorities)) {
            return effactive;
        } else {
            for (ExpireDateGrantedAuthority authority : authorities) {
                if (!authority.isExpire()) {
                    effactive = authority;
                }
            }
            return effactive;
        }

    }




}
