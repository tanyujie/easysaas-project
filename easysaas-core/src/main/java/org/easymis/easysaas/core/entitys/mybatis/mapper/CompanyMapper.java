package org.easymis.easysaas.core.entitys.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.core.entitys.mybatis.dto.Company;
@Mapper
public interface CompanyMapper {
	@Select("select * from company t WHERE t.id = #{companyId}")
	@Results(value = { @Result(property = "companyId", column = "company_id"), 
			@Result(property = "companyName", column = "company_name")

	})
	 Company findById(@Param("companyId") String companyId);
}
