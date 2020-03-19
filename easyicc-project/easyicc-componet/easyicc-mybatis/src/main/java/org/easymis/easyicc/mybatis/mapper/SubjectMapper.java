package org.easymis.easyicc.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SubjectMapper {
	 @Select("select * from subject t WHERE t.org_id = #{orgId}")  
	 List findByOrgId(@Param("orgId") String orgId);
}
