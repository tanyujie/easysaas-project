package org.easymis.easysaas.crm.entitys.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CrmVisit implements Serializable {
	// @GenField(labelname="",column="visit_id",id=true,length=40,isnull=false)
	private String visitId;
	// @GenField(labelname="创建人id",column="creator_id",length=40,isnull=false)
	private String creatorId;
	// @GenField(labelname="创建人时间",column="create_time",isnull=true)
	private Date createTime;
	// @GenField(labelname="",column="org_id",length=40,isnull=false)
	private String orgId;
	// @GenField(labelname="客户名称id",column="customer_id",length=40,isnull=true)
	private String customerId;
	// @GenField(labelname="主题",column="category_id",length=40,isnull=true)
	private String categoryId;
	// @GenField(labelname="拜访内容|备注|交流内容",column="content",length=2000,isnull=true)
	private String content;
	// @GenField(labelname="计划日期",column="visit_date",isnull=true)
	private Date visitDate;
	// @GenField(labelname="完成时间",column="finish_time",isnull=true)
	private Date finishTime;
	// @GenField(labelname=" 负责人id",column="owner_id",length=40,isnull=true)
	private String ownerId;
	// @GenField(labelname="协访人id",column="assistant_id",length=40,isnull=true)
	private String assistantId;
	// @GenField(labelname="点评内容",column="comment_content",length=2000,isnull=true)
	private String commentContent;
	// @GenField(labelname="点评人",column="comment_id",length=40,isnull=true)
	private String commentId;
	// @GenField(labelname="点评时间",column="comment_date",isnull=true)
	private Date commentDate;
	// @GenField(labelname="修改人id",column="update_id",length=40,isnull=true)
	private String updateId;
	// @GenField(labelname="修改时间",column="update_time",isnull=true)
	private Date updateTime;
	// @GenField(labelname="删除人",column="delete_id",length=40,isnull=true)
	private String deleteId;
	// @GenField(labelname="删除人",column="delete_time",isnull=true)
	private Date deleteTime;
	// @GenField(labelname="关联线索",column="leads_id",length=40,isnull=true)
	private String leadsId;
	// @GenField(labelname="关联商机",column="business_id",length=40,isnull=true)
	private String businessId;
	// @GenField(labelname="关联产品",column="product_id",length=40,isnull=true)
	private String productId;
	// @GenField(labelname="线索状态0删除|作废1正常",column="status",isnull=true)
	private Integer status;

}