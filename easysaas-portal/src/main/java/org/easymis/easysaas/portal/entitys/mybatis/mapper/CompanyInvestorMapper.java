package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyInvestor;
import org.easymis.easysaas.portal.entitys.vo.CompanyInverstVo;

@Mapper
public interface CompanyInvestorMapper {
	@Select("select * from company_investor t WHERE t.company_id = #{companyId}")
	List<CompanyInvestor> findListByCompanyId(@Param("companyId") String companyId);
	@Select("select * from company c left join company_investor i on c.company_id= i.company_id WHERE i.investor_id = #{companyId}")
	List<CompanyInverstVo> getInverstList(@Param("companyId") String companyId);
}
