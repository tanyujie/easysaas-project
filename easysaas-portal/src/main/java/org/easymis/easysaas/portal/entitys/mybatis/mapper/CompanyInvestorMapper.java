package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyInvestor;

@Mapper
public interface CompanyInvestorMapper {
	@Select("select * from company_investor t WHERE t.company_id = #{companyId}")
	List<CompanyInvestor> findListByCompanyId(@Param("companyId") String companyId);
}
