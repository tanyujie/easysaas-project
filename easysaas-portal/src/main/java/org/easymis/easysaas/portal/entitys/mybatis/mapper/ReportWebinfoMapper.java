package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportWebinfo;

public interface ReportWebinfoMapper {
	@Select({"<script>",
        "SELECT * from report_webinfo",
        "WHERE  annualreport_id IN", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	List<ReportWebinfo> findByAnnualreportIds(@Param("ids")List<String> ids);
}
