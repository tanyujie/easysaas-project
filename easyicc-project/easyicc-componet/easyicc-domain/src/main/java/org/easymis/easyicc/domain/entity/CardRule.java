package org.easymis.easyicc.domain.entity;

import lombok.Data;

/**
 * 名片分配规则
 */
@Data
public class CardRule {
	private String orgId;
	/**
	 * 是否启用分配
	 */
	private int useAllocation = 0;
	/**
	 * 分配时间间隔
	 */
	private Integer timeInterval = 60;

	/**
	 * 间隔时间内分配数量
	 */
	private int allocationSize = 2;

	/**
	 * 每天最多分配数量
	 */
	private int maxAllocationSize = 10;

	/**
	 * 超期回收开关
	 */
	private int expiredRecover;

	/**
	 * 超时回收时间
	 */
	private int expiredHour;

	/**
	 * 重置时间
	 */
	private String resetTime;

	/**
	 * 手机号码隐藏时间
	 */
	private int mobileHideTime;

	private String serverName;

	/**
	 * 分配延迟(分)
	 */

	private int allocationDelay = 0;

	/**
	 * 默认项目
	 */

	private int defaultSubjectId = 0;

	/**
	 * 默认校区
	 */

	private int defaultSchoolId = 0;

	/**
	 * 必须在线才能分配
	 */

	private int needOnLine = 1;

	/**
	 * 必须排班才能分配
	 */

	private int needScheeduling = 1;

	/**
	 * 分配模式 0按校区/项目 1 分配给创建者
	 */

	private int allocationModel = 0;

	/**
	 * 微信推送是否开启 0开启 1关闭
	 */

	private int isWechatOpen = 0;

	/**
	 * 在线分配模式 0 在线分配(只有在线的状态可以进行名片的分配) 1 在线分配(在线.忙碌.离开的状态可以进行名片的分配)
	 */

	private int isOnlineAllocation = 0;

	/**
	 * 是否开启上报头条功能（默认开启）
	 */
	private int needSumbitToutiao = 1;
}
