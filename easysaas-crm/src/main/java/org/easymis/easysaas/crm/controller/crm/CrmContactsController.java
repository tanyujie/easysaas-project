package org.easymis.easysaas.crm.controller.crm;

import java.util.List;

import org.apache.poi.hssf.record.Record;
import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.crm.entitys.dto.CrmContacts;
import org.easymis.easysaas.crm.entitys.dto.CrmFollowRecord;
import org.easymis.easysaas.crm.service.AdminFieldService;
import org.easymis.easysaas.crm.service.CrmContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "联系人")
@Controller
@Validated
@Slf4j
public class CrmContactsController {
	@Autowired
	private CrmContactsService crmContactsService;
	@Autowired
	private AdminFieldService adminFieldService;

	// 查看列表页
    //@Permissions({"crm:contacts:index"})
    public void queryPageList(BasePageRequest basePageRequest) {
 /*       JSONObject jsonObject = basePageRequest.getJsonObject().fluentPut("type", 3);
        basePageRequest.setJsonObject(jsonObject);
        renderJson(adminSceneService.filterConditionAndGetPageList(basePageRequest));*/
    }
	// 分页条件查询联系人
    public void queryList(BasePageRequest<CrmContacts> basePageRequest) {
        //renderJson(R.ok().put("data", crmContactsService.queryList(basePageRequest)));
    }
	// 根据id查询联系人
    public void queryById(String contactsId) {
        //renderJson(R.ok().put("data", crmContactsService.queryById(contactsId)));
    }
	// 根据联系人名称查询
    public void queryByName(String name) {
        //renderJson(R.ok().put("data", crmContactsService.queryByName(name)));
    }
	// 根据联系人id查询商机
    public void queryBusiness(BasePageRequest<CrmContacts> basePageRequest) {
/*        boolean auth = AuthUtil.isCrmAuth(CrmEnum.CRM_CONTACTS, basePageRequest.getData().getContactsId());
        if (auth) {
            renderJson(R.noAuth());
            return;
        }
        renderJson(crmContactsService.queryBusiness(basePageRequest));*/
    }
	// 联系人关联商机
    public void relateBusiness(String contactsId, String businessIds) {
        //renderJson(crmContactsService.relateBusiness(contactsId, businessIds));
    }
	// 联系人解除关联商机
    public void unRelateBusiness(String contactsId, String businessIds) {
        //renderJson(crmContactsService.unrelateBusiness(contactsId, businessIds));
    }
	// 新建或更新联系人
	public void add() {
		
	}
    //@Permissions({"crm:contacts:save", "crm:contacts:update"})
    public void update() {
        //JSONObject jsonObject = JSON.parseObject(getRawData());
       // renderJson(crmContactsService.addOrUpdate(jsonObject));
    }
	// 根据id删除联系人
    //@Permissions("crm:contacts:delete")
    public void deleteByIds(String contactsIds) {
       // renderJson(crmContactsService.deleteByIds(contactsIds));
    }
	// 联系人转移
    //@Permissions("crm:contacts:transfer")
    //@NotNullValidate(value = "contactsIds", message = "联系人id不能为空")
    //@NotNullValidate(value = "newOwnerUserId", message = "新负责人不能为空")
    public void transfer(CrmContacts crmContacts) {
        //renderJson(crmContactsService.transfer(crmContacts));
    }
	// 添加跟进记录
	// @NotNullValidate(value = "typesId", message = "联系人id不能为空")
	// @NotNullValidate(value = "content", message = "内容不能为空")
	// @NotNullValidate(value = "category", message = "跟进类型不能为空")
	public void addRecord(CrmFollowRecord adminRecord) {
	}

	// 查看跟进记录
	public void getRecord(BasePageRequest<CrmContacts> basePageRequest) {
	}

	// 批量导出联系人
	// @Permissions("crm:contacts:excelexport")
	public void batchExportExcel(BasePageRequest basePageRequest) {
	}

	// 导出全部联系人
	// @Permissions("crm:contacts:excelexport")
	public void allExportExcel(BasePageRequest basePageRequest) {
	}

	private void export(List<Record> recordList) {
	}

	// 获取联系人导入模板
	public void downloadExcel() {
	}

	// 联系人导入
	public void uploadExcel() {
	}
}
