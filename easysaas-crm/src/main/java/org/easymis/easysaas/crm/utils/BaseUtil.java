package org.easymis.easysaas.crm.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.easymis.easysaas.crm.entitys.vo.MemberVo;

public class BaseUtil {
    private static ThreadLocal<MemberVo> threadLocal = new ThreadLocal<>();
    private static final String USER_ADMIN_TOKEN = "EASYCRM_USER_ADMIN_TOKEN";

    private static final String USER_MOBILE_TOKEN = "EASYCRM_USER_MOBILE_TOKEN";
    /**
     * 获取当前年月的字符串
     *
     * @return yyyyMMdd
     */
	public static String getDate() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");
		return now.format(formatter2);
	}

    public static String getMemberId(){
        return getMember().getMemberId();
    }
    public static MemberVo getMember() {
        return threadLocal.get();
    }
    //FIXME 如果获取的地址不正确,直接返回一个固定地址也可以
    public static String getIpAddress(HttpServletRequest request) {
        StringBuilder str=new StringBuilder();
        str.append(request.getScheme()).append("://").append(request.getServerName());
        if(!Arrays.asList(80,443).contains(request.getServerPort())){
            str.append(":").append(request.getServerPort());
        }
        str.append(request.getContextPath());
        str.append("/");
        return str.toString();
    }
    public static void setMember(MemberVo adminUser) {
        threadLocal.set(adminUser);
    }
    public static String getUserId(){
        return getMember().getMemberId();
    }

    public static void removeThreadLocal(){
        threadLocal.remove();
    }

    public static String getToken(HttpServletRequest request){
        return request.getHeader("easysaasToken") != null ? request.getHeader("easysaasToken") : "";
    }

    public static void userExit(Long userId,Integer type){
/*        Redis redis = RedisManager.getRedis();
        if(type==null||type==1){
            if(redis.exists(USER_ADMIN_TOKEN+userId)){
                String token=redis.get(USER_ADMIN_TOKEN+userId);
                redis.del(USER_ADMIN_TOKEN+userId);
                redis.del(token);
            }
        }
        if(type==null||type==2){
            if(redis.exists(USER_MOBILE_TOKEN+userId)){
                String token=redis.get(USER_MOBILE_TOKEN+userId);
                redis.del(USER_MOBILE_TOKEN+userId);
                redis.del(token);
            }
        }*/
    }
    public static void setToken(Long userId,String token,Integer type){
        userExit(userId,type);
/*        Redis redis = RedisManager.getRedis();
        if(redis.exists(token)){
            if(type==1){
                redis.setex(USER_ADMIN_TOKEN+userId,redis.ttl(token).intValue(),token);
            }else if(type==2){
                redis.setex(USER_MOBILE_TOKEN+userId,redis.ttl(token).intValue(),token);
            }
        }*/

    }
    public static void userExpire(String token){
/*        Redis redis = RedisManager.getRedis();
        if(redis.exists(token)){
            redis.expire(token,3600);
            redis.expire(USER_ADMIN_TOKEN+getUserId(),3600);
            redis.expire(USER_MOBILE_TOKEN+getUserId(),3600);
        }*/
    }

}
