package org.easymis.easysaas.crm.controller.crm;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.poi.hssf.record.Record;
import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.common.CrmEnum;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmBusiness;
import org.easymis.easysaas.crm.service.CrmBusinessService;
import org.easymis.easysaas.crm.service.CrmSceneService;
import org.easymis.easysaas.crm.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "商机管理")
@Controller
@RequestMapping("/business")
@Validated
@Slf4j
public class CrmBusinessController {
	@Autowired
    private CrmBusinessService crmBusinessService;

	@Autowired
    private CrmSceneService adminSceneService;

    /**
     
     * 查看列表页
     */
    @RequestMapping(value = {"/index.json"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void queryPageList(BasePageRequest basePageRequest){
        //JSONObject jsonObject = basePageRequest.getJsonObject().fluentPut("type",5);
        //basePageRequest.setJsonObject(jsonObject);
        //renderJson(adminSceneService.filterConditionAndGetPageList(basePageRequest));
    }
    //新增商机
    @RequestMapping(value = {"/save"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void add(CrmBusiness bean){
    	crmBusinessService.save(bean);
    }
    //更新商机
    @RequestMapping(value = {"/update"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void update(CrmBusiness bean){
    	crmBusinessService.update(bean);
    }


    /**
     
     * 根据商机id查询
     */
    @RequestMapping(value = {"/read/{businessId}"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public RestResult queryById(@NotNull(message = "商机id不能为空") @PathVariable("businessId") String businessId){
    	return RestResult.buildSuccess(crmBusinessService.findById(businessId));
    }

    /**
     
     * 根据商机名称查询
     */
    @RequestMapping(value = {"/read/name/{name}"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public RestResult queryByName(@NotNull(message = "名称不能为空")  @PathVariable("name") String name){
    	return RestResult.buildSuccess(crmBusinessService.findByName(name));
    }

    /**
     
     * 根据商机id查询产品
     */
	public RestResult queryProduct(BasePageRequest<CrmBusiness> basePageRequest) {
		boolean auth = AuthUtil.isCrmAuth(CrmEnum.CRM_BUSINESS, basePageRequest.getData().getBusinessId());
		if (auth) {
			RestResult.buildOAuthFail();
		}
		return crmBusinessService.queryProduct(basePageRequest);
	}

    /**
     
     * 根据商机id查询合同
     */
    public RestResult queryContract(BasePageRequest<CrmBusiness> basePageRequest){
        boolean auth = AuthUtil.isCrmAuth(CrmEnum.CRM_BUSINESS, basePageRequest.getData().getBusinessId());
		if (auth) {
			RestResult.buildOAuthFail();
		}
		return crmBusinessService.queryContract(basePageRequest);
        
    }

    /**
     
     * 根据商机id查询联系人
     */
    public RestResult queryContacts(BasePageRequest<CrmBusiness> basePageRequest){
    	return RestResult.buildSuccess(crmBusinessService.queryContacts(basePageRequest));
    }

    /**
     
     * 商机关联联系人
     */
    public RestResult relateContacts(String businessId,String contactsIds){
    	return RestResult.buildSuccess(crmBusinessService.relateContacts(businessId,contactsIds));
    }

    /**
     
     * 商机解除关联联系人
     */
    public RestResult unrelateContacts(String businessId,String contactsIds){
    	return RestResult.buildSuccess(crmBusinessService.unRelateContacts(businessId,contactsIds));
    }

    /**
     
     * 根据id删除商机
     */
   // @Permissions("crm:business:delete")
   // @NotNullValidate(value = "businessIds",message = "商机id不能为空")
    public RestResult deleteByIds(String businessIds){
    	return RestResult.buildSuccess(crmBusinessService.deleteByIds(businessIds));
    }

    /**
     
     * 根据商机id变更负责人
     */
/*    @Permissions("crm:business:transfer")
    @NotNullValidate(value = "businessIds",message = "商机id不能为空")
    @NotNullValidate(value = "newOwnerUserId",message = "负责人id不能为空")
    @NotNullValidate(value = "transferType",message = "移除方式不能为空")*/
    public RestResult transfer(CrmBusiness crmBusiness){
       	return RestResult.buildSuccess(crmBusinessService.transfer(crmBusiness));
    }

    /**
     
     * 查询团队成员
     */
    //@NotNullValidate(value = "businessId",message = "商机id不能为空")
	public RestResult getMembers(String businessId) {
		boolean auth = AuthUtil.isCrmAuth(CrmEnum.CRM_BUSINESS, businessId);
		if (auth) {
			return RestResult.buildOAuthFail();
		}
		return RestResult.buildSuccess(crmBusinessService.getMembers(businessId));

	}

    /**
     
     * 添加团队成员
     */
/*    @Permissions("crm:business:teamsave")
    @NotNullValidate(value = "ids",message = "商机id不能为空")
    @NotNullValidate(value = "memberIds",message = "成员id不能为空")
    @NotNullValidate(value = "power",message = "读写权限不能为空")*/
    public RestResult addMembers(CrmBusiness crmBusiness){
    	return RestResult.buildSuccess(crmBusinessService.addMember(crmBusiness));
    }

    /**
     
     * 编辑团队成员
     */
/*    @Permissions("crm:business:teamsave")
    @NotNullValidate(value = "ids",message = "商机id不能为空")
    @NotNullValidate(value = "memberIds",message = "成员id不能为空")
    @NotNullValidate(value = "power",message = "读写权限不能为空")*/
    public RestResult updateMembers(CrmBusiness crmBusiness){
    	return RestResult.buildSuccess(crmBusinessService.addMember(crmBusiness));
    }

    /**
     
     * 删除团队成员
     */
/*    @Permissions("crm:business:teamsave")
    @NotNullValidate(value = "ids",message = "商机id不能为空")
    @NotNullValidate(value = "memberIds",message = "成员id不能为空")*/
    public RestResult deleteMembers(CrmBusiness crmBusiness){
    	return RestResult.buildSuccess(crmBusinessService.deleteMembers(crmBusiness));
    }

    /**
     * @author
     * 商机状态组展示
     */
    //@NotNullValidate(value = "businessId",message = "商机id不能为空")
	public RestResult queryBusinessStatus(String businessId) {
		boolean auth = AuthUtil.isCrmAuth(CrmEnum.CRM_BUSINESS, businessId);
		if (auth) {
			return RestResult.buildOAuthFail();
		}
		return RestResult.buildSuccess(crmBusinessService.queryBusinessStatus(businessId));
	}

    /**
     
     * 商机状态组推进
     */
    //@NotNullValidate(value = "businessId",message = "商机id不能为空")
    public RestResult boostBusinessStatus(CrmBusiness crmBusiness){
        boolean auth = AuthUtil.isCrmAuth(CrmEnum.CRM_BUSINESS, crmBusiness.getBusinessId());
        if(auth){return RestResult.buildOAuthFail();}
        return crmBusinessService.boostBusinessStatus(crmBusiness);
    }
    /**
     
     * 查询商机状态组及商机状态
     */
    public RestResult queryBusinessStatusOptions(){
    	return RestResult.buildSuccess(crmBusinessService.queryBusinessStatusOptions(null));
    }

    /**
     
     * 添加跟进记录
     */
/*    @NotNullValidate(value = "typesId",message = "商机id不能为空")
    @NotNullValidate(value = "content",message = "内容不能为空")
    @NotNullValidate(value = "category",message = "跟进类型不能为空")*/
/*    public RestResult addRecord(AdminRecord adminRecord){
        boolean auth = AuthUtil.isCrmAuth(CrmEnum.CRM_BUSINESS, adminRecord.getTypesId());
        if(auth){return RestResult.buildOAuthFail();}
        renderJson(crmBusinessService.addRecord(adminRecord));
    }*/

    /**
     
     * 查看跟进记录
     */
    public RestResult getRecord(BasePageRequest<CrmBusiness> basePageRequest){
        boolean auth = AuthUtil.isCrmAuth(CrmEnum.CRM_BUSINESS, basePageRequest.getData().getBusinessId());
        if(auth){return RestResult.buildOAuthFail();}
        return RestResult.buildSuccess(crmBusinessService.getRecord(basePageRequest));
    }


    /**
     
     * 批量导出商机
     */
/*    @Permissions("crm:business:excelexport")*/
    public void batchExportExcel(BasePageRequest basePageRequest){
        JSONObject jsonObject=basePageRequest.getJsonObject();
        String ids=jsonObject.getString("ids");
        JSONObject data =new JSONObject();
        data.fluentPut("businessExport",new JSONObject().fluentPut("name","business_id").fluentPut("condition","in").fluentPut("value", ids));
        jsonObject.fluentPut("data",data).fluentPut("search","").fluentPut("type",5);
        basePageRequest.setJsonObject(jsonObject);
        //JSONObject resultData = (JSONObject)adminSceneService.getCrmPageList(basePageRequest).get("data");
       // List<Record> recordList = resultData.getJSONArray("list").toJavaList(Record.class);
        //export(recordList);
       // renderNull();
    }

    /**
     
     * 导出全部商机
     */
  //  @Permissions("crm:business:excelexport")
	public RestResult allExportExcel(BasePageRequest basePageRequest) {
		return null;
	}
    private void export(List<Record> recordList){}
}
