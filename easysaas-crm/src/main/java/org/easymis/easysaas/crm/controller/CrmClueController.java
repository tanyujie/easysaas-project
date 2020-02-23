package org.easymis.easysaas.crm.controller;

import java.util.List;

import org.apache.poi.hssf.record.Record;
import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmClue;
import org.easymis.easysaas.crm.service.CrmClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * 
　 * <p>Title: 线索信息</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年2月21日
 */
@Api(description = "线索管理")
@Controller
@Validated
@Slf4j
public class CrmClueController {
	@Autowired
    private CrmClueService crmClueService;
	//查看列表页
    ////@Permissions({"crm:leads:index"})
    public void queryPageList(BasePageRequest basePageRequest){/*
        JSONObject jsonObject = basePageRequest.getJsonObject().fluentPut("type",1);
        basePageRequest.setJsonObject(jsonObject);
        renderJson(adminSceneService.filterConditionAndGetPageList(basePageRequest));
    */}
    /**
     * 全局搜索查询线索
     */
    public void queryList(BasePageRequest<CrmClue> basePageRequest){
        //renderJson(R.ok().put("data",crmLeadsService.getLeadsPageList(basePageRequest)));
    }
    public void add() {
    	
    }
    public void update() {
    	
    }
    /**
     
     * 根据线索id查询
     */
    //@Permissions("crm:leads:read")
    //@NotNullValidate(value = "leadsId",message = "线索id不能为空")
    public RestResult queryById(String leadsId){
    	return RestResult.buildSuccess(crmClueService.findById(leadsId));
    }

    /**
     
     * 根据线索名称查询
     */
    public RestResult queryByName( String name){
    	return RestResult.buildSuccess(crmClueService.queryByName(name));
    }

    /**
     
     * 根据id 删除线索
     */
    //@Permissions("crm:leads:delete")
    //@NotNullValidate(value = "leadsIds",message = "线索id不能为空")
    public RestResult deleteByIds(String leadsIds){
    	return crmClueService.deleteByIds(leadsIds);
    }

    /**
     
     * 线索转移
     */
    //@Permissions("crm:leads:transfer")
    //@NotNullValidate(value = "leadsIds",message = "线索id不能为空")
    //@NotNullValidate(value = "newOwnerUserId",message = "新负责人id不能为空")
    public void changeOwnerUser(String leadsIds,String newOwnerUserId){
    	RestResult.buildSuccess(crmClueService.updateOwnerUserId(leadsIds,newOwnerUserId));
    }

    /**
     
     * 线索转客户
     */
    //@Permissions("crm:leads:transform")
    //@NotNullValidate(value = "leadsIds",message = "线索id不能为空")
    public RestResult transfer(String leadsIds){
        return crmClueService.translate(leadsIds);
    }

    /**
     
     * 添加跟进记录
     */
    //@NotNullValidate(value = "typesId",message = "线索id不能为空")
    //@NotNullValidate(value = "content",message = "内容不能为空")
    //@NotNullValidate(value = "category",message = "跟进类型不能为空")
/*    public void addRecord(AdminRecord adminRecord){
        boolean auth = AuthUtil.isCrmAuth(AuthUtil.getCrmTablePara(CrmEnum.CRM_LEADS), adminRecord.getTypesId());
        if(auth){
            renderJson(R.noAuth());
            return;
        }
        renderJson(crmClueService.addRecord(adminRecord));
    }*/

    /**
     
     * 查看跟进记录
     */
/*    public void getRecord(BasePageRequest<CrmLeads> basePageRequest){
        boolean auth = AuthUtil.isCrmAuth(AuthUtil.getCrmTablePara(CrmEnum.CRM_LEADS), basePageRequest.getData().getLeadsId());
        if(auth){renderJson(R.noAuth()); return; }
        renderJson(R.ok().put("data",crmLeadsService.getRecord(basePageRequest)));
    }*/

    /**
     
     * 批量导出线索
     */
    //@Permissions("crm:leads:excelexport")
/*    public void batchExportExcel(BasePageRequest basePageRequest){
        JSONObject jsonObject=basePageRequest.getJsonObject();
        String ids=jsonObject.getString("ids");
        JSONObject data =new JSONObject();
        data.fluentPut("leadsExport",new JSONObject().fluentPut("name","leads_id").fluentPut("condition","in").fluentPut("value", ids));
        jsonObject.fluentPut("data",data).fluentPut("search","").fluentPut("type",1);
        basePageRequest.setJsonObject(jsonObject);
        JSONObject resultData = (JSONObject)adminSceneService.getCrmPageList(basePageRequest).get("data");
        List<Record> recordList = resultData.getJSONArray("list").toJavaList(Record.class);
        export(recordList);
        renderNull();
    }*/

    /**
     
     * 导出全部线索
     */
    //@Permissions("crm:leads:excelexport")
    public void allExportExcel(BasePageRequest basePageRequest){}

    private void export(List<Record> recordList){}



    /**
     
     * 获取线索导入模板
     */
    public void downloadExcel(){}

    /**
     
     * 线索导入
     */
    //@Permissions("crm:leads:excelimport")
    public void uploadExcel(){}
}
