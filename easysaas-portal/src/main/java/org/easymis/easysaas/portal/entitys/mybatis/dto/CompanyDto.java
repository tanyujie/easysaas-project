package org.easymis.easysaas.portal.entitys.mybatis.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.regex.Pattern;

import io.searchbox.annotations.JestId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CompanyDto implements Serializable {

    private static final Pattern pattern = Pattern.compile("^(\\d{8})$");

    private static final String ZERO = "0";


    @ApiModelProperty(value = "公司id")
    @JestId
    private String id;
    @ApiModelProperty(value = "公司简称")
    private String alias;
    @ApiModelProperty(value = "公司名称")
    private String name;
    @ApiModelProperty(value = "公司法人")
    private String legalPersonName;
    @ApiModelProperty(value = "电话号码")
    private String telNumber;
    @ApiModelProperty(value = "成立时间")
    private String estiblishTime;
    @ApiModelProperty(value = "经纬度")
    private LinkedHashMap location;
    @ApiModelProperty(value = "公司地址")
    private String address;
    @ApiModelProperty(value = "公司行业分类码")
    private String categoryCode;
    @ApiModelProperty(value = "门类")
    private String categoryFirst;
    @ApiModelProperty(value = "大类")
    private String categorySecond;
    @ApiModelProperty(value = "中类-app使用这个字段")
    private String categoryThird;
    @ApiModelProperty(value = "距离,有一位小数，以km为单位")
    private String sort;
    @ApiModelProperty(value = "省")
    private String province;
    @ApiModelProperty(value = "市")
    private String city;
    @ApiModelProperty(value = "区")
    private String district;
    @ApiModelProperty(value = "我要卖数量")
    private Integer saleCount = 0;
    @ApiModelProperty(value = "我要买数量")
    private Integer buyCount = 0;
    @ApiModelProperty(value = "招聘数量")
    private Integer jobCount = 0;
    @ApiModelProperty(value = "电话类型：0未指定1手机2固定电话")
    private Integer telType;
    @ApiModelProperty(value = "经营状态文本值")
    private String companyStatus;
    @ApiModelProperty(value = "公司名称(高亮)")
    private String nameHighlight;
    @ApiModelProperty(value = "法人名称(高亮)")
    private String legalPersonNameHighlight;
    @ApiModelProperty(value = "注册资本，单位万元")
    private Long registeredCapital;
    @ApiModelProperty(value = "资本类型")
    private String registeredCapitalType;
    @ApiModelProperty(value = "logo图片链接")
    private String companyLogo;
    @ApiModelProperty(value = "邮件")
    private String email;
    @ApiModelProperty(value = "网址")
    private String website;
    @ApiModelProperty(value = "小区")
    private String area;
    @ApiModelProperty(value = "园区")
    private String industrial_park;
    @ApiModelProperty(value = "商圈")
    private String business_area;

    @ApiModelProperty(value = "注册编号")  //实际是注册号
    private String reg_number;

    @ApiModelProperty(value = "统一社会信用代码")
    private String  creditCode;

    public String getEstiblishFormatDate() {
        if (Objects.nonNull(this.estiblishTime) && pattern.matcher(this.estiblishTime).matches()) {
            return this.estiblishTime.substring(0, 4) + "-" + this.estiblishTime.substring(4, 6) + "-" + this.estiblishTime.substring(6, 8);

        } else {
            //如果成立时间不是 yyyyMMdd格式返回"".
            return null;
        }
    }


    public Long getRegisteredCapitalW() {
        if (Objects.nonNull(this.registeredCapital)) {
            return this.registeredCapital / 1000000;
        } else {
            return null;
        }

    }

    public String  getestiblishTime(){
        if(Objects.equals(this.estiblishTime,ZERO)){
            return "企业选择不公示";
        }else{
            return this.estiblishTime;
        }
    }
    

}
