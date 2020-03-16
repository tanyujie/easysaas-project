package org.easymis.easysaas.imserver.config.cache;

import java.util.Date;
import java.util.List;

import org.easymis.easysaas.imserver.config.cache.entity.SchedulingTime;

public interface ScheduingCache {

	public void init(String companyId, List<SchedulingTime> schedulingTimes);
	
	public void remove(String companyId);
	
	public boolean isInWorkTime(String companyId, String userId, Date time);
	
}
