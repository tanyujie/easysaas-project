package org.easymis.easysaas.crm.entitys.mybatis.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data; 
 
  
  
@Data 
 public class CrmMarketActivity implements Serializable{  
      //@GenField(labelname="",column="activity_id",id=true,length=40,isnull=false) 
      private String activityId; 
      //@GenField(labelname="创建人",column="creator_id",length=40,isnull=false) 
      private String creatorId; 
      //@GenField(labelname="",column="org_id",length=40,isnull=false) 
      private String orgId; 
      //@GenField(labelname="活动名称",column="activity_name",length=20,isnull=true) 
      private String activityName; 
      //@GenField(labelname="开始时间",column="begin_date",isnull=true) 
      private Date beginDate; 
      //@GenField(labelname="结束时间",column="end_sdate",isnull=true) 
      private Date endSdate; 
      //@GenField(labelname="活动类型",column="category_id",length=40,isnull=true) 
      private String categoryId; 
      //@GenField(labelname="地址|地点",column="address",length=255,isnull=true) 
      private String address; 
      //@GenField(labelname="预计成本",column="expected_cost",isnull=true) 
      private Float expectedCost; 
      //@GenField(labelname="实际成本",column="actual_cost",isnull=true) 
      private Float actualCost; 
      //@GenField(labelname="实际收入",column="actual_income",isnull=true) 
      private Float actualIncome; 
      //@GenField(labelname="预计收入",column="expected_income",isnull=true) 
      private Float expectedIncome; 
      //@GenField(labelname="计划",column="marketing_plan",isnull=true) 
      private Float marketingPlan; 
      //@GenField(labelname="执行描述",column="execution_description",length=255,isnull=true) 
      private String executionDescription; 
      //@GenField(labelname="总结",column="summary",length=255,isnull=true) 
      private String summary; 
      //@GenField(labelname="效果",column="effect",length=255,isnull=true) 
      private String effect; 
      //@GenField(labelname="描述",column="description",length=255,isnull=true) 
      private String description; 
      //@GenField(labelname="参与人",column="participant_ids",length=255,isnull=true) 
      private String participantIds; 
      //@GenField(labelname="拥有者|负责人id",column="owner_id",length=20,isnull=true) 
      private String ownerId; 
      //@GenField(labelname="创建时间",column="create_time",isnull=true) 
      private Date createTime; 
      //@GenField(labelname="修改者id",column="update_id",length=20,isnull=true) 
      private String updateId; 
      //@GenField(labelname="修改时间",column="update_time",isnull=true) 
      private Date updateTime; 
      //@GenField(labelname="删除者id",column="delete_id",length=20,isnull=true) 
      private String deleteId; 
      //@GenField(labelname="删除时间",column="delete_time",isnull=true) 
      private Date deleteTime; 
      //@GenField(labelname="相关线索",column="leads_id",length=20,isnull=true) 
      private String leadsId; 
      //@GenField(labelname="相关商机",column="business_id",length=20,isnull=true) 
      private String businessId; 
      //@GenField(labelname="相关产品",column="product_id",length=20,isnull=true) 
      private String productId; 
      //@GenField(labelname="相关客户",column="customer_id",length=20,isnull=true) 
      private String customerId; 
      //@GenField(labelname="线索状态0删除|作废1进行中2结束",column="status",isnull=true) 
      private Integer status; 
  
}