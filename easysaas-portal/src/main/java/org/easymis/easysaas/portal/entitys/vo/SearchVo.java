package org.easymis.easysaas.portal.entitys.vo;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class SearchVo {
    //公司id
    public String companyId;
	private String wd;
	//搜索范围
	private String searchType;
	//机构类型
	private String companyType;
	//省份地区
	private String province;
	//区县
	private String areaCode;
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

}
