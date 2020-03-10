package org.easymis.easysaas.crm.entitys.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CrmField implements Serializable {  
    //@GenField(labelname="",column="field_id",id=true,length=40,isnull=false) 
    private String fieldId; 
    //@GenField(labelname="公司id",column="org_id",length=64,isnull=true) 
    private String orgId; 
    //@GenField(labelname="clue/customer/order/common（内置属性使用，自定义为null）",column="table_code",length=64,isnull=true) 
    private String label; 
    //@GenField(labelname="字段编号",column="field_code",length=64,isnull=true) 
    private String fieldCode; 
    //@GenField(labelname="字段名称(自定义字段英文标识)",column="field_name",length=64,isnull=true) 
    private String fieldName; 
    //@GenField(labelname="字段名称",column="name",length=255,isnull=true) 
    private String name; 
    //@GenField(labelname="字段提示/输入提示",column="field_tip",length=64,isnull=true) 
    private String fieldTip; 
    //@GenField(labelname="类型",column="field_type",length=64,isnull=false) 
    private Integer fieldType; 
    //@GenField(labelname="是否内置字段",column="inner_default",isnull=false) 
    private Boolean innerDefault; 
    //@GenField(labelname="启用：on；停用：off",column="state",length=16,isnull=true) 
    private String state; 
    //@GenField(labelname="创建人",column="create_user_id",length=64,isnull=true) 
    private String createUserId; 
    //@GenField(labelname="创建时间",column="create_time",isnull=true) 
    private Date createTime; 
    //@GenField(labelname="修改人",column="update_user_id",length=64,isnull=true) 
    private String updateUserId; 
    //@GenField(labelname="修改时间",column="update_time",isnull=true) 
    private Date updateTime; 
    //@GenField(labelname="字段说明",column="remark",length=255,isnull=true) 
    private String remark; 
    //@GenField(labelname="排序",column="sorting",isnull=true) 
    private Integer sorting; 
    //@GenField(labelname="最大长度",column="max_length",isnull=true) 
    private Integer maxLength; 
    //@GenField(labelname="默认值",column="default_value",length=255,isnull=true) 
    private String defaultValue; 
    //@GenField(labelname="是否唯一 1 是 0 否",column="is_unique",isnull=true) 
    private Integer isUnique; 
    //@GenField(labelname="是否必填 1 是 0 否",column="is_null",isnull=true) 
    private Integer isNull; 
    //@GenField(labelname="是否可以删除修改 0 改删 1 改 2 删 3 无",column="operating",isnull=true) 
    private Integer operating; 
    
    //开始自定义
	public String formType;	
	public String options;
 
}