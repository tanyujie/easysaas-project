package org.easymis.easysaas.crm.entitys.mybatis.mapper;

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
import org.easymis.easysaas.crm.entitys.mybatis.dto.Permission;
@Mapper
public interface PermissionMapper {
	 @Select("select * from member_permission t WHERE t.org_id = #{orgId}")  
	 Permission findById(@Param("id") String id);

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
    Permission findByUsername(@Param("name") String name);

    @Insert("insert into member_permission(org_id,org_no,org_name,parent_id,priority,owner_id,owner_name,contact,mobile,create_time,start_date,end_time,version_status,country_id,country_name,province_id,province_name,city_id,city_name,district_id,district_name,register_address,office_address,phone,fax,zip,total_staff,used_staff,status,depict,business_license_no,legal_person,registered_capital,business_scope,email,ipo,stock_code,bank_no,bank_name,url,blog,level1_industry_id,level2_industry_id,level3_industry_id,level4_industry_id,level1_industry_name,level2_industry_name,level3_industry_name,level4_industry_name,industry_id,industry_name,source_id,ownership,annual_revenue,qq,we_chat,update_id,update_name,update_time,delete_status,delete_id,delete_name,delete_time,lock_status,ip_gateway)values(#{orgId},#{orgNo},#{orgName},#{parentId},#{priority},#{ownerId},#{ownerName},#{contact},#{mobile},#{createTime},#{startDate},#{endTime},#{versionStatus},#{countryId},#{countryName},#{provinceId},#{provinceName},#{cityId},#{cityName},#{districtId},#{districtName},#{registerAddress},#{officeAddress},#{phone},#{fax},#{zip},#{totalStaff},#{usedStaff},#{status},#{depict},#{businessLicenseNo},#{legalPerson},#{registeredCapital},#{businessScope},#{email},#{ipo},#{stockCode},#{bankNo},#{bankName},#{url},#{blog},#{level1IndustryId},#{level2IndustryId},#{level3IndustryId},#{level4IndustryId},#{level1IndustryName},#{level2IndustryName},#{level3IndustryName},#{level4IndustryName},#{industryId},#{industryName},#{sourceId},#{ownership},#{annualRevenue},#{qq},#{weChat},#{updateId},#{updateName},#{updateTime},#{deleteStatus},#{deleteId},#{deleteName},#{deleteTime},#{lockStatus},#{ipGateway})")  
    int insertByBean(Permission bean);

    @Insert("<script> " + "insert into friend(" +
            "id, member_id,friend_id) " + "VALUES" +
            "<foreach collection=\"itemList\" item=\"item\" index=\"index\"  separator=\",\">" +
            "(#{item.id},#{item.memberId},#{item.friendId})" +
            "</foreach>" +
            " </script>")
    int insertByBeanList(@Param(value="itemList") List<Permission> itemList);
    
    @Insert("INSERT INTO member_role(id, user_id,role_id) " +
            "VALUES(#{id}, #{userId}, #{roleId})")
    int intIntoUserRole(@Param("id") String id,@Param("userId") String userId,@Param("roleId") String roleId);

    @Update("UPDATE member set name=#{username},account=#{account},email=#{email},mobile=#{mobile},wx=#{wx},address=#{address},photo=#{photo},sex=#{sex} WHERE id = #{id}")
    void update(Permission bean);

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
	 @Select("select * from member_permission")  
    List<Permission> findAll();
    @Update("UPDATE member set password=#{password} WHERE id = #{id}")
    void updatePassword(Permission bean);

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
	@Select("<script>" + "SELECT * FROM member_permission " + "</script>")
    List<Permission> findByPage(Permission vo);

	@Select("<script>" + "SELECT * FROM resource WHERE end_point = #{endPoint}" + "</script>")
	Permission findByEndPoint(String endPoint);
	@Select("	select * from permission "
			+ " left join role_permission on permission.permission_id=permission.permission_id"
			+ " left join member_role on role_permission.role_id=member_role.role_id "
			+ " where member_role.member_id= #{memberId}")
	List<Permission> findByMemberId(@Param("memberId")String memberId);
 
}
