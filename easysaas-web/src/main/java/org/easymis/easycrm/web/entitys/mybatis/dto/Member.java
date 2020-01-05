package org.easymis.easycrm.web.entitys.mybatis.dto;

import java.util.Date;

public class Member {
	private String memberId;
	private String orgId;
	private String memberName;
	private String name;
	private String nickname;
	private String password;
	private Boolean gender;
	private Date birth;
	private String intro;
	private String comefrom;
	private String qq;
	private String phone;
	private String mobile;
	private String signature;
	private String idCardNo;
	private Integer bpValue;
	private Integer freezedValue;
	private Float balance;
	private Float money;
	private Float frozenMoney;
	private Integer signInTimes;
	private Date signInDate;
	private Integer signInTimeAll;
	private Date updatePasswordTime;
	private Integer loginFailureCount;
	//@GenField(labelname = "会话id，SessionId", column = "session_id", length = 45, isnull = true)
	private String sessionId;
	//@GenField(labelname = "注册渠道1网站2安卓手机3苹果手机4wap网站5其它渠道", column = "register_channel", isnull = false)
	private Integer registerChannel;
	//@GenField(labelname = "注册时间", column = "register_time", isnull = true)
	private Date registerTime;
	//@GenField(labelname = "注册IP", column = "register_ip", length = 255, isnull = true)
	private String registerIp;
	//@GenField(labelname = "最后登录时间", column = "last_login_time", isnull = true)
	private Date lastLoginTime;
	//@GenField(labelname = "最后登录IP", column = "last_login_ip", length = 255, isnull = true)
	private String lastLoginIp;
	//@GenField(labelname = "登录次数", column = "login_count", isnull = true)
	private Integer loginCount;
	//@GenField(labelname = "管理员级别", column = "rank", isnull = true)
	private Integer rank;
	//@GenField(labelname = "上传总大小", column = "upload_total", isnull = true)
	private Integer uploadTotal;
	//@GenField(labelname = "上传大小", column = "upload_size", isnull = true)
	private Integer uploadSize;
	//@GenField(labelname = "上传日期", column = "upload_date", isnull = true)
	private Date uploadDate;
	//@GenField(labelname = "是否管理员", column = "is_admin", isnull = true)
	private Boolean isAdmin;
	//@GenField(labelname = "是否只管理自己的数据1是0否", column = "is_self_admin", isnull = true)
	private Boolean isSelfAdmin;
	//@GenField(labelname = "是否禁用1禁用0否", column = "is_disabled", isnull = true)
	private Boolean isDisabled;
	//@GenField(labelname = "会员状态0初始1审核中2已审批3审批不通过", column = "status", isnull = true)
	private Integer status;
	//@GenField(labelname = "用户类型(1个人、2企业机构、3商户、4店小二)", column = "user_type", length = 255, isnull = true)
	private String userType;
	//@GenField(labelname = "公司名称", column = "company_name", length = 255, isnull = true)
	private String companyName;
	//@GenField(labelname = "公司地址", column = "company_address", length = 255, isnull = true)
	private String companyAddress;
	//@GenField(labelname = "法人", column = "handler_office", length = 255, isnull = true)
	private String handlerOffice;
	//@GenField(labelname = "公司电话", column = "company_telephone", length = 255, isnull = true)
	private String companyTelephone;
	//@GenField(labelname = "网站", column = "company_url", length = 255, isnull = true)
	private String companyUrl;
	//@GenField(labelname = "公司logo|组织logo", column = "company_logo", length = 255, isnull = true)
	private String companyLogo;
	//@GenField(labelname = "兴趣爱好", column = "hobby", length = 255, isnull = true)
	private String hobby;
	//@GenField(labelname = "地址_国别", column = "country_id", isnull = true)
	private Integer countryId;
	//@GenField(labelname = "国名", column = "country_name", length = 255, isnull = true)
	private String countryName;
	//@GenField(labelname = "地址_省市", column = "province_id", isnull = true)
	private Integer provinceId;
	//@GenField(labelname = "", column = "province_name", length = 255, isnull = true)
	private String provinceName;
	//@GenField(labelname = "地址_地市", column = "city_id", isnull = true)
	private Integer cityId;
	//@GenField(labelname = "城市名", column = "city_name", length = 255, isnull = true)
	private String cityName;
	//@GenField(labelname = "地址_区县", column = "district_id", isnull = true)
	private Integer districtId;
	//@GenField(labelname = "区县名", column = "district_name", length = 255, isnull = true)
	private String districtName;
	//@GenField(labelname = "头像照片", column = "avatar", length = 255, isnull = true)
	private String avatar;
	//@GenField(labelname = "经验值", column = "experience", length = 255, isnull = true)
	private String experience;
	//@GenField(labelname = "等级编号", column = "rank_number", isnull = true)
	private Integer rankNumber;
	//@GenField(labelname = "等级变更日期", column = "rank_change_date", isnull = true)
	private Date rankChangeDate;
	//@GenField(labelname = "当年剩余积分", column = "now_integral", length = 255, isnull = true)
	private String nowIntegral;
	//@GenField(labelname = "登录失败次数", column = "login_fail_times", isnull = true)
	private Integer loginFailTimes;
	//@GenField(labelname = "解锁时间", column = "unlock_date", isnull = true)
	private Date unlockDate;
	//@GenField(labelname = "邮箱激活标识", column = "email_activation_sign", length = 255, isnull = true)
	private String emailActivationSign;
	//@GenField(labelname = "手机激活标识", column = "mobile_activation_sign", length = 255, isnull = true)
	private String mobileActivationSign;
	//@GenField(labelname = "企业审核状态 1=准入受理", column = "company_verify_state", isnull = true)
	private Integer companyVerifyState;
	//@GenField(labelname = "审核意见", column = "verify_depict", length = 500, isnull = true)
	private String verifyDepict;
	//@GenField(labelname = "注册资金", column = "reg_capital", length = 255, isnull = true)
	private String regCapital;
	//@GenField(labelname = "联系人姓名", column = "contact_person", length = 255, isnull = true)
	private String contactPerson;
	//@GenField(labelname = "联系人电话", column = "contact_mobile", length = 11, isnull = true)
	private String contactMobile;
	//@GenField(labelname = "认证级别1注册2认证3达人", column = "verify_type_id", length = 20, isnull = true)
	private String verifyTypeId;
	//@GenField(labelname = "证件类型", column = "certificate_id", length = 20, isnull = true)
	private String certificateId;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getComefrom() {
		return comefrom;
	}
	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public Integer getBpValue() {
		return bpValue;
	}
	public void setBpValue(Integer bpValue) {
		this.bpValue = bpValue;
	}
	public Integer getFreezedValue() {
		return freezedValue;
	}
	public void setFreezedValue(Integer freezedValue) {
		this.freezedValue = freezedValue;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public Float getMoney() {
		return money;
	}
	public void setMoney(Float money) {
		this.money = money;
	}
	public Float getFrozenMoney() {
		return frozenMoney;
	}
	public void setFrozenMoney(Float frozenMoney) {
		this.frozenMoney = frozenMoney;
	}
	public Integer getSignInTimes() {
		return signInTimes;
	}
	public void setSignInTimes(Integer signInTimes) {
		this.signInTimes = signInTimes;
	}
	public Date getSignInDate() {
		return signInDate;
	}
	public void setSignInDate(Date signInDate) {
		this.signInDate = signInDate;
	}
	public Integer getSignInTimeAll() {
		return signInTimeAll;
	}
	public void setSignInTimeAll(Integer signInTimeAll) {
		this.signInTimeAll = signInTimeAll;
	}
	public Date getUpdatePasswordTime() {
		return updatePasswordTime;
	}
	public void setUpdatePasswordTime(Date updatePasswordTime) {
		this.updatePasswordTime = updatePasswordTime;
	}
	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}
	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Integer getRegisterChannel() {
		return registerChannel;
	}
	public void setRegisterChannel(Integer registerChannel) {
		this.registerChannel = registerChannel;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public String getRegisterIp() {
		return registerIp;
	}
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Integer getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getUploadTotal() {
		return uploadTotal;
	}
	public void setUploadTotal(Integer uploadTotal) {
		this.uploadTotal = uploadTotal;
	}
	public Integer getUploadSize() {
		return uploadSize;
	}
	public void setUploadSize(Integer uploadSize) {
		this.uploadSize = uploadSize;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Boolean getIsSelfAdmin() {
		return isSelfAdmin;
	}
	public void setIsSelfAdmin(Boolean isSelfAdmin) {
		this.isSelfAdmin = isSelfAdmin;
	}
	public Boolean getIsDisabled() {
		return isDisabled;
	}
	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getHandlerOffice() {
		return handlerOffice;
	}
	public void setHandlerOffice(String handlerOffice) {
		this.handlerOffice = handlerOffice;
	}
	public String getCompanyTelephone() {
		return companyTelephone;
	}
	public void setCompanyTelephone(String companyTelephone) {
		this.companyTelephone = companyTelephone;
	}
	public String getCompanyUrl() {
		return companyUrl;
	}
	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}
	public String getCompanyLogo() {
		return companyLogo;
	}
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Integer getRankNumber() {
		return rankNumber;
	}
	public void setRankNumber(Integer rankNumber) {
		this.rankNumber = rankNumber;
	}
	public Date getRankChangeDate() {
		return rankChangeDate;
	}
	public void setRankChangeDate(Date rankChangeDate) {
		this.rankChangeDate = rankChangeDate;
	}
	public String getNowIntegral() {
		return nowIntegral;
	}
	public void setNowIntegral(String nowIntegral) {
		this.nowIntegral = nowIntegral;
	}
	public Integer getLoginFailTimes() {
		return loginFailTimes;
	}
	public void setLoginFailTimes(Integer loginFailTimes) {
		this.loginFailTimes = loginFailTimes;
	}
	public Date getUnlockDate() {
		return unlockDate;
	}
	public void setUnlockDate(Date unlockDate) {
		this.unlockDate = unlockDate;
	}
	public String getEmailActivationSign() {
		return emailActivationSign;
	}
	public void setEmailActivationSign(String emailActivationSign) {
		this.emailActivationSign = emailActivationSign;
	}
	public String getMobileActivationSign() {
		return mobileActivationSign;
	}
	public void setMobileActivationSign(String mobileActivationSign) {
		this.mobileActivationSign = mobileActivationSign;
	}
	public Integer getCompanyVerifyState() {
		return companyVerifyState;
	}
	public void setCompanyVerifyState(Integer companyVerifyState) {
		this.companyVerifyState = companyVerifyState;
	}
	public String getVerifyDepict() {
		return verifyDepict;
	}
	public void setVerifyDepict(String verifyDepict) {
		this.verifyDepict = verifyDepict;
	}
	public String getRegCapital() {
		return regCapital;
	}
	public void setRegCapital(String regCapital) {
		this.regCapital = regCapital;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactMobile() {
		return contactMobile;
	}
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	public String getVerifyTypeId() {
		return verifyTypeId;
	}
	public void setVerifyTypeId(String verifyTypeId) {
		this.verifyTypeId = verifyTypeId;
	}
	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
	}
	
}
