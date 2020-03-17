package org.easymis.easysaas.imserver.service;

import java.util.Map;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardLog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface CardLogService {
	void save(CardLog log);

	public PageInfo<Map<String, Object>> pageQuery2(String companyId, Page page, Map<String, Object> params);
}