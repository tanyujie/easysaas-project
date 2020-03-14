package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.HrmStaffInfo;

public interface HrmStaffInfoMapper {
	@Select(" SELECT staff_id,name,org_id,department_id FROM hrm_staff_info t where org_id=#{orgId}")
	public List<HrmStaffInfo> findByOrgId(@Param("orgId")String orgId);
}
