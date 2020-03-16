package org.easymis.easysaas.imserver.config.cache;

public interface CacheFactory {
	public void checkInit(String companyId, CacheDataLoader loader, String time);
	
	public void remove(String companyId);
	
	public LockCache getLockCache();
	
	public CardRuleCache getCardRuleCache();

	public SubjectUserCache getSubjectUserCache();
	
	public ScheduingCache getScheduingCache();
	
	public ActionConfigCache getActionConfigCache();
	
	void checkInit(String companyId, CacheDataLoader loader, String time,
                   boolean isUserReset);
}
