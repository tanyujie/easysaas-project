package org.easymis.easyicc.service;

import org.easymis.easyicc.domain.entity.CardRule;

public interface CardRuleService  {
	CardRule findByOrgId(String orgId);
	void saveOrUpdate(CardRule bean);
	void save(CardRule bean);
	void update(CardRule bean);
}
