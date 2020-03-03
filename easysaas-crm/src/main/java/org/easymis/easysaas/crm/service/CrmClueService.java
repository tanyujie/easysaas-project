package org.easymis.easysaas.crm.service;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmClue;

import com.jfinal.plugin.activerecord.Record;
import com.kakarote.crm9.erp.crm.common.CrmEnum;

public interface CrmClueService {
	/**
	 * 根据线索id查询
	 */
	public CrmClue findById(String leadsId);

	/**
	 * 根据线索名称查询
	 */
	public CrmClue queryByName(String name);
	/**
    * 查询编辑字段
    */
   public List<Record> queryField(Integer leadsId) {
       Record leads = queryById(leadsId);
       return adminFieldService.queryUpdateField(CrmEnum.CRM_LEADS.getType(),leads);
   }

	/**
	 * 
	 * 根据id 删除线索
	 */
	public RestResult deleteByIds(String leadsIds);
	/**
	 * 
     * 变更负责人
     */
    public RestResult updateOwnerUserId(String leadsIds, String ownerUserId);
    /**
     * 
     * 线索转客户
     */
    public RestResult translate(String leadsIds);
}
