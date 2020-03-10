package org.easymis.easysaas.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.crm.entitys.dto.Member;

public interface MemberMapper {
	 @Select("select * from member t WHERE t.member_id = #{memberId}")  
	 Member findById(@Param("memberId") String memberId);

    @Select("SELECT * FROM member WHERE name = #{name}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "Membername", column = "name"),
/*            @Result(property = "roles", column = "id", many = @Many(select = "com.zingtech.nlp.admin.mapper.ResourceRoleMapper.findByMemberId")),*/
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
    Member findByMembername(@Param("name") String name);

    @Insert("insert into Member(id, Member_no, sex, age, company_name, department, position, password, head_url, phone_number, email, modify_time, create_time, name, enabled)"
    		+ "values"
    		+ "(#{id},#{MemberNo},#{sex},#{age},#{companyName},#{department},#{position},#{password},#{headUrl},#{phoneNumber},#{email},#{modifyTime},#{createTime},#{name},#{enabled})")  
    int insertByBean(Member bean);

    @Insert("<script> " + "insert into friend(" +
            "id, member_id,friend_id) " + "VALUES" +
            "<foreach collection=\"itemList\" item=\"item\" index=\"index\"  separator=\",\">" +
            "(#{item.id},#{item.memberId},#{item.friendId})" +
            "</foreach>" +
            " </script>")
    int insertByBeanList(@Param(value="itemList") List<Member> itemList);
    
    @Insert("INSERT INTO member_role(id, Member_id,role_id) " +
            "VALUES(#{id}, #{MemberId}, #{roleId})")
    int intIntoMemberRole(@Param("id") String id,@Param("MemberId") String MemberId,@Param("roleId") String roleId);

    @Update("UPDATE member set name=#{Membername},account=#{account},email=#{email},mobile=#{mobile},wx=#{wx},address=#{address},photo=#{photo},sex=#{sex} WHERE id = #{id}")
    void update(Member bean);

    @Delete("DELETE FROM member WHERE id = #{id}")
    void delete(String id);

    //删除用户和角色关系表里的数据
    @Delete("DELETE FROM member_role WHERE Member_id = #{MemberId}")
    void deleteMemberAndRoleByMemberId(String MemberId);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "Membername", column = "name"),
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
            "            <if test=\"Membername != null and Membername != ''\">\n" +
            "                and name = #{Membername}\n" +
            "            </if>\n" +
            "            <if test=\"account != null and account != ''\">\n" +
            "                and account = #{account}\n" +
            "            </if>\n" +
            "            <if test=\"email != null and email != ''\">\n" +
            "                and email = #{email}\n" +
            "            </if>\n" +
            "        </where>" +
            "</script>")
    List<Member> findAll();

    @Update("UPDATE Member set password=#{password} WHERE id = #{id}")
    void updatePassword(Member bean);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "Membername", column = "name"),
            @Result(property = "roles", column = "id", many = @Many(select = "com.zingtech.nlp.admin.mapper.ResourceRoleMapper.findByMemberId")),
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
    List<Member> findByPage(Member vo);

	@Select("<script>" + "SELECT * FROM Member WHERE phone_number=#{phoneNumber}" + "</script>")
	Member findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
	
	@Select("<script>" + "SELECT * FROM Member WHERE email = #{email}" + "</script>")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "MemberNo", column = "Member_no"),
        @Result(property = "phoneNumber", column = "phone_number"),
        @Result(property = "enabled", column = "enabled")
})
	Member findByEmail(String email);
	@Select("<script>" + "SELECT * FROM Member WHERE Member_no = #{MemberNo}" + "</script>")
    @Results({
        @Result(property = "id", column = "id"),
/*        @Result(property = "MemberNo", column = "Member_no"),
        @Result(property = "phoneNumber", column = "phone_number"),*/
        @Result(property = "password", column = "password"),
        @Result(property = "enabled", column = "enabled")
})
	Member findByMemberno(String MemberNo);
 
}
