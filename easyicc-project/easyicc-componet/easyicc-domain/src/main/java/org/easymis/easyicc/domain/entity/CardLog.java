package org.easymis.easyicc.domain.entity;

import java.util.Date;

import lombok.Data;

@Data
public class CardLog {
	public final static int ALLOCATION_TYPE_SYSTEM = 1;

	public final static int ALLOCATION_TYPE_USER = 2;

	public final static int ALLOCATION_TYPE_BACK = 3;

	public final static int ALLOCATION_TYPE_FINISHED = 4;

	public final static int ALLOCATION_TYPE_EXPIRED = 5;

	public final static int ALLOCATION_TYPE_SALE = 6;

	public final static int ALLOCATION_TYPE_SALE_FINIHSED = 7;

	private Integer id;

	/**
	 * 所属公司ID
	 */

	private String companyId;

	/**
	 * 名片ID
	 */

	private String cardId;

	/**
	 * 用户ID
	 */

	private String userId;

	/**
	 * 分配类型
	 */

	private int allocationType;

	/**
	 * 分配时间
	 */

	private Date allocationTime = new Date();

	/**
	 * 操作用户ID
	 */
	private String operatorUserId;
}
