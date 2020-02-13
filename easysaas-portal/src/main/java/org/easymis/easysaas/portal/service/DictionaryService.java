package org.easymis.easysaas.portal.service;

import java.util.List;

public interface DictionaryService {
	List getEstiblishYearType();
	List getRegisteredCapitalType();
	//企业状态列表
	public List getCompanyStatusList();
    //资本币种列表
    public List getMoneyList();
    //企业类型列表
    public List getCompanyTypeList();
    //参保人数范围列表
    public List getSocialSecurityList();
	public List getSortList();
    public String getSortDepict(String key);
}
