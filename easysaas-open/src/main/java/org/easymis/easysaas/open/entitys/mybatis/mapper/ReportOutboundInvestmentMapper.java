package org.easymis.easysaas.open.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.open.entitys.mybatis.dto.ReportOutboundInvestment;

public interface ReportOutboundInvestmentMapper {
	@Select({"<script>",
        "SELECT * from report_outbound_investment",
        "WHERE  annual_report_id IN", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	List<ReportOutboundInvestment> findByAnnualreportIds(@Param("ids") List<String> ids);
}
