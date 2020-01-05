package org.easymis.easycrm.web.entitys.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.easymis.easycrm.web.entitys.mybatis.vo.CrmLeadsVo;

@Mapper
public interface CrmLeadsMapper {
	CrmLeadsVo findById(@Param("id") String id);
}
