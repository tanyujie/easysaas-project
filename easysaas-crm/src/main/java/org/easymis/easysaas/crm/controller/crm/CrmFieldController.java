package org.easymis.easysaas.crm.controller.crm;

import java.util.List;

import javax.validation.Valid;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.common.CrmEnum;
import org.easymis.easysaas.crm.controller.IdentityRepository;
import org.easymis.easysaas.crm.entitys.dto.CrmField;
import org.easymis.easysaas.crm.entitys.dto.CrmFieldSort;
import org.easymis.easysaas.crm.entitys.vo.ColumnHeadVo;
import org.easymis.easysaas.crm.service.CrmFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
/**
 * 
　 * <p>Title: 字段信息 </p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年2月21日
 */
@Api(description = "客户预约")
@Controller
@RequestMapping("/crmField")
@Validated
@Slf4j
public class CrmFieldController extends IdentityRepository{
	@Autowired
	private CrmFieldService service;
	
	@ApiOperation(value = "查询接口", response = CrmField.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "label", value = "页码", dataType = "string", required = true),
		@ApiImplicitParam(name = "categoryId", value = "每页显示记录", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/list" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult queryList(String label,
			String categoryId) {
		String orgId = getOrgId();
		return RestResult.buildSuccess(service.list(orgId,label, categoryId));
	}
	@ApiOperation(value = "查询接口", response = CrmField.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int", required = false),
		@ApiImplicitParam(name = "pageSize", value = "每页显示记录", dataType = "int", required = false),
	})
	public RestResult queryPageList(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		String orgId = getOrgId();
		return RestResult.buildSuccess(service.findByOrgId(orgId, pageNum, pageSize));
	}
	
	@ApiOperation(value = "保存字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "学校名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "schoolType", value = "类型1直营2合作3加盟4代理", dataType = "int", required = false),
		@ApiImplicitParam(name = "provinceId", value = "省", dataType = "string", required = false),
		@ApiImplicitParam(name = "cityId", value = "市", dataType = "string", required = false),
		@ApiImplicitParam(name = "districtId", value = "区", dataType = "string", required = false),
		@ApiImplicitParam(name = "addressDetail", value = "详细地址", dataType = "string", required = false),
		@ApiImplicitParam(name = "contact", value = "联系电话", dataType = "string", required = false),
		@ApiImplicitParam(name = "contactBackup", value = "备用电话", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/save.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult add(CrmField bean) {
		if (service.save(bean))
			return RestResult.buildSuccess();
		else
			return RestResult.buildFail();
	}
	
	@ApiOperation(value = "修改字段信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "schoolId", value = "学校Id", dataType = "string", required = false),
		@ApiImplicitParam(name = "name", value = "学校名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "schoolType", value = "类型1直营2合作3加盟4代理", dataType = "int", required = false),
		@ApiImplicitParam(name = "provinceId", value = "省", dataType = "string", required = false),
		@ApiImplicitParam(name = "cityId", value = "市", dataType = "string", required = false),
		@ApiImplicitParam(name = "districtId", value = "区", dataType = "string", required = false),
		@ApiImplicitParam(name = "addressDetail", value = "详细地址", dataType = "string", required = false),
		@ApiImplicitParam(name = "contact", value = "联系电话", dataType = "string", required = false),
		@ApiImplicitParam(name = "contactBackup", value = "备用电话", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/update.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult update(CrmField bean) {
		if (service.update(bean))
			return RestResult.buildSuccess();
		else
			return RestResult.buildFail();
	}
	
	@ApiOperation(value = "查看字段信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "ids", value = "字段id", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/read.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult read(String schoolId) {
		return RestResult.buildSuccess(service.findById(schoolId));
	}
	
	@ApiOperation(value = "删除字段信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "ids", value = "字段id列表", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/delete.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult delete(String ids) {
		return service.deleteByIds(ids);
	}
	/**
    * 查询客户管理列表页字段
    */
   //@NotNullValidate(value = "label",message = "label不能为空")
	@RequestMapping(value = { "/queryListHead" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
   public RestResult queryListHead(@Valid CrmFieldSort adminFieldSort){
       List<ColumnHeadVo> records = null;
       if (adminFieldSort.getLabel()!=null&&adminFieldSort.getLabel().equals("10")) {
           //records = oaExamineCategoryService.queryFieldList();
       }else {
           records = service.queryListHead(adminFieldSort);
       }
/*       List<AdminFieldStyle> fieldStyles = adminFieldService.queryFieldStyle(adminFieldSort.getLabel().toString());
       records.forEach(record -> {
           for (AdminFieldStyle fieldStyle:fieldStyles){
               if(record.get("fieldName")!=null&&fieldStyle.getFieldName().equals(record.get("fieldName"))){
                   record.set("width",fieldStyle.getStyle());
                   break;
               }
           }
           if(!record.getColumns().containsKey("width")){
               record.set("width",100);
           }
       });*/
       return RestResult.buildSuccess(records);
   }
    /**
     * @author wyq
     * 查询字段排序隐藏设置
     */
    //@NotNullValidate(value = "label",message = "label不能为空")
	@RequestMapping(value = { "/queryFieldConfig" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
    public RestResult queryFieldConfig(CrmFieldSort adminFieldSort){
		//OK
        return service.queryFieldConfig(getOrgId(),getIdentityFeature(),adminFieldSort);
    }
	/**
    * 设置字段排序隐藏
    */
 //  @NotNullValidate(value = "label",message = "label不能为空")
   //@NotNullValidate(value = "noHideIds",message = "显示列不能为空")
	@RequestMapping(value = { "/fieldConfig" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
   public RestResult fieldConfig(CrmFieldSort adminFieldSort){
		String staffId = this.getIdentityFeature();

	   return service.fieldConfig(getOrgId(),getIdentityFeature(),adminFieldSort);
   }
    /**
     * @author wyq
     * 查询新增或编辑字段
     */
	@RequestMapping(value = { "/queryField" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
    public void queryField(String label,String id){
      //  List<Record> recordList = new LinkedList<>();
        CrmEnum crmEnum = CrmEnum.parse(label);
        if (id != null){
            if (CrmEnum.CRM_LEADS.equals(crmEnum)){
               // recordList = crmLeadsService.queryField(id);
            }
/*            if (CrmEnum.CRM_CUSTOMER.equals(crmEnum)){
                recordList = crmCustomerService.queryField(id);
            }
            if (CrmEnum.CRM_CONTACTS.equals(crmEnum)){
                recordList = crmContactsService.queryField(id);
            }
            if (CrmEnum.CRM_PRODUCT.equals(crmEnum)){
                recordList = crmProductService.queryField(id);
            }
            if (CrmEnum.CRM_BUSINESS.equals(crmEnum)){
                recordList = crmBusinessService.queryField(id);
            }
            if (CrmEnum.CRM_CONTRACT.equals(crmEnum)){
                recordList = crmContractService.queryField(id);
            }
            if (CrmEnum.CRM_RECEIVABLES.equals(crmEnum)){
                recordList = crmReceivablesService.queryField(id);
            }
            if (CrmEnum.CRM_RECEIVABLES_PLAN.equals(crmEnum)){
                recordList = crmReceivablesPlanService.queryField(id);
            }
            if(10 == label){
                recordList = oaExamineCategoryService.queryField(id);
            }*/
        }else {
/*            if (CrmEnum.CRM_RECEIVABLES_PLAN.equals(crmEnum)){
                recordList = crmReceivablesPlanService.queryField();
            }else {
                recordList = adminFieldService.queryAddField(crmEnum);
            }*/
        }
/*        renderJson(R.ok().put("data",recordList));*/
    }
}
