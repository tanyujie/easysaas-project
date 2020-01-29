package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.SoftwareCopyright;

public interface SoftwareCopyrightMapper {
	
	@Select({"<script>",
        "SELECT * from software_copyright ",
        " WHERE company_Id=#{companyId}", 
          "order by publishTime desc",
        "</script>"}) 
	List<SoftwareCopyright>  findByCompanyId(@Param("companyId") String companyId);
}
