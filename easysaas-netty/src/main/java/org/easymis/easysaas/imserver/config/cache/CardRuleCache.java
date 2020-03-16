package org.easymis.easysaas.imserver.config.cache;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardRule;

public interface CardRuleCache{
	
	public CardRule getCardRule(String companyId);
	
	public void remove(int companyId);
	
	public void init(CardRule cardRule);
}
