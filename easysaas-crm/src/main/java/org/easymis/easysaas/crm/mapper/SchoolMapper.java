package org.easymis.easysaas.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.dto.Role;
import org.easymis.easysaas.crm.entitys.dto.School;
@Mapper
public interface SchoolMapper {
	@Select("select * from easymis_Resource t WHERE t.org_id = #{orgId}")
	School findById(@Param("id") String id);

	@Select("SELECT * FROM member WHERE name = #{name}")
	School findByUsername(@Param("name") String name);

	@Insert("INSERT INTO school(school_id, org_id, name, school_type, province_id, city_id, district_id, address_detail, contact, contact_backup) "
			+ "VALUES"
			+ " (#{schoolId}, #{orgId}, #{name}, #{schoolType}, #{provinceId}, #{cityId}, #{districtId}, #{addressDetail}, #{contact}, #{contactBackup});")
	boolean insertByBean(School bean);

	@Insert("<script> " + "insert into friend(" + "id, member_id,friend_id) " + "VALUES"
			+ "<foreach collection=\"itemList\" item=\"item\" index=\"index\"  separator=\",\">"
			+ "(#{item.id},#{item.memberId},#{item.friendId})" + "</foreach>" + " </script>")
	int insertByBeanList(@Param(value = "itemList") List<School> itemList);

	@Insert("INSERT INTO member_role(id, user_id,role_id) " + "VALUES(#{id}, #{userId}, #{roleId})")
	int intIntoUserRole(@Param("id") String id, @Param("userId") String userId, @Param("roleId") String roleId);

	@Update("UPDATE member set name=#{username},account=#{account},email=#{email},mobile=#{mobile},wx=#{wx},address=#{address},photo=#{photo},sex=#{sex} WHERE id = #{id}")
	boolean update(School bean);

	@Delete("DELETE FROM member WHERE id = #{id}")
	void delete(String id);

	// 删除用户和角色关系表里的数据
	@Delete("DELETE FROM member_role WHERE user_id = #{userId}")
	void deleteUserAndRoleByUserId(String userId);

	@Select("<script>" + "select\n"
			+ "          id, name,account,password,email,mobile,wx,create_time,address,photo,sex,status\n"
			+ "        from member\n" + "        <where>\n" + "            <if test=\"id != null and id != ''\">\n"
			+ "                and id = #{id}\n" + "            </if>\n"
			+ "            <if test=\"username != null and username != ''\">\n"
			+ "                and name = #{username}\n" + "            </if>\n"
			+ "            <if test=\"account != null and account != ''\">\n"
			+ "                and account = #{account}\n" + "            </if>\n"
			+ "            <if test=\"email != null and email != ''\">\n" + "                and email = #{email}\n"
			+ "            </if>\n" + "        </where>" + "</script>")
	List<School> findAll();

	@Update("UPDATE member set password=#{password} WHERE id = #{id}")
	void updatePassword(School bean);


	@Select("<script>" + "SELECT * FROM easymis_Resource " + "</script>")
	List<School> findByPage(School vo);

	@Select("<script>" + "SELECT * FROM role WHERE id in "
			+ "<foreach item=\"item\" index=\"index\" collection=\"roleIds\" open=\"(\" separator=\",\" close=\")\">"
			+ " #{item}" + "</foreach>" + "</script>")
	@Results({ @Result(property = "id", column = "id"), @Result(property = "roleName", column = "role_name"),
			@Result(property = "roleSn", column = "role_sn") })
	List<Role> findByRoleIds(@Param("roleIds") List<String> roleIds);



}
