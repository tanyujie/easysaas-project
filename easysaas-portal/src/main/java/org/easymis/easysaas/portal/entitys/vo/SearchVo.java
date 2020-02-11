package org.easymis.easysaas.portal.entitys.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;

import org.apache.commons.lang.StringUtils;
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
	private String companyType;
	private String companyTypeDepict;
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
	
	//成立时间,成立时间范围
    private Integer estiblishTimeYearType;
	//行业分类
    private String cateFirst;
    private String cateSecond;
    private String cateThird;
//企业描述
	//企业状态:在业
    private String companyStatus;
	//资本类型,注册资本金额范围
    private Integer registerCapitalNumberType;
    //注册资本金额范围-开始
    @Min(value = 0, message = "注册资本金额范围不合法,请检查")
    private Long registerCapitalFrom;
    //注册资本金额范围-结束
    @Min(value = 1, message = "注册资本金额范围不合法,请检查")
    private Long registerCapitalTo;
    //资本币种：人民币，美元，其他
    private String registerCapitalType;
    //参保人数范围
    private Integer  insurancePersonNumberType;
    //参保人数范围-开始
    @Min(0)
    private Integer insurancePersonNumberFrom;
    //参保人数范围-结束
    @Range(min = 0, max = 100000000, message = "参保人数范围不合法，请检查")
    private Integer insurancePersonNumberTo;
    //联系方式1,有联系方式0无联系方式
    public Integer haveContact;
    //手机号码
    private Integer haveMobile;
    //是否有email
    @Range(min = 0, max = 1)
    public Integer haveEmail;
    //是否有网址
    @Range(min = 0, max = 1)
    public Integer haveWebSite;
    //是否有商标
    @Range(min = 0, max = 1)
    public Integer haveTrademark;
    //软件著作权
    @Range(min = 0, max = 1)
    public Integer haveSoftwareCopyright;
    //作品著作权
    @Range(min = 0, max = 1)
    public Integer haveCopyrightWorks;
    
    @Range(min = 1, max = 30, message = "每页最大数量为30")
    public Integer pageSize = 10;
    @Min(value = 1, message = "pageNo大于等于1")
    public Integer pageNo = 1;
	private boolean filterScope=false;

	public boolean isFilterScope() {
		if(StringUtil.isNotEmpty(searchType)||StringUtil.isNotEmpty(companyType)||StringUtil.isNotEmpty(province))
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
	public String getCompanyTypeDepict() {
		if(null!=companyType) {
			if(companyType.equals("normal_company"))
				return "企业";
			else if(companyType.equals("institution"))
				return "事业单位";
			else if(companyType.equals("npo_foundation"))
				return "基金会";
			else if(companyType.equals("npo"))
				return "社会组织";
			else if(companyType.equals("lawFirm"))
				return "律所";
			else if(companyType.equals("hk"))
				return "香港特别行政区企业";
			else if(companyType.equals("tw"))
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
/*	public String getDistrict() {
		if(StringUtil.isEmpty(province)) {
			return null;
		}else if(StringUtil.isEmpty(city)&&(province.equals("bj")||province.equals("tj")||province.equals("sh")||province.equals("cq"))) {
			return district;
		}				
		else
			return district;
	}*/
	public String getDistrictDepict() {
		if(StringUtil.isNotEmpty(district)) {
			return DistrictUtil.getDistrict(district).getDistrict();
		}			
		else
			return null;
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
		if(StringUtils.isNotEmpty(companyType)&&!filter.equals("companyType")) {
			url.append("&companyType=");
			url.append(companyType);
		}else if(filter.equals("companyType")) {
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
		if (StringUtils.isNotEmpty(companyType) && !vFilter.contains("companyType")) {
			url.append("&companyType=");
			url.append(companyType);
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
		return url.toString();

	}	

}
