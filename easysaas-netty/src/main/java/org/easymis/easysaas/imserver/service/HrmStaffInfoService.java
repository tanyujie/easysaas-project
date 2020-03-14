package org.easymis.easysaas.imserver.service;

import org.easymis.easysaas.common.result.RestResult;

public interface HrmStaffInfoService {
	/**
	 * 
	 * <p>
	 * Title: 按部门获取所用员工信息
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * @param orgId @return
	 */
	public RestResult getListByDepartment(String orgId);
}
