package org.easymis.easysaas.open.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.open.entitys.mybatis.dto.ReportSocialSecurityInfo;

public interface ReportSocialSecurityInfoMapper {
	@Select({"<script>",
        "SELECT * from report_social_security_info ",
        "WHERE  annaulreport_id IN", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	List<ReportSocialSecurityInfo> findByAnnualreportIds(@Param("ids")List<String> ids);
}
