package org.easymis.easysaas.crm.service;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.CrmFieldType;

public interface CrmFieldTypeService {

	public boolean save(CrmFieldType bean);

	public boolean update(CrmFieldType bean);

	public CrmFieldType findById(String id);

	public RestResult deleteByIds(String ids);

}
