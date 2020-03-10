package org.easymis.easysaas.crm.entitys.dto;
import java.io.Serializable;

import lombok.Data; 
 
  
  
@Data
 public class CrmPromotionChannel implements Serializable{  
      //@GenField(labelname="推广渠道ID",column="channel_id",length=64,isnull=true) 
      private String channelId; 
      //@GenField(labelname="推广渠道名称",column="channel_name",length=64,isnull=true) 
      private String channelName; 
      //@GenField(labelname="",column="api_config",length=128,isnull=true) 
      private String apiConfig; 
 
}