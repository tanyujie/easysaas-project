package cn.jesong.webcall.cuour.cache;

import java.util.Date;
import java.util.List;

import cn.jesong.webcall.cuour.cache.entity.SchedulingTime;

public interface ScheduingCache {

	public void init(int companyId, List<SchedulingTime> schedulingTimes);
	
	public void remove(int companyId);
	
	public boolean isInWorkTime(int companyId, String userId, Date time);
	
}
