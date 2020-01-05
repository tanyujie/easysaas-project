package org.easymis.easysaas.gateway.security.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharepanzer.companydata.config.datasource.DataSourceType;
import com.sharepanzer.companydata.config.datasource.EasymisDataSource;
import com.sharepanzer.companydata.core.security.service.RoleService;
import com.sharepanzer.companydata.core.security.service.UserRoleService;
import com.sharepanzer.companydata.core.security.userdetail.ExpireDateGrantedAuthority;
import com.sharepanzer.companydata.core.security.userdetail.Role;
import com.sharepanzer.companydata.core.security.userdetail.UserRole;
import com.sharepanzer.companydata.core.web.mapper.UserRoleMapper;
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
