package org.easymis.easycrm.web.entitys.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.easymis.easycrm.web.entitys.mybatis.vo.CrmBusinessVo;

@Mapper
public interface CrmBusinessMapper {
	CrmBusinessVo findById(@Param("id") String id);
}
