package org.easymis.easysaas.crm.service.impl;

import java.util.List;

import org.apache.poi.hssf.record.Record;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.CrmClue;
import org.easymis.easysaas.crm.service.CrmClueService;
import org.springframework.stereotype.Service;
@Service
public class CrmClueServiceImpl implements CrmClueService {

	@Override
	public CrmClue findById(String leadsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CrmClue queryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult deleteByIds(String leadsIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult updateOwnerUserId(String leadsIds, String ownerUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult translate(String leadsIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> queryField(Integer leadsId) {

/*	       Record leads = queryById(leadsId);
	       return adminFieldService.queryUpdateField(CrmEnum.CRM_LEADS.getType(),leads);*/
	   
		return null;
	}

}
