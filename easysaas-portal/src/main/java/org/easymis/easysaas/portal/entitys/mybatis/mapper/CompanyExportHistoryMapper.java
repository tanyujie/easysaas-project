package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyExportHistory;

public interface CompanyExportHistoryMapper {
	@Select("select company_id from company_export_history t WHERE t.member_id = #{memberId} and t.query_condition_md5=#{queryConditionMd5}")
	public List<String> findByShort(@Param("memberId")String memberId, @Param("queryConditionMd5")String queryConditionMd5);

	@Insert({ "<script>", 
				"insert into company_export_history(company_id,member_id,create_time,query_condition_md5)",
				" values", 
				"<foreach item='item' index='index' collection='beans' separator=','>",
				"(#{item.companyId},#{item.memberId},#{item.createTime},#{item.queryConditionMd5})", 
				"</foreach>",
			"</script>" })
	public void saveBatch(@Param("beans")List<CompanyExportHistory> beans);
}
