package org.easymis.easysaas.open.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.open.entitys.mybatis.dto.Trademark;

public interface TrademarkMapper {
	@Select("select * from trademark")

	public List<Trademark> getList(HashMap<String, Object> params);

	@Insert("insert into trademark(id,company_id,register_no,international_category,trade_name,app_date,applicant_cn,address_cn,applicant_other_1,applicant_other_2,applicant_en,address_en,announcemen_issue,announcement_date,register_issue,register_date,private_date_start,private_date_end,agent,category,late_specified_date,international_register_date,priority_date,color,status,source,crawl_time,update_time,deleted)values(#{id},#{companyId},#{registerNo},#{internationalCategory},#{tradeName},#{appDate},#{applicantCn},#{addressCn},#{applicantOther1},#{applicantOther2},#{applicantEn},#{addressEn},#{announcemenIssue},#{announcementDate},#{registerIssue},#{registerDate},#{privateDateStart},#{privateDateEnd},#{agent},#{category},#{lateSpecifiedDate},#{internationalRegisterDate},#{priorityDate},#{color},#{status},#{source},#{crawlTime},#{updateTime},#{deleted})")
	public void save(Trademark bean);

	@Insert("insert into trademark(id,company_id,register_no,international_category,trade_name,app_date,applicant_cn,address_cn,applicant_other_1,applicant_other_2,applicant_en,address_en,announcemen_issue,announcement_date,register_issue,register_date,private_date_start,private_date_end,agent,category,late_specified_date,international_register_date,priority_date,color,status,source,crawl_time,update_time,deleted)values(#{id},#{companyId},#{registerNo},#{internationalCategory},#{tradeName},#{appDate},#{applicantCn},#{addressCn},#{applicantOther1},#{applicantOther2},#{applicantEn},#{addressEn},#{announcemenIssue},#{announcementDate},#{registerIssue},#{registerDate},#{privateDateStart},#{privateDateEnd},#{agent},#{category},#{lateSpecifiedDate},#{internationalRegisterDate},#{priorityDate},#{color},#{status},#{source},#{crawlTime},#{updateTime},#{deleted})")
	public void saveBatch(List<Trademark> beans);

	@Update("UPDATE trademark SET id= #{id},company_id= #{companyId},register_no= #{registerNo},international_category= #{internationalCategory},trade_name= #{tradeName},app_date= #{appDate},applicant_cn= #{applicantCn},address_cn= #{addressCn},applicant_other_1= #{applicantOther1},applicant_other_2= #{applicantOther2},applicant_en= #{applicantEn},address_en= #{addressEn},announcemen_issue= #{announcemenIssue},announcement_date= #{announcementDate},register_issue= #{registerIssue},register_date= #{registerDate},private_date_start= #{privateDateStart},private_date_end= #{privateDateEnd},agent= #{agent},category= #{category},late_specified_date= #{lateSpecifiedDate},international_register_date= #{internationalRegisterDate},priority_date= #{priorityDate},color= #{color},status= #{status},source= #{source},crawl_time= #{crawlTime},update_time= #{updateTime},deleted= #{deleted} WHERE id= #{id}")
	public void update(Trademark bean);

	@Delete(" DELETE FROM trademark WHERE id = #{id}")
	public void delete(String id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from trademark t WHERE t.id = #{id}")

	public Trademark findById(String id);

	@Select(" SELECT t.* FROM trademark t ")
	public List<Trademark> findByIds(List<String> list);
	@Select("select * from trademark t WHERE t.company_id = #{companyId} order by app_date desc")
	List<Trademark> findByCompanyId(@Param("companyId") String companyId);

}