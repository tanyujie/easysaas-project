package org.easymis.easysaas.imserver.service;

import java.util.List;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.VisitorColSelf;

public interface CardConfigService {
	public List<VisitorColSelf> getShowVisitorCols(String orgId) throws Exception;
}
