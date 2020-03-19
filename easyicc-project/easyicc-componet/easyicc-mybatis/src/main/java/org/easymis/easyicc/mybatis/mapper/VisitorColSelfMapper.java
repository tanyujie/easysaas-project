package org.easymis.easyicc.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easyicc.domain.entity.VisitorColSelf;

public interface VisitorColSelfMapper {
	 @Select("select * from VISITOR_COL_SELF t WHERE t.org_id = #{orgId} order by sortIndex")  
	 List<VisitorColSelf> findByOrgId(@Param("orgId") String orgId);
}
