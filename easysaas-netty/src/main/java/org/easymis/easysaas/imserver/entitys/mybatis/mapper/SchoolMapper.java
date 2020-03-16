package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SchoolMapper {
	 @Select("select * from school t WHERE t.org_id = #{orgId}")  
	 List findByOrgId(@Param("orgId") String orgId);
}
