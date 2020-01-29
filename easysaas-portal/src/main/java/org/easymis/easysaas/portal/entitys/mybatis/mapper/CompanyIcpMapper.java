package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyIcp;

public interface CompanyIcpMapper {
	@Select("select * from Company_Icp")
	public List<CompanyIcp> getList(HashMap<String, Object> params);

	@Insert("insert into Company_Icp(id,company_id,icp_id,company_name,company_type,liscense,web_name,web_site,examine_date,organizer_name,organizer_id,organizer_kind,icp_main,web_site_id,web_site_name,responsible,site_url,domain_name,icp_no,check_time,province_id,city_id,district_id,address,domain_id,update_time,create_time)values(#{id},#{companyId},#{icpId},#{companyName},#{companyType},#{liscense},#{webName},#{webSite},#{examineDate},#{organizerName},#{organizerId},#{organizerKind},#{icpMain},#{webSiteId},#{webSiteName},#{responsible},#{siteUrl},#{domainName},#{icpNo},#{checkTime},#{provinceId},#{cityId},#{districtId},#{address},#{domainId},#{updateTime},#{createTime})")
	public void save(CompanyIcp bean);

	@Insert("insert into Company_Icp(id,company_id,icp_id,company_name,company_type,liscense,web_name,web_site,examine_date,organizer_name,organizer_id,organizer_kind,icp_main,web_site_id,web_site_name,responsible,site_url,domain_name,icp_no,check_time,province_id,city_id,district_id,address,domain_id,update_time,create_time)values(#{id},#{companyId},#{icpId},#{companyName},#{companyType},#{liscense},#{webName},#{webSite},#{examineDate},#{organizerName},#{organizerId},#{organizerKind},#{icpMain},#{webSiteId},#{webSiteName},#{responsible},#{siteUrl},#{domainName},#{icpNo},#{checkTime},#{provinceId},#{cityId},#{districtId},#{address},#{domainId},#{updateTime},#{createTime})")
	public void saveBatch(List<CompanyIcp> beans);

	@Update("UPDATE Company_Icp SET id= #{id},company_id= #{companyId},icp_id= #{icpId},company_name= #{companyName},company_type= #{companyType},liscense= #{liscense},web_name= #{webName},web_site= #{webSite},examine_date= #{examineDate},organizer_name= #{organizerName},organizer_id= #{organizerId},organizer_kind= #{organizerKind},icp_main= #{icpMain},web_site_id= #{webSiteId},web_site_name= #{webSiteName},responsible= #{responsible},site_url= #{siteUrl},domain_name= #{domainName},icp_no= #{icpNo},check_time= #{checkTime},province_id= #{provinceId},city_id= #{cityId},district_id= #{districtId},address= #{address},domain_id= #{domainId},update_time= #{updateTime},create_time= #{createTime} WHERE id= #{id}")
	public void update(CompanyIcp bean);

	@Delete(" DELETE FROM Company_Icp WHERE id = #{id}")
	public void delete(String id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from Company_Icp t WHERE t.id = #{id}")
	public CompanyIcp findById(String id);

	@Select(" SELECT t.* FROM Company_Icp t ")
	public List<CompanyIcp> findByIds(List<String> list);
}