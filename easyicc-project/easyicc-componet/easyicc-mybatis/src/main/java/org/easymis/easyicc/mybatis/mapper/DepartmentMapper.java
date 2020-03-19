package org.easymis.easyicc.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easyicc.domain.entity.Department;

public interface DepartmentMapper {
	@Select(" SELECT * FROM department t where org_id=#{orgId} order by priority")
	public List<Department> findByOrgId(@Param("orgId")String orgId);
}
