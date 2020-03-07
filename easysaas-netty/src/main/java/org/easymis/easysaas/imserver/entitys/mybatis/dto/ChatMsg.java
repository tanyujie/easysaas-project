package org.easymis.easysaas.imserver.entitys.mybatis.dto;

import java.util.Date;

import lombok.Data;
@Data
public class ChatMsg {
    //@GenField(labelname="",column="id",id=true,length=40,isnull=false) 
    private String id; 
    //@GenField(labelname="",column="org_id",length=40,isnull=false) 
    private String orgId; 
    //@GenField(labelname="",column="send_member_id",length=40,isnull=false) 
    private String sendMemberId; 
    //@GenField(labelname="",column="accept_member_id",length=40,isnull=false) 
    private String acceptMemberId; 
    //@GenField(labelname="",column="msg",length=255,isnull=false) 
    private String msg; 
    //@GenField(labelname="",column="sign_flag",isnull=false) 
    private Integer signFlag; 
    //@GenField(labelname="",column="create_time",isnull=false) 
    private Date createTime; 
}
