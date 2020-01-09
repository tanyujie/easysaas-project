package org.easymis.easysaas.gateway.entitys.mybatis.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.gateway.entitys.dto.SendSms;

public interface SendSmsMapper {
	 @Select("select count(*) from send_sms t where send_time>=DATE_SUB(NOW(),INTERVAL 30 MINUTE) and t.mobile = #{mobile} and t.send_type = #{sendType}")  
	 Integer getCount(@Param("mobile")String mobile,@Param("sendType")Integer sendType);
	 
   @Insert("INSERT INTO send_sms(id, mobile,send_time,send_type,code) " +
	            "VALUES(#{id}, #{mobile}, #{sendTime}, #{sendType}, #{code})")
	 void save(SendSms bean);
}