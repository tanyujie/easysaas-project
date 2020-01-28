package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportChangeRecord;

public interface ReportChangeRecordMapper {
	@Select({"<script>",
        "SELECT * from report_change_record",
        "WHERE  annualreport_id IN", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	List<ReportChangeRecord> findByAnnualreportIds(@Param("ids") List<String> ids);
}
