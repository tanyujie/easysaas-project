package org.easymis.easysaas.crm.entitys.mybatis.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CrmCustomerFocus implements Serializable {
	//@GenField(labelname = "关注时间", column = "create_time", isnull = false)
	private Date createTime;
	//@GenField(labelname = "", column = "customer_id", length = 40, isnull = false)
	private String customerId;
	//@GenField(labelname = "", column = "depict", length = 255, isnull = true)
	private String depict;
	//@GenField(labelname = "", column = "focus_id", id = true, length = 40, isnull = false)
	private String focusId;
	//@GenField(labelname = "", column = "org_id", length = 40, isnull = false)
	private String orgId;
	//@GenField(labelname = "", column = "staff_id", length = 40, isnull = false)
	private String staffId;

}