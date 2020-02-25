package org.easymis.easysaas.crm.service.impl;

import java.util.List;

import org.apache.poi.hssf.record.Record;
import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmBusiness;
import org.easymis.easysaas.crm.service.CrmBusinessService;
import org.springframework.stereotype.Service;
@Service
public class CrmBusinessServiceImpl implements CrmBusinessService {
/*	@Autowired
	private CrmBusinessMapper mapper;*/
	@Override
	public CrmBusiness findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CrmBusiness findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CrmBusiness bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CrmBusiness bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public RestResult queryProduct(BasePageRequest<CrmBusiness> basePageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult queryContract(BasePageRequest<CrmBusiness> basePageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult queryContacts(BasePageRequest<CrmBusiness> basePageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult relateContacts(String businessId, String contactsIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult unRelateContacts(String businessId, String contactsIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult deleteByIds(String businessIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult transfer(CrmBusiness crmBusiness) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> getMembers(String businessId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult addMember(CrmBusiness crmBusiness) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult deleteMembers(CrmBusiness crmBusiness) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Record queryBusinessStatus(String businessId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult boostBusinessStatus(CrmBusiness crmBusiness) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> queryBusinessStatusOptions(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> getRecord(BasePageRequest<CrmBusiness> basePageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
