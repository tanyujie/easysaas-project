package org.easymis.easycrm.common.security.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.easymis.easycrm.common.entitys.mybatis.mapper.UserRoleMapper;
import org.easymis.easycrm.common.security.service.RoleService;
import org.easymis.easycrm.common.security.service.UserRoleService;
import org.easymis.easycrm.common.security.userdetail.ExpireDateGrantedAuthority;
import org.easymis.easycrm.common.security.userdetail.Role;
import org.easymis.easycrm.common.security.userdetail.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleMapper mapper;
    
    @Autowired
    RoleService roleService;
	@Override
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
	@Override
	public List<UserRole> findByUserNo(String userNo) {
		// TODO Auto-generated method stub
		return mapper.findByUserNo(userNo);
	}

}
