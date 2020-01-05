package org.easymis.easysaas.core.security.access;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.easymis.easysaas.core.security.exception.NotVipException;
import org.easymis.easysaas.core.security.userdetail.ExpireDateGrantedAuthority;
import org.easymis.easysaas.core.security.userdetail.SecurityUserDetails;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class AccessDecisionManagerImpl implements AccessDecisionManager {
    //角色权限比对
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        Optional.of(authentication).orElseThrow(() -> new AccessDeniedException("无权限访问资源"));
        Object principal = authentication.getPrincipal();
        boolean anonymousBool= configAttributes.contains(new SecurityConfig(ExpireDateGrantedAuthority.anonymous));
        //如果是匿名 ,直接返回
        if(anonymousBool){
            return ;
        }

        if (principal instanceof SecurityUserDetails) {
            SecurityUserDetails userDetails = (SecurityUserDetails) principal;
            ExpireDateGrantedAuthority effactive = userDetails.getEffactiveAuthority();
            FilterInvocation filterInvocation = (FilterInvocation) object;
            if (effactive.isVip()) { //对vip做细分
                boolean contains = configAttributes.contains(new SecurityConfig(effactive.getAuthority()));
                if(!contains){
                   // log.warn("VIP无权限访问资源");
                    throw new AccessDeniedException("无权限访问资源"); //VIP无权限访问资源
                }
            } else {
                Boolean contains = contains(configAttributes, filterInvocation.getHttpRequest());

            }
        } else if (principal instanceof String) {
            if (ExpireDateGrantedAuthority.anonymous.equals(principal) ) {  // principal =包含 SecurityUserDetails ， ROLE_ANONYMOUS
                if (!anonymousBool) {
                    throw new AccessDeniedException("无权限访问资源");
                }
            } else {
                throw new AccessDeniedException("无权限访问资源");
            }
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return SecurityConfig.class.isAssignableFrom(attribute.getClass());
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }


    /**
     * 对已登录未充值vip的用户进行role_sn匹配
     *
     * @param configAttributes
     * @return
     */

    private Boolean contains(Collection<ConfigAttribute> configAttributes, HttpServletRequest request) {
        boolean contains = configAttributes.contains(new SecurityConfig(ExpireDateGrantedAuthority.defaultRole));
        if (contains) {  //包含
            return true;
        } else {
            boolean anonymousBool = configAttributes.contains(new SecurityConfig(ExpireDateGrantedAuthority.anonymous));
            if(anonymousBool){
                log.warn("配置错误, 配置了一个{}却{}不能访问的资源{}",ExpireDateGrantedAuthority.anonymous,ExpireDateGrantedAuthority.defaultRole,request.getRequestURI());
            }
            throw  new NotVipException("当前资源需要开通vip才能访问");
           /* for (ConfigAttribute attribute : configAttributes) {
                String roleSn = attribute.getAttribute();
                if(Objects.nonNull(roleSn) && roleSn.equals(ExpireDateGrantedAuthority.)){
                    throw  new NotVipException("当前资源需要开通vip才能访问");
                }
            }*/

        }
    }


}
