package org.easymis.easysaas.open.entitys.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.easymis.easysaas.common.jackson.SeventeenTableJsonSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@JsonSerialize(nullsUsing = SeventeenTableJsonSerializer.class)
public class CompanyInvestorVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 公司id
	 */
	private Long companyId;

	/**
	 * 股东类型，1代表自然人，2代表非自然人
	 */
	private Integer investorType;

	/**
	 * 投资人id，根据投资人类型的不同分别对应human_id或者company_id
	 */
	private Long investorId;

	/**
	 * 认缴金额
	 */
	private String capital;

	/**
	 * 实缴金额
	 */
	private String capitalActl;

	/**
	 * 投资金额
	 */
	private Double amount;

	/**
	 * 证照/证件类型
	 */

	private String certName;

	/**
	 * 证照/证件号码
	 */

	private String certNo;

	private LocalDateTime createTime;

	/**
	 * 控股比例
	 */
	private String ownershipStake;

}
