package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportEquityChangeInfo;

public interface ReportEquityChangeInfoMapper {
	@Select({"<script>",
        "SELECT * from report_equity_change_info",
        "WHERE  annualreport_id IN", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	List<ReportEquityChangeInfo> findByAnnualreportIds(@Param("ids") List<String> ids);
}
