package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportOutGuaranteeInfo;

public interface ReportOutGuaranteeInfoMapper {
	@Select({"<script>",
        "SELECT * from report_out_guarantee_info",
        "WHERE  annualreport_id IN", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	List<ReportOutGuaranteeInfo> findByAnnualreportIds(@Param("ids")List<String> ids);
}
