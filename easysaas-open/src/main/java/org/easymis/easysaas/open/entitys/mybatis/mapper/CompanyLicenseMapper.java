package org.easymis.easysaas.open.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.open.entitys.mybatis.dto.CompanyLicense;

public interface CompanyLicenseMapper {
	@Select("select * from company_license t WHERE t.companyid = #{companyId} order by fromdate desc")
	List<CompanyLicense> findByCompanyId(@Param("companyId") String companyId);
}
