package org.easymis.easysaas.imserver.config.cache;

import cn.jesong.webcall.cuour.cache.entity.Lock;

public interface LockCache {
	
	public void init(String companyId);

	public void remove(String companyId);
	
	public Lock getLock(String companyId);
	
}
