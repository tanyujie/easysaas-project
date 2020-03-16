package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.BackType;

public interface BackTypeMapper {
	 @Select("select * from Back_Type t WHERE t.org_id = #{orgId}")  
	 List<BackType> findByOrgId(@Param("orgId") String orgId);
}
