package org.easymis.easysaas.open.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.open.entitys.mybatis.dto.ReportShareholder;

public interface ReportShareholderMapper {
	@Select({"<script>",
        "SELECT * from report_shareholder",
        "WHERE  annual_report_id IN", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	List<ReportShareholder> findByAnnualreportIds(@Param("ids") List<String> ids);
}
