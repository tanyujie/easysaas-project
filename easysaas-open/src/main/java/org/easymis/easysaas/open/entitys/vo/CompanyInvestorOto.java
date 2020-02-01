package org.easymis.easysaas.open.entitys.vo;

import java.time.LocalDateTime;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
　 * <p>Title: CompanyInvestorOto</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月29日
 */
@Data
@JsonSerialize(nullsUsing= SeventeenTableJsonSerializer.class)
public class CompanyInvestorOto {
	private Long id;

	/**
	 * 公司id
	 */
	@ApiModelProperty("公司id")
	private Long companyId;

	/**
	 *
	 */
	@ApiModelProperty("股东类型，1代表自然人，2代表非自然人")
	private Integer investorType;

	/**
	 * 投资人id，根据投资人类型的不同分别对应human_id或者company_id
	 */
	@ApiModelProperty("投资人id")
	private Long investorId;

	/**
	 * 认缴金额
	 */
	@ApiModelProperty("认缴金额")
	private String capital;

	/**
	 * 实缴金额
	 */
	@ApiModelProperty("实缴金额")
	private String capitalActl;

	/**
	 * 投资金额
	 */
	@ApiModelProperty("投资金额")
	private Double amount;

	/**
	 * 证照/证件类型
	 */
	@ApiModelProperty("证照/证件类型")
	private String certName;

	/**
	 * 证照/证件号码
	 */
	@ApiModelProperty("证照/证件号码")
	private String certNo;

	private LocalDateTime createTime;

	/**
	 * 控股比例
	 */
	@ApiModelProperty("控股比例")
	private String ownershipStake;


	/**
	 * 股东姓名
	 */
	@ApiModelProperty("股东姓名")
	private String name;
	/**
	 * 股东职位
	 */
	@ApiModelProperty("股东职位")
	private String position;

	/**
	 * 投资金额字符
	 */
	@ApiModelProperty("投资金额字符")
	private String amountStr;
	
/*	@ApiModelProperty("认缴金额")
	private String capitalAmomon;
	@ApiModelProperty("认缴金额时间")
	private String capitalTime;
	@ApiModelProperty("认缴金额出资方式")
	private String capitalPaymet;
    @JSONField(serialize=false)
    
	@ApiModelProperty("实缴金额")
	private String capitalActlAmomon;

    public String getCapitalAmomon(){
		if(capital!=null) {
			JSONObject obj=JSON.parseArray(capital).getJSONObject(0);
			capitalTime=obj.getString("time");
			capitalPaymet=obj.getString("paymet");
			return obj.getString("amomon");
		}else
		return null;
	}*/

}
