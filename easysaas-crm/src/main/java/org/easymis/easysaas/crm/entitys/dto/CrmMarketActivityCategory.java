package org.easymis.easysaas.crm.entitys.dto;
import java.io.Serializable;

import lombok.Data; 
 
  
  
@Data 
 public class CrmMarketActivityCategory implements Serializable{  
      //@GenField(labelname="",column="category_id",id=true,length=20,isnull=false) 
      private String categoryId; 
      //@GenField(labelname="分类名",column="category_name",length=255,isnull=true) 
      private String categoryName; 
      //@GenField(labelname="",column="org_id",length=20,isnull=true) 
      private String orgId; 
      //@GenField(labelname="排序号",column="priority",isnull=true) 
      private Integer priority; 
      //@GenField(labelname="",column="level",isnull=true) 
      private Integer level; 
      //@GenField(labelname="",column="parent_id",length=255,isnull=true) 
      private String parentId; 
      //@GenField(labelname="是否叶子节点",column="is_leaf",isnull=true) 
      private Integer isLeaf; 
      //@GenField(labelname="备注",column="depict",length=255,isnull=true) 
      private String depict; 
   
}