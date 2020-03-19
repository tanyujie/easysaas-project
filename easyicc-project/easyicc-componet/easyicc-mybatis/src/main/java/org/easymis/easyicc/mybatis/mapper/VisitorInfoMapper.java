package org.easymis.easyicc.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easyicc.domain.entity.Card;
import org.easymis.easyicc.domain.entity.VisitorInfo;

public interface VisitorInfoMapper {

    @Select("<script>" +
            "select a.* from visitor_info a where  a.allocation_status > 0\n" +
            "        <where>\n" +
            "            <if test=\"status != null and id=1\">\n" +//退回
            "                and a.allocation_status = 2 and a.is_back = 1\n" +
            "            </if>\n" +
            "            <if test=\"status != null and id=2\">\n" +//超期回收
            "                and a.allocation_status = 2 and a.is_expired = 1\n" +
            "            </if>\n" +
            "            <if test=\"status != null and id=3\">\n" +//等待分配
            "                and a.allocation_status = 2 and a.is_expired = 0 and a.is_back = 0 and a.back_user_id is null\n" +
            "            </if>\n" +
            "            <if test=\"status != null and id=4\">\n" +//已处理
            "                and a.allocation_status = 4 and a.is_valid = 1 and a.back_user_id is null\n" +
            "            </if>\n" +
            "            <if test=\"status != null and id=5\">\n" +//未处理
            "                and (a.allocation_status = 1 or a.allocation_status = 3 ) and a.back_user_id is null\n" +
            "            </if>\n" +
            "            <if test=\"status != null and id=6\">\n" +//设置无效
            "                and a.allocation_status = 4 and a.is_valid = 0\n" +
            "            </if>\n" +
            "            <if test=\"status != null and id=7\">\n" +//再分配未处理
            "                and a.allocation_status = 3 and and  a.back_user_id is not null\n" +
            "            </if>\n" +
            "            <if test=\"status != null and id=8\">\n" +//再分配已处理
            "                and a.allocation_status = 4 and a.is_valid = 1 and a.back_user_id is not null\n" +
            "            </if>\n" +
            "            <if test=\"status != null and id=9\">\n" +//
            "                and a.allocation_status = 5 and a.is_expired = 1\n" +
            "            </if>\n" +
            "            <if test=\"orgId != null and orgId!=''\">\n" +//
            "                and a.orgId = #{orgId}\n" +
            "            </if>\n" +
            "            <if test=\"name != null and name!=''\">\n" +//
            "                and a.name = #{name}\n" +
            "            </if>\n" +    
            "            <if test=\"tel != null and tel!=''\">\n" +//
            "                and a.tel like #{tel}\n" +
            "            </if>\n" + 
            "            <if test=\"email != null and email!=''\">\n" +//
            "                and a.email like #{email}\n" +
            "            </if>\n" + 
            
            "        </where>" +
            "</script>")
	List<Card> getList(Map<String, Object> map);
	
	@Select("select * from js_visitor_info where id =#{cardId}")
	List<Card> findByCardId(@Param("cardId") String cardId);

	@Update("update js_visitor_info set is_valid = 0, is_expired = 0, is_back=0,  allocation_status = #{STATUS_FINISHED} where id = #{id} and modify_identity = #{modifyIdentity}")	 
	int updateStatusFinished(VisitorInfo bean);
}
