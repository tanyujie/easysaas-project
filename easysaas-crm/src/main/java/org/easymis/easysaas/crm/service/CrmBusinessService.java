package org.easymis.easysaas.crm.service;

import java.util.List;

import org.apache.poi.hssf.record.Record;
import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.CrmBusiness;

public interface CrmBusinessService {
	public CrmBusiness findById(String id);

	public CrmBusiness findByName(String name);

	public void save(CrmBusiness bean);

	public void update(CrmBusiness bean);

	public RestResult queryProduct(BasePageRequest<CrmBusiness> basePageRequest);

	public RestResult queryContract(BasePageRequest<CrmBusiness> basePageRequest);

	public RestResult queryContacts(BasePageRequest<CrmBusiness> basePageRequest);

	/**
	 * 商机关联联系人
	 */
	public RestResult relateContacts(String businessId, String contactsIds);

	/**
	 * 商机解除关联联系人
	 */
	public RestResult unRelateContacts(String businessId, String contactsIds);

	/**
	 * 根据id删除商机
	 */
	public RestResult deleteByIds(String businessIds);

	/**
	 * 根据商机id变更负责人
	 */
	public RestResult transfer(CrmBusiness crmBusiness);
	/**
    * 查询团队成员
    */
   public List<Record> getMembers(String businessId);
   /**
     * 添加团队成员
     */
    public RestResult addMember(CrmBusiness crmBusiness);
    /**
     * 删除团队成员
     */
    public RestResult deleteMembers(CrmBusiness crmBusiness);
    /**
     * 商机状态组展示
     */
    public Record queryBusinessStatus(String businessId);
    /**
    * 商机状态组推进
    */
   public RestResult boostBusinessStatus(CrmBusiness crmBusiness);
   /**
   * 查询商机状态组及商机状态
   */
  public List<Record> queryBusinessStatusOptions(String type);
  /**
  * 查看跟进记录
  */
 public List<Record> getRecord(BasePageRequest<CrmBusiness> basePageRequest);
}
