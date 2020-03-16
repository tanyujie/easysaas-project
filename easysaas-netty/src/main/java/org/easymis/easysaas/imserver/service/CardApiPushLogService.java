package org.easymis.easysaas.imserver.service;

import java.util.List;
import java.util.Map;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.ApiPushLog;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.Card;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface CardApiPushLogService {
	Card getCard(String cardId);
	PageInfo<ApiPushLog> pageApiPushVisitorInfo(Page page ,Map<String, Object> params);
	List<ApiPushLog> downApiPushVisitorInfo(Page page ,Map<String, Object> params);
}
