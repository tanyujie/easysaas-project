package org.easymis.easysaas.imserver.service;

import java.util.List;
import java.util.Map;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.Card;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.VisitorColSelf;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface CardConfigService {
	public List<VisitorColSelf> getShowVisitorCols(String orgId) throws Exception;
	public PageInfo<Card> pageVisitorCard(Page pageConfig, Map<String, Object> map, int status) throws Exception;
}
