package org.easymis.easysaas.crm.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.dto.CrmCustomer;

public interface CrmCustomerMapper {
	@Select("select * from crm_customer")
	public List<CrmCustomer> getList(HashMap<String, Object> params);

	@Insert("insert into crm_customer(address,annual_revenue,bank_name,bank_no,category_id,city_id,code,country_id,create_time,creator_id,customer_id,customer_name,delete_id,delete_time,depict,district_id,email,fax,industry_id,kind_id,level1_industry_id,level2_industry_id,level3_industry_id,locked,org_id,origin_id,owner_id,ownership,phone,province_id,qq,rating,register_address,status,street,tax_no,update_id,update_time,url,zip_code)values(#{address},#{annualRevenue},#{bankName},#{bankNo},#{categoryId},#{cityId},#{code},#{countryId},#{createTime},#{creatorId},#{customerId},#{customerName},#{deleteId},#{deleteTime},#{depict},#{districtId},#{email},#{fax},#{industryId},#{kindId},#{level1IndustryId},#{level2IndustryId},#{level3IndustryId},#{locked},#{orgId},#{originId},#{ownerId},#{ownership},#{phone},#{provinceId},#{qq},#{rating},#{registerAddress},#{status},#{street},#{taxNo},#{updateId},#{updateTime},#{url},#{zipCode})")
	public void save(CrmCustomer bean);

	@Insert("insert into crm_customer(address,annual_revenue,bank_name,bank_no,category_id,city_id,code,country_id,create_time,creator_id,customer_id,customer_name,delete_id,delete_time,depict,district_id,email,fax,industry_id,kind_id,level1_industry_id,level2_industry_id,level3_industry_id,locked,org_id,origin_id,owner_id,ownership,phone,province_id,qq,rating,register_address,status,street,tax_no,update_id,update_time,url,zip_code)values(#{address},#{annualRevenue},#{bankName},#{bankNo},#{categoryId},#{cityId},#{code},#{countryId},#{createTime},#{creatorId},#{customerId},#{customerName},#{deleteId},#{deleteTime},#{depict},#{districtId},#{email},#{fax},#{industryId},#{kindId},#{level1IndustryId},#{level2IndustryId},#{level3IndustryId},#{locked},#{orgId},#{originId},#{ownerId},#{ownership},#{phone},#{provinceId},#{qq},#{rating},#{registerAddress},#{status},#{street},#{taxNo},#{updateId},#{updateTime},#{url},#{zipCode})")
	public void saveBatch(List<CrmCustomer> beans);

	@Update("UPDATE crm_customer SET address= #{address},annual_revenue= #{annualRevenue},bank_name= #{bankName},bank_no= #{bankNo},category_id= #{categoryId},city_id= #{cityId},code= #{code},country_id= #{countryId},create_time= #{createTime},creator_id= #{creatorId},customer_id= #{customerId},customer_name= #{customerName},delete_id= #{deleteId},delete_time= #{deleteTime},depict= #{depict},district_id= #{districtId},email= #{email},fax= #{fax},industry_id= #{industryId},kind_id= #{kindId},level1_industry_id= #{level1IndustryId},level2_industry_id= #{level2IndustryId},level3_industry_id= #{level3IndustryId},locked= #{locked},org_id= #{orgId},origin_id= #{originId},owner_id= #{ownerId},ownership= #{ownership},phone= #{phone},province_id= #{provinceId},qq= #{qq},rating= #{rating},register_address= #{registerAddress},status= #{status},street= #{street},tax_no= #{taxNo},update_id= #{updateId},update_time= #{updateTime},url= #{url},zip_code= #{zipCode} WHERE customer_id= #{customerId}")
	public void update(CrmCustomer bean);

	@Delete(" DELETE FROM crm_customer WHERE customer_id = #{customerId}")
	public void delete(String customer_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from crm_customer t WHERE t.customer_id = #{customerId}")
	public CrmCustomer findById(String customer_id);

	@Select(" SELECT t.* FROM crm_customer t }")
	public List<CrmCustomer> findByIds(List<String> list);
}