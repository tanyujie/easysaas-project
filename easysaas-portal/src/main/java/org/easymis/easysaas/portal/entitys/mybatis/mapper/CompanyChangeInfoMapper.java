package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyChangeInfo;

@Mapper
public interface CompanyChangeInfoMapper {

	@Select({"<script>",
        "SELECT * from company_change_info ",
        " WHERE company_id=#{companyId}", 
          "order by change_time desc",
        "</script>"}) 
	List<CompanyChangeInfo>  findByCompanyId(@Param("companyId") String companyId);

}
