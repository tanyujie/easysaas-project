package org.easymis.easysaas.member.security.check;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.DisabledException;

import lombok.extern.slf4j.Slf4j;

/**
 *  用于 登录错误次数检测
 *
 */
@Slf4j
public class LoginWrongChecker    {

    public static final String ACCOUNT_LOCKED = "LoginWrongChecker:accountLocked:";


    public static final String WRONG_NUMBER ="LoginWrongChecker:wrongNumber:";

    public static final String ACCOUNT_LOCKED_WARNING= "登录错误次数过多,账号已被锁定30分钟";

    public static final int LIMIT =4;

    /**
     *
     *
     *  检查key是否存在
     * @param redisTemplate
     * @param username
     */

   public void  check(RedisTemplate<String,Object> redisTemplate, String username){
       Boolean aBoolean =  redisTemplate.hasKey(ACCOUNT_LOCKED + username);
       if (aBoolean) {
           throw new DisabledException(ACCOUNT_LOCKED_WARNING);
       }else{
           Integer  number  = (Integer) redisTemplate.boundValueOps(WRONG_NUMBER + username).get();
           if(Objects.nonNull(number) && number>LIMIT){
               redisTemplate.delete(WRONG_NUMBER+username);
               log.info("username={}因为登录错误次数过多账号锁定,现已解除",username);
           }

       }
   }

    /**
     *
     *
     *   错误次数>4次将被锁定
     * @param redisTemplate
     * @param username
     */

   public void loginError(RedisTemplate<String,Object> redisTemplate,String username){
       Long increment = redisTemplate.boundValueOps(WRONG_NUMBER + username).increment(1);
       if(increment>LIMIT){
           redisTemplate.opsForValue().set( ACCOUNT_LOCKED+ username,true,30,TimeUnit.MINUTES );
           log.info("username={}登录错误超过5次账号已经被锁定.",username);
       }
   }


    /**
     *
     *  登录正确后删除错误记录
     *
     * @param redisTemplate
     * @param username
     */

    public void removeWarningRecord(RedisTemplate<String,Object> redisTemplate,String username){
        redisTemplate.delete(WRONG_NUMBER + username);
    }

    /**
     *
     *
     *   解除锁定
     * @param redisTemplate
     * @param username
     */

    public void loginUnlock(RedisTemplate<String,Object> redisTemplate ,String username){
        redisTemplate.delete(ACCOUNT_LOCKED + username);
    }




}
