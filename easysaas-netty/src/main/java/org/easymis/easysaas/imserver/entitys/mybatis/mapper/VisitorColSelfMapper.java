package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.VisitorColSelf;

public interface VisitorColSelfMapper {
	 @Select("select * from VISITOR_COL_SELF t WHERE t.org_id = #{orgId} order by sortIndex")  
	 List<VisitorColSelf> findByOrgId(@Param("orgId") String orgId);
}
