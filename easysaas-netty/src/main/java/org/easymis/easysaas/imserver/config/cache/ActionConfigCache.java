package org.easymis.easysaas.imserver.config.cache;

import cn.jesong.webcall.cuour.entity.ActionConfig;

public interface ActionConfigCache {

	public ActionConfig getActionConfig(int companyId);

	public void remove(int companyId);

	public void init(ActionConfig ac);
	
	public void initNullConfig(int companyId);
	
}
