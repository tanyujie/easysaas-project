package org.easymis.easysaas.gateway.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.easymis.easysaas.gateway.config.datasource.DataSourceType;
import org.easymis.easysaas.gateway.config.datasource.EasymisDataSource;
import org.easymis.easysaas.gateway.entitys.mybatis.dto.Role;
import org.easymis.easysaas.gateway.entitys.mybatis.mapper.UserRoleMapper;
import org.easymis.easysaas.gateway.security.userdetail.ExpireDateGrantedAuthority;
import org.easymis.easysaas.gateway.security.userdetail.UserRole;
import org.easymis.easysaas.gateway.service.RoleService;
import org.easymis.easysaas.gateway.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper mapper;
    
    @Autowired
    RoleService roleService;
	@EasymisDataSource(DataSourceType.Master)
	public List<ExpireDateGrantedAuthority> getGrantedAuthorityByUserNo(String userNo) {
        List<ExpireDateGrantedAuthority> grantedAuthoritieList = new ArrayList<>();
        List<UserRole> userRoleList = findByUserNo(userNo);
        if (userRoleList.size() == 0) {
            // 未设定Role
            grantedAuthoritieList.add(ExpireDateGrantedAuthority.defaultGrantedAuthority());  //设定默认的
            return grantedAuthoritieList;
        } else {
            List<String> roleNameList = userRoleList.stream().map(userRole -> userRole.getRoleName()).collect(Collectors.toList());
            List<Role> roles = roleService.findByRoleNames(roleNameList);
            userRoleList.stream().forEach(userRole -> {
                for (Role role : roles) {
                    if(Objects.equals(role.getRoleName(),userRole.getRoleName())){
                        grantedAuthoritieList.add(new ExpireDateGrantedAuthority(role.getRoleSn(),userRole.getFromTime(),userRole.getToTime()));
                    }
                }
            });
            // grantedAuthoritieList.
            return grantedAuthoritieList;
        }


    }
	@EasymisDataSource(DataSourceType.Master)
	public List<UserRole> findByUserNo(String userNo) {
		// TODO Auto-generated method stub
		return mapper.findByUserNo(userNo);
	}

}
