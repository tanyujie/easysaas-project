package org.easymis.easysaas.crm.entitys.mybatis.dto;
import java.io.Serializable;

import lombok.Data; 
 
  
  
@Data 
 public class CrmFormGroup implements Serializable{  
      //@GenField(labelname="属性组id",column="group_id",id=true,length=40,isnull=false) 
      private String groupId; 
      //@GenField(labelname="属性组名称，例如：基本信息组",column="group_name",length=64,isnull=false) 
      private String groupName; 
      //@GenField(labelname="表单id",column="form_id",length=40,isnull=true) 
      private String formId; 
      //@GenField(labelname="排序号",column="sort",isnull=true) 
      private Integer sort; 
}