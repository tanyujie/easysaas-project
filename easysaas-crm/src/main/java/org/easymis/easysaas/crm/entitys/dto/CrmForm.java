package org.easymis.easysaas.crm.entitys.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data; 
 
  
  
@Data
 public class CrmForm implements Serializable{  
      //@GenField(labelname="",column="form_id",id=true,length=40,isnull=false) 
      private String formId; 
      //@GenField(labelname="",column="form_name",length=64,isnull=true) 
      private String formName; 
      //@GenField(labelname="clue/customer/order",column="form_type",length=12,isnull=true) 
      private String formType; 
      //@GenField(labelname="",column="create_user_id",length=64,isnull=true) 
      private String createUserId; 
      //@GenField(labelname="",column="create_time",isnull=true) 
      private Date createTime; 
      //@GenField(labelname="",column="update_user_id",length=64,isnull=true) 
      private String updateUserId; 
      //@GenField(labelname="",column="update_time",isnull=true) 
      private Date updateTime; 
      //@GenField(labelname="公司id",column="org_id",length=64,isnull=true) 
      private String orgId; 
     
}