package org.easymis.easyicc.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easyicc.domain.entity.BackType;

public interface BackTypeMapper {
	 @Select("select * from Back_Type t WHERE t.org_id = #{orgId}")  
	 List<BackType> findByOrgId(@Param("orgId") String orgId);
}
