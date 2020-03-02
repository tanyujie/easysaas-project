package org.easymis.easysaas.crm.entitys.mybatis.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CrmCustomerAllot implements Serializable {
	//@GenField(labelname = "", column = "allot_id", id = true, length = 40, isnull = false)
	private String allotId;
	//@GenField(labelname = "分配主式，auto/get/manual", column = "allot_type", length = 16, isnull = true)
	private String allotType;
	//@GenField(labelname = "分配人", column = "create_id", length = 64, isnull = true)
	private String createId;
	//@GenField(labelname = "分配时间", column = "create_time", isnull = true)
	private Date createTime;
	//@GenField(labelname = "客户id", column = "customer_id", length = 64, isnull = true)
	private String customerId;
	//@GenField(labelname = "删除标识", column = "delete_flag", isnull = false)
	private Boolean deleteFlag;
	//@GenField(labelname = "持有人", column = "hold_id", length = 64, isnull = true)
	private String holdId;
	//@GenField(labelname = "0待跟进  1跟进中", column = "status", isnull = false)
	private Boolean status;
	//@GenField(labelname = "更新人", column = "update_id", length = 64, isnull = true)
	private String updateId;
	//@GenField(labelname = "更新时间", column = "update_time", isnull = true)
	private Date updateTime;

}