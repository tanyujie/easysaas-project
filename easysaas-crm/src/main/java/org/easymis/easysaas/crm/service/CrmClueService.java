package org.easymis.easysaas.crm.service;

import java.util.List;

import org.apache.poi.hssf.record.Record;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmClue;

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
   public List<Record> queryField(Integer leadsId);

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
