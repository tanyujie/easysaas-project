package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.Department;

public interface DepartmentMapper {
	@Select(" SELECT * FROM department t where org_id=#{orgId} order by priority")
	public List<Department> findByOrgId(@Param("orgId")String orgId);
}
