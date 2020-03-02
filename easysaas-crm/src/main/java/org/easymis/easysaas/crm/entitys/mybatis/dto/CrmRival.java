package org.easymis.easysaas.crm.entitys.mybatis.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CrmRival implements Serializable {
	// @GenField(labelname="",column="rival_id",id=true,length=40,isnull=false)
	private String rivalId;
	// @GenField(labelname="创建人",column="creator_id",length=40,isnull=false)
	private String creatorId;
	// @GenField(labelname="创建时间",column="create_time",isnull=false)
	private Date createTime;
	// @GenField(labelname="",column="org_id",length=40,isnull=false)
	private String orgId;
	// @GenField(labelname="竞争对手名称",column="rival_name",length=100,isnull=false)
	private String rivalName;
	// @GenField(labelname="",column="owner_id",length=255,isnull=false)
	private String ownerId;
	// @GenField(labelname="规模",column="scale_id",length=40,isnull=true)
	private String scaleId;
	// @GenField(labelname="",column="scale_name",length=50,isnull=true)
	private String scaleName;
	// @GenField(labelname="地址",column="contact_address",length=100,isnull=true)
	private String contactAddress;
	// @GenField(labelname="联系电话",column="contact_telephone",length=100,isnull=true)
	private String contactTelephone;
	// @GenField(labelname="竞争力",column="competition_id",length=40,isnull=true)
	private String competitionId;
	// @GenField(labelname="竞争力",column="competition_name",length=50,isnull=true)
	private String competitionName;
	// @GenField(labelname="优势",column="goodness",length=255,isnull=true)
	private String goodness;
	// @GenField(labelname="策略",column="strategy",length=255,isnull=true)
	private String strategy;
	// @GenField(labelname="劣势",column="weakness",length=255,isnull=true)
	private String weakness;
	// @GenField(labelname="网站",column="website",length=255,isnull=true)
	private String website;
	// @GenField(labelname="更新时间",column="update_time",isnull=true)
	private Date updateTime;
	// @GenField(labelname="",column="update_id",length=40,isnull=true)
	private String updateId;
	// @GenField(labelname="商机状态1正常2删除|作废",column="delete_status",isnull=false)
	private Integer deleteStatus;
	// @GenField(labelname="",column="delete_id",length=40,isnull=true)
	private String deleteId;
	// @GenField(labelname="",column="delete_time",isnull=true)
	private Date deleteTime;
	// @GenField(labelname="备注",column="depict",length=255,isnull=true)
	private String depict;

}