package org.easymis.easysaas.imserver.service.impl;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardRule;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.CardRuleMapper;
import org.easymis.easysaas.imserver.service.CardRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CardRuleServiceImpl implements CardRuleService {
	@Autowired
	private CardRuleMapper mapper;
	@Override
	public CardRule findByOrgId(String orgId) {
		// TODO Auto-generated method stub
		return mapper.findByOrgId(orgId);
	}

	@Override
	public void saveOrUpdate(CardRule bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(CardRule bean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CardRule bean) {
		// TODO Auto-generated method stub

	}

}
