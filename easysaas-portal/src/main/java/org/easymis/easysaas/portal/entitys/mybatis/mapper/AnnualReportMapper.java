package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.portal.entitys.mybatis.dto.AnnualReport;

public interface AnnualReportMapper {
	@Select("select * from annual_report")
	public List<AnnualReport> getList(HashMap<String, Object> params);

	@Insert("insert into annual_report(id,company_id,report_year,company_name,credit_code,reg_number,phone_number,postcode,postal_address,email,manage_state,employee_num,operator_name,total_assets,total_equity,total_sales,total_profit,prime_bus_profit,retained_profit,total_tax,total_liability,createTime)values(#{id},#{companyId},#{reportYear},#{companyName},#{creditCode},#{regNumber},#{phoneNumber},#{postcode},#{postalAddress},#{email},#{manageState},#{employeeNum},#{operatorName},#{totalAssets},#{totalEquity},#{totalSales},#{totalProfit},#{primeBusProfit},#{retainedProfit},#{totalTax},#{totalLiability},#{createTime})")
	public void save(AnnualReport bean);

	@Insert("insert into annual_report(id,company_id,report_year,company_name,credit_code,reg_number,phone_number,postcode,postal_address,email,manage_state,employee_num,operator_name,total_assets,total_equity,total_sales,total_profit,prime_bus_profit,retained_profit,total_tax,total_liability,createTime)values(#{id},#{companyId},#{reportYear},#{companyName},#{creditCode},#{regNumber},#{phoneNumber},#{postcode},#{postalAddress},#{email},#{manageState},#{employeeNum},#{operatorName},#{totalAssets},#{totalEquity},#{totalSales},#{totalProfit},#{primeBusProfit},#{retainedProfit},#{totalTax},#{totalLiability},#{createTime})")
	public void saveBatch(List<AnnualReport> beans);

	@Update("UPDATE annual_report SET id= #{id},company_id= #{companyId},report_year= #{reportYear},company_name= #{companyName},credit_code= #{creditCode},reg_number= #{regNumber},phone_number= #{phoneNumber},postcode= #{postcode},postal_address= #{postalAddress},email= #{email},manage_state= #{manageState},employee_num= #{employeeNum},operator_name= #{operatorName},total_assets= #{totalAssets},total_equity= #{totalEquity},total_sales= #{totalSales},total_profit= #{totalProfit},prime_bus_profit= #{primeBusProfit},retained_profit= #{retainedProfit},total_tax= #{totalTax},total_liability= #{totalLiability},createTime= #{createTime} WHERE id= #{id}")
	public void update(AnnualReport bean);

	@Delete(" DELETE FROM annual_report WHERE id = #{id}")
	public void delete(String id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from annual_report t WHERE t.id = #{id}")

	public AnnualReport findById(String id);

	@Select(" SELECT t.* FROM annual_report t")
	public List<AnnualReport> findByIds(List<String> list);
	@Select({"<script>",
        "SELECT * from annual_report ",
        " WHERE company_id=#{companyId}", 
          "order by report_year desc",
        "</script>"}) 
	List<AnnualReport>  findByCompanyId(@Param("companyId") String companyId);
}