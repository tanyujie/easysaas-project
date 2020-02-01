package org.easymis.easysaas.open.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.open.entitys.mybatis.dto.CompanyLicenseInfoCreditchina;

public interface CompanyLicenseInfoCreditchinaMapper {
	@Select("select * from company_license_info_creditchina t WHERE t.company_name = #{companyName} order by decision_date desc")
	public List<CompanyLicenseInfoCreditchina> findListByCompanyName(@Param("companyName") String companyName);
}
