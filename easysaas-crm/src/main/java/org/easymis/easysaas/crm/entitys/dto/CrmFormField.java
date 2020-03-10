package org.easymis.easysaas.crm.entitys.dto;
import java.io.Serializable;

import lombok.Data; 
 
  
  
@Data
 public class CrmFormField implements Serializable{  
      //@GenField(labelname="",column="form_field_id",id=true,length=40,isnull=false) 
      private String formFieldId; 
      //@GenField(labelname="clue/customer/order/appoint",column="table_code",length=16,isnull=false) 
      private String tableCode; 
      //@GenField(labelname="字段id",column="field_id",length=40,isnull=false) 
      private String fieldId; 
      //@GenField(labelname="表单id",column="form_id",length=40,isnull=true) 
      private String formId; 
      //@GenField(labelname="分组id",column="group_id",length=40,isnull=false) 
      private String groupId; 
      //@GenField(labelname="是否必填",column="required",isnull=false) 
      private Boolean required; 
      //@GenField(labelname="排序",column="sort",isnull=true) 
      private Integer sort; 
      //@GenField(labelname="公司id",column="org_id",length=64,isnull=true) 
      private String orgId; 
     
}