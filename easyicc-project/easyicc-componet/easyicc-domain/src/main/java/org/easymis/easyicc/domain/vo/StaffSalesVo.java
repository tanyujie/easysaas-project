package org.easymis.easyicc.domain.vo;

import java.util.ArrayList;
import java.util.List;

import org.easymis.easyicc.domain.entity.Card;
import org.easymis.easyicc.domain.entity.HrmStaffInfo;

public class StaffSalesVo extends HrmStaffInfo{
	private String schoolName;
	private String subjectName;
	
	private String businessGroupName;
	
	private String salesTypeName;
	
	private List<Card> cards = new ArrayList<Card>();
	
	private boolean weixinPushStatus = false;
	private String weiXinOpenId = null;

	/**
	 * 有效量
	 */
	private int validCount;
	
	/**
	 * 退回量
	 */
	private int backCount;
	
	/**
	 * 已分配量
	 */
	private int allocationCount;
	
	/**
	 * 当天已分配量
	 */
	private int actualAllocationCount;
	
	/**
	 * 当天有效量
	 */
	private int actualValidCount;
	
	/**
	 * 已处理量
	 */
	private int finishedCount;
	
	/**
	 * 超期未处理量
	 */
	private int expiredCount;
	
	/**
	 * 分配权重
	 */
	private int allocationWeight;
	
	/**
	 * 退回率
	 */
	private double backRatio;
	
	/**
	 * 合理比率
	 */
	private double fairRatio;
	
	/**
	 * 实际比率
	 */
	private double actualRatio;
	
	/**
	 * 最大分配量
	 */
	private int maxCardSize;
	
	/**
	 * 高意向名片分配量
	 */
	private int saleAllocationCount;
	
	/**
	 * 高意向名片处理量
	 */
	private int saleFinishedCount;
	
	
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getBusinessGroupName() {
		return businessGroupName;
	}

	public void setBusinessGroupName(String businessGroupName) {
		this.businessGroupName = businessGroupName;
	}

	public String getSalesTypeName() {
		return salesTypeName;
	}

	public void setSalesTypeName(String salesTypeName) {
		this.salesTypeName = salesTypeName;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public boolean isWeixinPushStatus() {
		return weixinPushStatus;
	}

	public void setWeixinPushStatus(boolean weixinPushStatus) {
		this.weixinPushStatus = weixinPushStatus;
	}

	public String getWeiXinOpenId() {
		return weiXinOpenId;
	}

	public void setWeiXinOpenId(String weiXinOpenId) {
		this.weiXinOpenId = weiXinOpenId;
	}

	public int getValidCount() {
		return validCount;
	}

	public void setValidCount(int validCount) {
		this.validCount = validCount;
	}

	public int getBackCount() {
		return backCount;
	}

	public void setBackCount(int backCount) {
		this.backCount = backCount;
	}

	public int getAllocationCount() {
		return allocationCount;
	}

	public void setAllocationCount(int allocationCount) {
		this.allocationCount = allocationCount;
	}

	public int getActualAllocationCount() {
		return actualAllocationCount;
	}

	public void setActualAllocationCount(int actualAllocationCount) {
		this.actualAllocationCount = actualAllocationCount;
	}

	public int getActualValidCount() {
		return actualValidCount;
	}

	public void setActualValidCount(int actualValidCount) {
		this.actualValidCount = actualValidCount;
	}

	public int getFinishedCount() {
		return finishedCount;
	}

	public void setFinishedCount(int finishedCount) {
		this.finishedCount = finishedCount;
	}

	public int getExpiredCount() {
		return expiredCount;
	}

	public void setExpiredCount(int expiredCount) {
		this.expiredCount = expiredCount;
	}

	public int getAllocationWeight() {
		return allocationWeight;
	}

	public void setAllocationWeight(int allocationWeight) {
		this.allocationWeight = allocationWeight;
	}

	public double getBackRatio() {
		return backRatio;
	}

	public void setBackRatio(double backRatio) {
		this.backRatio = backRatio;
	}

	public double getFairRatio() {
		return fairRatio;
	}

	public void setFairRatio(double fairRatio) {
		this.fairRatio = fairRatio;
	}

	public double getActualRatio() {
		return actualRatio;
	}

	public void setActualRatio(double actualRatio) {
		this.actualRatio = actualRatio;
	}

	public int getMaxCardSize() {
		return maxCardSize;
	}

	public void setMaxCardSize(int maxCardSize) {
		this.maxCardSize = maxCardSize;
	}

	public int getSaleAllocationCount() {
		return saleAllocationCount;
	}

	public void setSaleAllocationCount(int saleAllocationCount) {
		this.saleAllocationCount = saleAllocationCount;
	}

	public int getSaleFinishedCount() {
		return saleFinishedCount;
	}

	public void setSaleFinishedCount(int saleFinishedCount) {
		this.saleFinishedCount = saleFinishedCount;
	}
	
	
	
}
