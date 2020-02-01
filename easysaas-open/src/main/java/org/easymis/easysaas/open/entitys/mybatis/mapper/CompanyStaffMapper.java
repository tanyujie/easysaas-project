package org.easymis.easysaas.open.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.open.entitys.mybatis.dto.CompanyStaff;

@Mapper
public interface CompanyStaffMapper {
	@Select("select * from company_staff t WHERE t.company_id = #{companyId}")
	List<CompanyStaff> findByCompanyId(@Param("companyId") String companyId);
	
	@Select({"<script>",
        "SELECT * from company_staff",
        "WHERE  company_id = #{companyId}",
          " and id IN ", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	List<CompanyStaff> findList(@Param("companyId") String companyId,@Param("ids") List<String> ids);
}
