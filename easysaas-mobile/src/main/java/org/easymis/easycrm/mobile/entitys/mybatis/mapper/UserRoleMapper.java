package org.easymis.easycrm.mobile.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easycrm.mobile.security.userdetail.Resource;
import org.easymis.easycrm.mobile.security.userdetail.UserRole;
@Mapper
public interface UserRoleMapper {
	 @Select("select * from easymis_Resource t WHERE t.org_id = #{orgId}")  
	 @Results(value = {@Result(property = "orgId", column = "org_id"),
	 @Result(property = "orgNo", column = "org_no"),
	 @Result(property = "orgName", column = "org_name"),
	 @Result(property = "parentId", column = "parent_id"),
	 @Result(property = "priority", column = "priority"),
	 @Result(property = "ownerId", column = "owner_id"),
	 @Result(property = "ownerName", column = "owner_name"),
	 @Result(property = "contact", column = "contact"),
	 @Result(property = "mobile", column = "mobile"),
	 @Result(property = "createTime", column = "create_time"),
	 @Result(property = "startDate", column = "start_date"),
	 @Result(property = "endTime", column = "end_time"),
	 @Result(property = "versionStatus", column = "version_status"),
	 @Result(property = "countryId", column = "country_id"),
	 @Result(property = "countryName", column = "country_name"),
	 @Result(property = "provinceId", column = "province_id"),
	 @Result(property = "provinceName", column = "province_name"),
	 @Result(property = "cityId", column = "city_id"),
	 @Result(property = "cityName", column = "city_name"),
	 @Result(property = "districtId", column = "district_id"),
	 @Result(property = "districtName", column = "district_name"),
	 @Result(property = "registerAddress", column = "register_address"),
	 @Result(property = "officeAddress", column = "office_address"),
	 @Result(property = "phone", column = "phone"),
	 @Result(property = "fax", column = "fax"),
	 @Result(property = "zip", column = "zip"),
	 @Result(property = "totalStaff", column = "total_staff"),
	 @Result(property = "usedStaff", column = "used_staff"),
	 @Result(property = "status", column = "status"),
	 @Result(property = "depict", column = "depict"),
	 @Result(property = "businessLicenseNo", column = "business_license_no"),
	 @Result(property = "legalPerson", column = "legal_person"),
	 @Result(property = "registeredCapital", column = "registered_capital"),
	 @Result(property = "businessScope", column = "business_scope"),
	 @Result(property = "email", column = "email"),
	 @Result(property = "ipo", column = "ipo"),
	 @Result(property = "stockCode", column = "stock_code"),
	 @Result(property = "bankNo", column = "bank_no"),
	 @Result(property = "bankName", column = "bank_name"),
	 @Result(property = "url", column = "url"),
	 @Result(property = "blog", column = "blog"),
	 @Result(property = "level1IndustryId", column = "level1_industry_id"),
	 @Result(property = "level2IndustryId", column = "level2_industry_id"),
	 @Result(property = "level3IndustryId", column = "level3_industry_id"),
	 @Result(property = "level4IndustryId", column = "level4_industry_id"),
	 @Result(property = "level1IndustryName", column = "level1_industry_name"),
	 @Result(property = "level2IndustryName", column = "level2_industry_name"),
	 @Result(property = "level3IndustryName", column = "level3_industry_name"),
	 @Result(property = "level4IndustryName", column = "level4_industry_name"),
	 @Result(property = "industryId", column = "industry_id"),
	 @Result(property = "industryName", column = "industry_name"),
	 @Result(property = "sourceId", column = "source_id"),
	 @Result(property = "ownership", column = "ownership"),
	 @Result(property = "annualRevenue", column = "annual_revenue"),
	 @Result(property = "qq", column = "qq"),
	 @Result(property = "weChat", column = "we_chat"),
	 @Result(property = "updateId", column = "update_id"),
	 @Result(property = "updateName", column = "update_name"),
	 @Result(property = "updateTime", column = "update_time"),
	 @Result(property = "deleteStatus", column = "delete_status"),
	 @Result(property = "deleteId", column = "delete_id"),
	 @Result(property = "deleteName", column = "delete_name"),
	 @Result(property = "deleteTime", column = "delete_time"),
	 @Result(property = "lockStatus", column = "lock_status"),
	 @Result(property = "ipGateway", column = "ip_gateway")
	 }) 
	 Resource findById(@Param("id") String id);

    @Select("SELECT * FROM member WHERE name = #{name}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "name"),
/*            @Result(property = "roles", column = "id", many = @Many(select = "com.zingtech.nlp.admin.mapper.ResourceRoleMapper.findByUserId")),*/
            @Result(property = "account", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "wx", column = "wx"),
            @Result(property = "create_time", column = "createTime"),
            @Result(property = "address", column = "address"),
            @Result(property = "photo", column = "photo"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "status", column = "status")
    })
    Resource findByUsername(@Param("name") String name);

    @Insert("insert into easymis_Resource(org_id,org_no,org_name,parent_id,priority,owner_id,owner_name,contact,mobile,create_time,start_date,end_time,version_status,country_id,country_name,province_id,province_name,city_id,city_name,district_id,district_name,register_address,office_address,phone,fax,zip,total_staff,used_staff,status,depict,business_license_no,legal_person,registered_capital,business_scope,email,ipo,stock_code,bank_no,bank_name,url,blog,level1_industry_id,level2_industry_id,level3_industry_id,level4_industry_id,level1_industry_name,level2_industry_name,level3_industry_name,level4_industry_name,industry_id,industry_name,source_id,ownership,annual_revenue,qq,we_chat,update_id,update_name,update_time,delete_status,delete_id,delete_name,delete_time,lock_status,ip_gateway)values(#{orgId},#{orgNo},#{orgName},#{parentId},#{priority},#{ownerId},#{ownerName},#{contact},#{mobile},#{createTime},#{startDate},#{endTime},#{versionStatus},#{countryId},#{countryName},#{provinceId},#{provinceName},#{cityId},#{cityName},#{districtId},#{districtName},#{registerAddress},#{officeAddress},#{phone},#{fax},#{zip},#{totalStaff},#{usedStaff},#{status},#{depict},#{businessLicenseNo},#{legalPerson},#{registeredCapital},#{businessScope},#{email},#{ipo},#{stockCode},#{bankNo},#{bankName},#{url},#{blog},#{level1IndustryId},#{level2IndustryId},#{level3IndustryId},#{level4IndustryId},#{level1IndustryName},#{level2IndustryName},#{level3IndustryName},#{level4IndustryName},#{industryId},#{industryName},#{sourceId},#{ownership},#{annualRevenue},#{qq},#{weChat},#{updateId},#{updateName},#{updateTime},#{deleteStatus},#{deleteId},#{deleteName},#{deleteTime},#{lockStatus},#{ipGateway})")  
    int insertByBean(Resource bean);

    @Insert("<script> " + "insert into friend(" +
            "id, member_id,friend_id) " + "VALUES" +
            "<foreach collection=\"itemList\" item=\"item\" index=\"index\"  separator=\",\">" +
            "(#{item.id},#{item.memberId},#{item.friendId})" +
            "</foreach>" +
            " </script>")
    int insertByBeanList(@Param(value="itemList") List<Resource> itemList);
    
    @Insert("INSERT INTO member_role(id, user_id,role_id) " +
            "VALUES(#{id}, #{userId}, #{roleId})")
    int intIntoUserRole(@Param("id") String id,@Param("userId") String userId,@Param("roleId") String roleId);

    @Update("UPDATE member set name=#{username},account=#{account},email=#{email},mobile=#{mobile},wx=#{wx},address=#{address},photo=#{photo},sex=#{sex} WHERE id = #{id}")
    void update(Resource bean);

    @Delete("DELETE FROM member WHERE id = #{id}")
    void delete(String id);

    //删除用户和角色关系表里的数据
    @Delete("DELETE FROM member_role WHERE user_id = #{userId}")
    void deleteUserAndRoleByUserId(String userId);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "name"),
            @Result(property = "account", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "wx", column = "wx"),
            @Result(property = "create_time", column = "createTime"),
            @Result(property = "address", column = "address"),
            @Result(property = "photo", column = "photo"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "status", column = "status")
    })
    @Select("<script>" +
            "select\n" +
            "          id, name,account,password,email,mobile,wx,create_time,address,photo,sex,status\n" +
            "        from member\n" +
            "        <where>\n" +
            "            <if test=\"id != null and id != ''\">\n" +
            "                and id = #{id}\n" +
            "            </if>\n" +
            "            <if test=\"username != null and username != ''\">\n" +
            "                and name = #{username}\n" +
            "            </if>\n" +
            "            <if test=\"account != null and account != ''\">\n" +
            "                and account = #{account}\n" +
            "            </if>\n" +
            "            <if test=\"email != null and email != ''\">\n" +
            "                and email = #{email}\n" +
            "            </if>\n" +
            "        </where>" +
            "</script>")
    List<Resource> findAll();

    @Update("UPDATE member set password=#{password} WHERE id = #{id}")
    void updatePassword(Resource bean);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "name"),
            @Result(property = "roles", column = "id", many = @Many(select = "com.zingtech.nlp.admin.mapper.ResourceRoleMapper.findByUserId")),
            @Result(property = "account", column = "account"),
            @Result(property = "password", column = "password"),
            @Result(property = "email", column = "email"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "wx", column = "wx"),
            @Result(property = "create_time", column = "createTime"),
            @Result(property = "address", column = "address"),
            @Result(property = "photo", column = "photo"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "status", column = "status")
    })
	@Select("<script>" + "SELECT * FROM easymis_Resource " + "</script>")
    List<Resource> findByPage(Resource vo);

	@Select("<script>" + "SELECT * FROM user_role WHERE user_no = #{userNo}" + "</script>")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "userNo", column = "user_no"),
        @Result(property = "roleName", column = "role_name"),
        @Result(property = "fromTime", column = "from_time"),
        @Result(property = "toTime", column = "to_time"),
})
	List<UserRole> findByUserNo(String userNo);
 
}
