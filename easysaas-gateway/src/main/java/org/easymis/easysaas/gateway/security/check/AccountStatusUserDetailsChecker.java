package org.easymis.easysaas.gateway.security.check;


import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

/**
 * @author Luke Taylor
 */
public class AccountStatusUserDetailsChecker implements UserDetailsChecker {

    protected final MessageSourceAccessor messages = SpringSecurityMessageSource
            .getAccessor();
    @Override
    public void check(UserDetails user) {

        if (!user.isEnabled()) {
            throw new DisabledException("您已被禁止访问!,具体原因请联系客服");
        }

    }
}
