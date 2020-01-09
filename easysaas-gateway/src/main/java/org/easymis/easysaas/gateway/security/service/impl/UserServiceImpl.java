package org.easymis.easysaas.gateway.security.service.impl;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.validation.constraints.Pattern;

import org.easymis.easysaas.common.cache.RedisPrefixConstant;
import org.easymis.easysaas.common.cache.RedisUtils;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.common.sms.AliyunCommonRpc;
import org.easymis.easysaas.common.sms.AliyunSmsResult;
import org.easymis.easysaas.common.sms.SmsUtil;
import org.easymis.easysaas.common.utils.NameBuilder;
import org.easymis.easysaas.gateway.config.datasource.DataSourceType;
import org.easymis.easysaas.gateway.config.datasource.EasymisDataSource;
import org.easymis.easysaas.gateway.security.check.LoginWrongChecker;
import org.easymis.easysaas.gateway.security.service.UserService;
import org.easymis.easysaas.gateway.security.userdetail.User;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.sharepanzer.companydata.core.entitys.mybatis.dto.SendSms;
import com.sharepanzer.companydata.core.entitys.mybatis.mapper.SendSmsMapper;
import com.sharepanzer.companydata.core.web.mapper.UserMapper;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    private LoginWrongChecker checker = new LoginWrongChecker();
	@Autowired
	UserMapper mapper;
	@Autowired
	SendSmsMapper sendSmsMapper;
	@EasymisDataSource(DataSourceType.Master)
	public RestResult getRegShortMessage(
			@NotBlank @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号码格式不正确") String phoneNumber) {
        Integer count = sendSmsMapper.getCount(phoneNumber, 1);
        if(count>5) {
            return RestResult.buildFail("发送短信过于频繁,请稍后再试");
        }else {
            String code = SmsUtil.smsCode();
            AliyunSmsResult result = AliyunCommonRpc.sendSms(phoneNumber, code);
            if (!Objects.equals(result.getCode(), "OK")) {
                return RestResult.buildFail("发送短信过于频繁,请稍后再试");
            }
            redisTemplate.opsForValue().set(RedisUtils.joinKey(RedisPrefixConstant.USER_REG_SMS, phoneNumber), code, 5, TimeUnit.MINUTES); 
            SendSms bean= new SendSms();
            bean.setId(UUID.randomUUID().toString());
            bean.setCode(code);
            bean.setMobile(phoneNumber);
            bean.setSendType(1);
            bean.setSendTime(LocalDateTime.now());
            sendSmsMapper.save(bean);
        }


        return RestResult.buildSuccess();

    }
	@Override
	@EasymisDataSource(DataSourceType.Master)
	public RestResult getLoginShortMessage(
			@NotBlank @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号码格式不正确") String phoneNumber) {
        Integer count = sendSmsMapper.getCount(phoneNumber, 2);
        if(count>5) {
            return RestResult.buildFail("发送短信过于频繁,请稍后再试");
        }else {
            String code = SmsUtil.smsCode();
            AliyunSmsResult result = AliyunCommonRpc.sendSms(phoneNumber, code);
            if (!Objects.equals(result.getCode(), "OK")) {
                return RestResult.buildFail("发送短信过于频繁,请稍后再试");
            }
            redisTemplate.opsForValue().set(RedisUtils.joinKey(RedisPrefixConstant.USER_LOGIN_SMS, phoneNumber), code, 5, TimeUnit.MINUTES); 
            SendSms bean= new SendSms();
            bean.setId(UUID.randomUUID().toString());
            bean.setCode(code);
            bean.setMobile(phoneNumber);
            bean.setSendType(2);
            bean.setSendTime(LocalDateTime.now());
            sendSmsMapper.save(bean);
        }
        return RestResult.buildSuccess();

    }
	@Override
	@EasymisDataSource(DataSourceType.Master)
	public RestResult sendForgitPasswordSmsCode(
			@NotBlank @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号码格式不正确") String phoneNumber) {
        Integer count = sendSmsMapper.getCount(phoneNumber, 3);
        if(count>5) {
            return RestResult.buildFail("发送短信过于频繁,请稍后再试");
        }else {
            String code = SmsUtil.smsCode();
            AliyunSmsResult result = AliyunCommonRpc.sendSms(phoneNumber, code);
            if (!Objects.equals(result.getCode(), "OK")) {
                return RestResult.buildFail("发送短信过于频繁,请稍后再试");
            }
            redisTemplate.opsForValue().set(RedisUtils.joinKey(RedisPrefixConstant.USER_FORGIT_PASSWORD_SMS, phoneNumber), code, 5, TimeUnit.MINUTES); 
            SendSms bean= new SendSms();
            bean.setId(UUID.randomUUID().toString());
            bean.setCode(code);
            bean.setMobile(phoneNumber);
            bean.setSendType(3);
            bean.setSendTime(LocalDateTime.now());
            sendSmsMapper.save(bean);
        }
        return RestResult.buildSuccess();
    }
	@EasymisDataSource(DataSourceType.Master)
	public RestResult quickReg(
			@NotBlank @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号码格式不正确") String phoneNumber,
			@NotBlank String code, String password) {
        String cacheCode = (String) redisTemplate.opsForValue().get(RedisUtils.joinKey(RedisPrefixConstant.USER_REG_SMS, phoneNumber));
        if (!Objects.equals(cacheCode, code)) {
            return RestResult.buildFail("验证码错误!");
        } else {
            RestResult restResult = RestResult.buildSuccess();
            User user = generateUser(phoneNumber, password);
            user.setEnabled(true);
            try {
            	mapper.insertByBean(user);
            } catch (DuplicateKeyException e) {
                return RestResult.buildFail("该号码已经被注册!");
            }
            return restResult;
        }
    }

	@EasymisDataSource(DataSourceType.Master)
	public User quickReg(String phoneNumber) {
		User user = new User();
        user.setPhoneNumber(phoneNumber);
        //user.setPassword(Optional.ofNullable(password).orElse(generatePassword()));
        user.setCreateTime(LocalDateTime.now());
        user.setSex("男");  //默认男
        user.setUserNo(generateUserNo(phoneNumber));
        //user.setName(generateUsername());
        user.setName(NameBuilder.build(4));
        user.setEnabled(true);
		mapper.insertByBean(user);
		return user;
	}

	@EasymisDataSource(DataSourceType.Master)
	public RestResult changePasswordByOldpwd(String oldpwd, @NotBlank(message = "新密码不能为空") String newpwd,
			String phonwNumber) {
        User user =findByPhoneNumber(phonwNumber);
        if (Objects.isNull(user)) {
            return RestResult.buildError("该号码未注册");
        }
        if (Objects.equals(oldpwd, user.getPassword())) {
        	user.setPassword(newpwd);
            updatePassword(user);
            //解除账号锁定
            checker.loginUnlock(redisTemplate,phonwNumber);
            return RestResult.buildSuccess();
        } else {
            return RestResult.buildFail("旧密码错误");
        }
    }

	@EasymisDataSource(DataSourceType.Master)
	public RestResult changePasswordBySmsCode(String smscode, @NotBlank(message = "新密码不能为空") String newpwd,
			String phonwNumber) {
        User user = mapper.findByPhoneNumber(phonwNumber);
        if (Objects.isNull(user)) {
            return RestResult.buildError("该号码未注册");
        }
        String cacheCode = (String) redisTemplate.opsForValue().get(RedisUtils.joinKey(RedisPrefixConstant.USER_FORGIT_PASSWORD_SMS, user.getPhoneNumber()));
        if (Objects.equals(cacheCode, smscode)) {
        	user.setPassword(newpwd);
            updatePassword(user);
            //解除账号锁定
            checker.loginUnlock(redisTemplate,phonwNumber);
            return RestResult.buildSuccess();
        } else {
            return RestResult.buildFail("验证码过期或者错误");
        }
    }

	@EasymisDataSource(DataSourceType.Master)
	public User findByPhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		return mapper.findByPhoneNumber(phoneNumber);
	}

	@EasymisDataSource(DataSourceType.Master)
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return mapper.findByEmail(email);
	}

	@EasymisDataSource(DataSourceType.Master)
	public User findByUserno(String userno) {
		// TODO Auto-generated method stub
		return mapper.findByUserno(userno);
	}
    protected User generateUser(String phoneNumber, String password) {
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        user.setPassword(Optional.ofNullable(password).orElse(generatePassword()));
        user.setCreateTime(LocalDateTime.now());
        user.setSex("男");  //默认男
        user.setUserNo(generateUserNo(phoneNumber));
        user.setName(generateUsername());
        return user;
    }
	@Override
	public void updatePassword(User user) {
		// TODO Auto-generated method stub
		mapper.updatePassword(user);
	}



}
