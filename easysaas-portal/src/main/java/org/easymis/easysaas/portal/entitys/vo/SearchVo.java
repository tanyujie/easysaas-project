package org.easymis.easysaas.portal.entitys.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;

import org.apache.commons.lang.StringUtils;
import org.easymis.easysaas.portal.service.impl.DictionaryServiceImpl;
import org.easymis.easysaas.portal.utils.DistrictUtil;
import org.hibernate.validator.constraints.Range;

import com.github.pagehelper.util.StringUtil;

import lombok.Data;

@Data
public class SearchVo {
    //公司id
    public String companyId;
	private String wd;
	//t100经营风险,t200经营风险,t300经营状况,t400知识产权
	private Integer term;
	//搜索范围
	private String searchType;
	private String searchTypeDepict;
	//机构类型
	private String organizationType;
	private String organizationTypeDepict;
	//省份地区
	private boolean filterProvince=true;
	private List provinceList;
	private String province;
	private String provinceDepict;
	
	private boolean filterCity=true;
	private List cityList;
	private String city;
	private String cityDepict;
	
	//区县
	private boolean filterDistrict=true;
	private List districtList;
	private String district;
	private String areaCode;
	private String districtDepict;
	//注册资本
	private List registerCapitalList;
	private String registerCapitalType;
	private String registerCapitalDepict;
	//成立时间,成立时间范围
    private List estiblishYearList;
    private String estiblishYearType;
	private String estiblishYearDepict;
	//行业分类
	private boolean filterCategoryFirst=true;
	private List categoryFirstList;
    private String categoryFirst;
    private String categoryFirstDepict;
    
	private boolean filterCategorySecond=true;
	private List categorySecondList;
    private String categorySecond;
    private String categorySecondDepict;
    
	private boolean filterCategoryThird=true;
	private List categoryThirdList;
    private String categoryThird;
    private String categoryThirdDepict;

 
    //企业描述
    private boolean filterDepict=true;

	//资本类型,注册资本金额范围
    private Integer registerCapitalNumberType;
    //注册资本金额范围-开始
    @Min(value = 0, message = "注册资本金额范围不合法,请检查")
    private Long registerCapitalFrom;
    //注册资本金额范围-结束
    @Min(value = 1, message = "注册资本金额范围不合法,请检查")
    private Long registerCapitalTo;
	//企业状态列表
    private String companyStatusList;
	//企业状态:在业
    private String companyStatus;
    //资本币种列表
    private List  moneyList;
    //资本币种：人民币，美元，其他
    private String moneyType;
    //企业类型列表
    private List  companyTypeList;
    //企业类型
    private String companyType;
    //参保人数范围列表
    private List  socialSecurityList;
    //参保人数范围
    private String  socialSecurityType;

    //参保人数范围-开始
    @Min(0)
    private Integer insurancePersonNumberFrom;
    //参保人数范围-结束
    @Range(min = 0, max = 100000000, message = "参保人数范围不合法，请检查")
    private Integer insurancePersonNumberTo;
    
    //企业描述
    private boolean filterAdvanced=true;
    //联系方式1,有联系方式0无联系方式
    public Integer haveContact;
    //手机号码
    private Integer havePhone;
    //是否有email
    @Range(min = 0, max = 1)
    public Integer haveMail;

    //是否有商标
    @Range(min = 0, max = 1)
    public Integer haveTrademark;
    //专利信息
    @Range(min = 0, max = 1)
    public Integer havePatent;
    //融资信息
    @Range(min = 0, max = 1)
    public Integer haveFinance;
    //上市状态
    @Range(min = 0, max = 1)
    public Integer haveIpo;
    //失信信息
    @Range(min = 0, max = 1)
    public Integer haveDishonest;
    
    //是否有网址
    @Range(min = 0, max = 1)
    public Integer haveWebSite;
    //动产抵押
    @Range(min = 0, max = 1)
    public Integer haveMpledge;
    //500强
    @Range(min = 0, max = 1)
    public Integer haveTop500;
    //作品著作权
    @Range(min = 0, max = 1)
    public Integer haveCopyrightWorks;
    //软件著作权
    @Range(min = 0, max = 1)
    public Integer haveSoftwareCopyright;
    //高新企业
    @Range(min = 0, max = 1)
    public Integer haveHighTech;
    //招投标
    @Range(min = 0, max = 1)
    public Integer haveTender;
    //清算信息
    @Range(min = 0, max = 1)
    public Integer haveClearing;
    //排序类型
	private List sortList;
    private String sortType;
    private String sortDepict;
    @Range(min = 1, max = 30, message = "每页最大数量为30")
    public Integer pageSize = 10;
    @Min(value = 1, message = "pageNo大于等于1")
    public Integer pageNo = 1;
	private boolean filterScope=false;

	public boolean isFilterScope() {
		if(StringUtil.isNotEmpty(searchType)||StringUtil.isNotEmpty(organizationType)||StringUtil.isNotEmpty(province)
				||registerCapitalType!=null||estiblishYearType!=null||StringUtil.isNotEmpty(categoryFirst)
				||companyStatus!=null||moneyType!=null||companyType!=null||socialSecurityType!=null
				||haveContact!=null||havePhone!=null||haveMail!=null||haveTrademark!=null||havePatent!=null
				||haveFinance!=null||haveIpo!=null||haveDishonest!=null||haveWebSite!=null||haveMpledge!=null
				||haveTop500!=null||haveCopyrightWorks!=null||haveSoftwareCopyright!=null||haveHighTech!=null
				||haveTender!=null||haveClearing!=null
				||sortType!=null

				)
			return true;
		return filterScope;
	}
	public void setFilterScope(boolean filterScope) {
		this.filterScope = filterScope;
	}

	public String getSearchType() {
		if (StringUtils.isEmpty(searchType))
			return null;
		return searchType;
	}

	public String getSearchTypeDepict() {
		if(null!=searchType) {
			if(searchType.equals("company"))
				return "企业名称";
			else if(searchType.equals("human"))
				return "法人/股东/高管";
			else if(searchType.equals("service"))
				return "产品服务";
			else if(searchType.equals("trademark"))
				return "商标";
			else if(searchType.equals("similarAddr"))
				return "联系方式";
			else if(searchType.equals("scope"))
				return "经营范围";
			return null;
		}			
		else
			return null;
	}
	public String getOrganizationTypeDepict() {
		if(null!=organizationType) {
			if(organizationType.equals("normal_company"))
				return "企业";
			else if(organizationType.equals("institution"))
				return "事业单位";
			else if(organizationType.equals("npo_foundation"))
				return "基金会";
			else if(organizationType.equals("npo"))
				return "社会组织";
			else if(organizationType.equals("lawFirm"))
				return "律所";
			else if(organizationType.equals("hk"))
				return "香港特别行政区企业";
			else if(organizationType.equals("tw"))
				return "台湾省企业";
			return null;
		}			
		else
			return null;
	}

	public boolean isFilterProvince() {
		if(StringUtil.isNotEmpty(province))
			return false;
		return filterProvince;
	}
	 
	public List getProvinceList() {
		return DistrictUtil.getProvinceList();
	}

	public String getProvinceDepict() {
		if(StringUtil.isNotEmpty(province)) {
			return DistrictUtil.getProvince(province).getProvince();
		}			
		else
			return null;
	}

	public boolean isFilterCity() {
		if(StringUtil.isEmpty(province)||province.equals("bj")||province.equals("tj")||province.equals("sh")||province.equals("cq"))
			return false;
		if(StringUtil.isNotEmpty(city))
			return false;
		return filterCity;
	}
	public List getCityList() {
		if(StringUtil.isNotEmpty(province))
			return DistrictUtil.getCityList(province);
		return cityList;
	}


	public String getCityDepict() {
		if(StringUtil.isNotEmpty(city)) {
			return DistrictUtil.getCity(city).getCity();
		}			
		else
			return null;
	}

	public boolean isFilterDistrict() {
		if(StringUtil.isEmpty(province))
			return false;
		if((StringUtil.isEmpty(city)&&(province.equals("bj")||province.equals("tj")||province.equals("sh")||province.equals("cq")))&&StringUtil.isEmpty(district))
			return true;
		if(StringUtil.isEmpty(city)||StringUtil.isNotEmpty(district))
			return false;
		return filterCity;
	}
	public List getDistrictList() {
		if(StringUtil.isNotEmpty(province)&&(province.equals("bj")||province.equals("tj")||province.equals("sh")||province.equals("cq")))
			return DistrictUtil.getDistrictList(province);
		else if(StringUtil.isNotEmpty(city))
			return DistrictUtil.getDistrictList(city);			
		return districtList;
	}

	public String getDistrictDepict() {
		if(StringUtil.isNotEmpty(district)) {
			return DistrictUtil.getDistrict(district).getDistrict();
		}			
		else
			return null;
	}
	public List getEstiblishYearList() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getEstiblishYearType();
	}
	public List getRegisterCapitalList() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getRegisteredCapitalType();
	}
	public boolean isfilterCategoryFirst() {
		if(StringUtil.isNotEmpty(categoryFirst))
			return false;
		return filterCategoryFirst;
	}
	public List getCategoryFirstList() {
		return DistrictUtil.getCategoryFirstList();
	}
	//企业状态列表
	public List getCompanyStatusList() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getCompanyStatusList();
	}
	//企业状态:在业
    public String getCompanyStatusDepict() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getCompanyStatus(companyStatus);
    }
    //资本币种列表
    public List getMoneyList() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getMoneyList();
    }
    public String getRegisterCapitalDepict() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getRegisteredCapital(registerCapitalType);
    }

    public String getEstiblishYearDepict() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getEstiblishYear(estiblishYearType);
    }
    //资本币种：人民币，美元，其他
    public String getMoneyTypeDepict() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getMoney(moneyType);
    }
    //企业类型列表
    public List getCompanyTypeList() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getCompanyTypeList();
    }
    //企业类型
    public String getCompanyTypeDepict() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getCompanyType(companyType);
    }
    //参保人数范围列表
    public List getSocialSecurityList() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getSocialSecurityList();
    }
    public String getSocialSecurityDepict() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getSocialSecurity(socialSecurityType);
    }
	public boolean isFilterDepict(){
		if(StringUtil.isNotEmpty(companyStatus)&&StringUtil.isNotEmpty(moneyType)&&StringUtil.isNotEmpty(companyType)&&socialSecurityType!=null)
			return false;
		return filterDepict;
	}
	
	public boolean isFilterAdvanced() {
		if(haveContact!=null&&havePhone!=null&&haveMail!=null&&haveTrademark!=null&&havePatent!=null&&haveFinance!=null&&haveDishonest!=null&&haveIpo!=null&&haveWebSite!=null&&haveMpledge!=null&&haveTop500!=null&&haveCopyrightWorks!=null&&haveSoftwareCopyright!=null)
			return false;
		return filterAdvanced;
	}
	public List getSortList() {
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getSortList();
    }
    public String getSortDepict(){
		DictionaryServiceImpl dictionaryService= new DictionaryServiceImpl();
		return dictionaryService.getSortDepict(sortType);
    }
	public String increaseParameter(String filterString) {
		StringBuffer url=new StringBuffer();
		String filter=filterString.split("=")[0];
		if(StringUtils.isNotEmpty(wd)) {
			url.append("wd=");
			url.append(wd);
		}
		
		if(StringUtils.isNotEmpty(searchType)&&!filter.equals("searchType")) {
			url.append("&searchType=");
			url.append(searchType);
		}else if(filter.equals("searchType")) {
			url.append("&");
			url.append(filterString);
		}
		if(StringUtils.isNotEmpty(organizationType)&&!filter.equals("organizationType")) {
			url.append("&organizationType=");
			url.append(organizationType);
		}else if(filter.equals("organizationType")) {
			url.append("&");
			url.append(filterString);
		}
		
		if(StringUtils.isNotEmpty(province)&&!filter.equals("province")) {
			url.append("&province=");
			url.append(province);
		}else if(filter.equals("province")) {
			url.append("&");
			url.append(filterString);
		}
		if (StringUtils.isNotEmpty(city) && !filter.equals("city")) {
			url.append("&city=");
			url.append(city);
		} else if (filter.equals("city")) {
			url.append("&");
			url.append(filterString);
		}
		if (StringUtils.isNotEmpty(district) && !filter.equals("district")) {
			url.append("&district=");
			url.append(district);
		} else if (filter.equals("district")) {
			url.append("&");
			url.append(filterString);
		}
		if (registerCapitalType!=null && !filter.equals("registerCapitalType")) {
			url.append("&registerCapitalType=");
			url.append(registerCapitalType);
		} else if (filter.equals("registerCapitalType")) {
			url.append("&");
			url.append(filterString);
		}
		if (estiblishYearType!=null && !filter.equals("estiblishYearType")) {
			url.append("&estiblishYearType=");
			url.append(estiblishYearType);
		} else if (filter.equals("estiblishYearType")) {
			url.append("&");
			url.append(filterString);
		}
		if (categoryFirst!=null && !filter.equals("categoryFirst")) {
			url.append("&categoryFirst=");
			url.append(categoryFirst);
		} else if (filter.equals("categoryFirst")) {
			url.append("&");
			url.append(filterString);
		}
		
		if (companyStatus!=null && !filter.equals("companyStatus")) {
			url.append("&companyStatus=");
			url.append(companyStatus);
		} else if (filter.equals("companyStatus")) {
			url.append("&");
			url.append(filterString);
		}
		if (moneyType!=null && !filter.equals("moneyType")) {
			url.append("&moneyType=");
			url.append(moneyType);
		} else if (filter.equals("moneyType")) {
			url.append("&");
			url.append(filterString);
		}
		if (companyType!=null && !filter.equals("companyType")) {
			url.append("&companyType=");
			url.append(companyType);
		} else if (filter.equals("companyType")) {
			url.append("&");
			url.append(filterString);
		}
		if (socialSecurityType!=null && !filter.equals("socialSecurityType")) {
			url.append("&socialSecurityType=");
			url.append(socialSecurityType);
		} else if (filter.equals("socialSecurityType")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveContact!=null && !filter.equals("haveContact")) {
			url.append("&haveContact=");
			url.append(haveContact);
		} else if (filter.equals("haveContact")) {
			url.append("&");
			url.append(filterString);
		}
		if (havePhone!=null && !filter.equals("havePhone")) {
			url.append("&havePhone=");
			url.append(havePhone);
		} else if (filter.equals("havePhone")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveMail!=null && !filter.equals("haveMail")) {
			url.append("&haveMail=");
			url.append(haveMail);
		} else if (filter.equals("haveMail")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveTrademark!=null && !filter.equals("haveTrademark")) {
			url.append("&haveTrademark=");
			url.append(haveTrademark);
		} else if (filter.equals("haveTrademark")) {
			url.append("&");
			url.append(filterString);
		}
		if (havePatent!=null && !filter.equals("havePatent")) {
			url.append("&havePatent=");
			url.append(havePatent);
		} else if (filter.equals("havePatent")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveFinance!=null && !filter.equals("haveFinance")) {
			url.append("&haveFinance=");
			url.append(haveFinance);
		} else if (filter.equals("haveFinance")) {
			url.append("&");
			url.append(filterString);
		}

		if (haveIpo!=null && !filter.equals("haveIpo")) {
			url.append("&haveIpo=");
			url.append(haveIpo);
		} else if (filter.equals("haveIpo")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveDishonest!=null && !filter.equals("haveDishonest")) {
			url.append("&haveDishonest=");
			url.append(haveDishonest);
		} else if (filter.equals("haveDishonest")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveWebSite!=null && !filter.equals("haveWebSite")) {
			url.append("&haveWebSite=");
			url.append(haveWebSite);
		} else if (filter.equals("haveWebSite")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveMpledge!=null && !filter.equals("haveMpledge")) {
			url.append("&haveMpledge=");
			url.append(haveMpledge);
		} else if (filter.equals("haveMpledge")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveTop500!=null && !filter.equals("haveTop500")) {
			url.append("&haveTop500=");
			url.append(haveTop500);
		} else if (filter.equals("haveTop500")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveCopyrightWorks!=null && !filter.equals("haveCopyrightWorks")) {
			url.append("&haveCopyrightWorks=");
			url.append(haveCopyrightWorks);
		} else if (filter.equals("haveCopyrightWorks")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveSoftwareCopyright!=null && !filter.equals("haveSoftwareCopyright")) {
			url.append("&haveSoftwareCopyright=");
			url.append(haveSoftwareCopyright);
		} else if (filter.equals("haveSoftwareCopyright")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveTender!=null && !filter.equals("haveTender")) {
			url.append("&haveTender=");
			url.append(haveTender);
		} else if (filter.equals("haveTender")) {
			url.append("&");
			url.append(filterString);
		}
		if (haveClearing!=null && !filter.equals("haveClearing")) {
			url.append("&haveClearing=");
			url.append(haveClearing);
		} else if (filter.equals("haveClearing")) {
			url.append("&");
			url.append(filterString);
		}
		if (sortType!=null && !filter.equals("sortType")) {
			url.append("&sortType=");
			url.append(sortType);
		} else if (filter.equals("sortType")) {
			url.append("&");
			url.append(filterString);
		}
		if (pageNo!=null && !filter.equals("pageNo")) {
			url.append("&pageNo=");
			url.append(pageNo);
		} else if (filter.equals("pageNo")) {
			url.append("&");
			url.append(filterString);
		}
		
		return url.toString();		
		
	}

	public String minusParameter(String filter) {
		Set<String> vFilter = null;
		if (filter.split(",").length > 0)
			vFilter = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(filter.split(","))));
		else
			vFilter = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("filter")));
			
		StringBuffer url = new StringBuffer();
		if (StringUtils.isNotEmpty(wd)) {
			url.append("wd=");
			url.append(wd);
		}

		if (StringUtils.isNotEmpty(searchType) && !vFilter.contains("searchType")) {
			url.append("&searchType=");
			url.append(searchType);
		}
		if (StringUtils.isNotEmpty(organizationType) && !vFilter.contains("organizationType")) {
			url.append("&organizationType=");
			url.append(organizationType);
		}

		if (StringUtils.isNotEmpty(province) && !vFilter.contains("province")) {
			url.append("&province=");
			url.append(province);
		}
		if (StringUtils.isNotEmpty(city) && !vFilter.contains("city")) {
			url.append("&city=");
			url.append(city);
		}
		if (StringUtils.isNotEmpty(district) && !vFilter.contains("district")) {
			url.append("&district=");
			url.append(district);
		}
		if (registerCapitalType!=null && !vFilter.contains("registerCapitalType")) {
			url.append("&registerCapitalType=");
			url.append(registerCapitalType);
		}
		if (estiblishYearType!=null && !vFilter.contains("estiblishYearType")) {
			url.append("&estiblishYearType=");
			url.append(estiblishYearType);
		}
		if (StringUtils.isNotEmpty(categoryFirst) && !vFilter.contains("categoryFirst")) {
			url.append("&categoryFirst=");
			url.append(categoryFirst);
		}
		if (StringUtils.isNotEmpty(companyStatus) && !vFilter.contains("companyStatus")) {
			url.append("&companyStatus=");
			url.append(companyStatus);
		}
		if (StringUtils.isNotEmpty(moneyType) && !vFilter.contains("moneyType")) {
			url.append("&moneyType=");
			url.append(moneyType);
		}
		
		if (StringUtils.isNotEmpty(companyType) && !vFilter.contains("companyType")) {
			url.append("&companyType=");
			url.append(companyType);
		}
		if (socialSecurityType!=null && !vFilter.contains("socialSecurityType")) {
			url.append("&socialSecurityType=");
			url.append(socialSecurityType);
		}
		if (haveContact!=null && !vFilter.contains("haveContact")) {
			url.append("&haveContact=");
			url.append(haveContact);
		}
		if (havePhone!=null && !vFilter.contains("havePhone")) {
			url.append("&havePhone=");
			url.append(havePhone);
		}
		if (haveMail!=null && !vFilter.contains("haveMail")) {
			url.append("&haveMail=");
			url.append(haveMail);
		}
		if (haveTrademark!=null && !vFilter.contains("haveTrademark")) {
			url.append("&haveTrademark=");
			url.append(haveTrademark);
		}
		if (havePatent!=null && !vFilter.contains("havePatent")) {
			url.append("&havePatent=");
			url.append(havePatent);
		}
		if (haveFinance!=null && !vFilter.contains("haveFinance")) {
			url.append("&haveFinance=");
			url.append(haveFinance);
		}

		if (haveIpo!=null && !vFilter.contains("haveIpo")) {
			url.append("&haveIpo=");
			url.append(haveIpo);
		}
		if (haveDishonest!=null && !vFilter.contains("haveDishonest")) {
			url.append("&haveDishonest=");
			url.append(haveDishonest);
		}
		if (haveWebSite!=null && !vFilter.contains("haveWebSite")) {
			url.append("&haveWebSite=");
			url.append(haveWebSite);
		}
		if (haveMpledge!=null && !vFilter.contains("haveMpledge")) {
			url.append("&haveMpledge=");
			url.append(haveMpledge);
		}
		if (haveTop500!=null && !vFilter.contains("haveTop500")) {
			url.append("&haveTop500=");
			url.append(haveTop500);
		}
		if (haveCopyrightWorks!=null && !vFilter.contains("haveCopyrightWorks")) {
			url.append("&haveCopyrightWorks=");
			url.append(haveCopyrightWorks);
		}
		if (haveSoftwareCopyright!=null && !vFilter.contains("haveSoftwareCopyright")) {
			url.append("&haveSoftwareCopyright=");
			url.append(haveSoftwareCopyright);
		}
		if (haveHighTech!=null && !vFilter.contains("haveHighTech")) {
			url.append("&haveHighTech=");
			url.append(haveHighTech);
		}
		if (haveTender!=null && !vFilter.contains("haveTender")) {
			url.append("&haveTender=");
			url.append(haveTender);
		}
		if (haveClearing!=null && !vFilter.contains("haveClearing")) {
			url.append("&haveClearing=");
			url.append(haveClearing);
		}
		if (sortType!=null && !vFilter.contains("sortType")) {
			url.append("&sortType=");
			url.append(sortType);
		}
		
		return url.toString();

	}	

}
