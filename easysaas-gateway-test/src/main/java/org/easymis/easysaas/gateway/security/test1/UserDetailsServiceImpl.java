package org.easymis.easysaas.gateway.security.test1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.easymis.easysaas.gateway.entitys.mybatis.dto.Member;
import org.easymis.easysaas.gateway.entitys.mybatis.mapper.UserMapper;
import org.easymis.easysaas.gateway.entitys.vo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
/*@Component*/
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 需要从数据库中通过用户名来查询用户的信息和用户所属的角色
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// log.info("===========授权============");

	        UserDetails userDeatils = null;

	        //通过用户名 查询密码
	        Member member=userMapper.findByPhoneNumber(username);

	        Set<GrantedAuthority> authorities = new HashSet<>();
	        //查询用户角色
	        if(null != member){
	           //log.info("用户 = " + member.getName() + "----" + member.getPassword());
	            //查询用户权限
	            List<Role> usersList = null;//usersMapper.selectRolesAndResourceByUserId(users.getId());
	            if(null != usersList && usersList.size()>0){
/*	                usersList.forEach(user->{
	                     //存放role name  或者 权限名字
	                    authorities.add(new GrantedAuthority(user.getResourceName())); 
	                });*/
	            }else{
	                System.out.println("用户无权限。。");

	                throw new BadCredentialsException("not found ... ");
	            }

	           //7 返回数据
	            userDeatils = new org.springframework.security.core.userdetails.User(username,member.getPassword(),authorities);

	        }else{
	        
	            throw new BadCredentialsException("用户名不存在");
	        }

	        return userDeatils;
	}

}
