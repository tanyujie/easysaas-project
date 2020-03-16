package org.easymis.easysaas.imserver.service.impl;

import java.util.List;
import java.util.Map;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.ApiPushLog;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.Card;
import org.easymis.easysaas.imserver.service.CardApiPushLogService;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
@Service
public class CardApiPushLogServiceImpl implements CardApiPushLogService {

	@Override
	public Card getCard(String cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo<ApiPushLog> pageApiPushVisitorInfo(Page page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ApiPushLog> downApiPushVisitorInfo(Page page, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
