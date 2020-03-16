package cn.jesong.webcall.cuour.cache;

import cn.jesong.webcall.cuour.cache.entity.Lock;

public interface LockCache {
	
	public void init(int companyId);

	public void remove(int companyId);
	
	public Lock getLock(int companyId);
	
}
