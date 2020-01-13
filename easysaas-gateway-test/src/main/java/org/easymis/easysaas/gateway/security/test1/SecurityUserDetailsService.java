package org.easymis.easysaas.gateway.security.test1;

import org.easymis.easysaas.gateway.entitys.mybatis.dto.Member;
import org.easymis.easysaas.gateway.entitys.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class SecurityUserDetailsService implements ReactiveUserDetailsService {

/*     @Value("${spring.security.user.name}")
     private   String userName;

    @Value("${spring.security.user.password}")
    private   String password;*/
	@Autowired
	UserMapper mapper;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
       //todo 预留调用数据库根据用户名获取用户
    	Member member=mapper.findByPhoneNumber(username);
        if(member!=null){

            
            UserDetails user = User.withUsername(username)
                  .password("123456")
                    .roles("admin").authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("admin"))
                    .build();
            // 预留调用数据库
/*            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (Role role : member.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleSn()));
            }*/
/*预留调用数据库            
 * user=new org.springframework.security.core.userdetails.User(
            		username, user.getPassword(), authorities); */
            return Mono.just(user);
        }
        else{
            return Mono.error(new UsernameNotFoundException("User Not Found"));

        }

    }



}
