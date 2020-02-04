package org.easymis.easysaas.portal.service;

public interface BulkProcessService {
	public void writeMysqlDataToES(String tableName);
	public void writeDishonestIndex(String indexesName);
}
