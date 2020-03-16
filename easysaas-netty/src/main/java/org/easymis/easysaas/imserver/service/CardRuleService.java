package org.easymis.easysaas.imserver.service;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardRule;

public interface CardRuleService  {
	CardRule findByOrgId(String orgId);
	void saveOrUpdate(CardRule bean);
	void save(CardRule bean);
	void update(CardRule bean);
}
