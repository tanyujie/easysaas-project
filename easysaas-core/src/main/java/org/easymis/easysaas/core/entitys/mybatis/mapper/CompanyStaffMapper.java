package org.easymis.easysaas.core.entitys.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.easymis.easysaas.core.entitys.mybatis.vo.CompanyStaffVo;

@Mapper
public interface CompanyStaffMapper {
	CompanyStaffVo findById(@Param("id") String id);
}
