package org.easymis.easysaas.crm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.record.Record;
import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.common.CrmEnum;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmField;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmScene;
import org.easymis.easysaas.crm.entitys.mybatis.dto.School;
import org.easymis.easysaas.crm.entitys.mybatis.mapper.CrmSceneMapper;
import org.easymis.easysaas.crm.service.CrmSceneService;
import org.easymis.easysaas.crm.utils.BaseUtil;
import org.easymis.easysaas.crm.utils.Kv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.jfinal.aop.Aop;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.SqlPara;
import com.kakarote.crm9.common.constant.BaseConstant;
import com.kakarote.crm9.erp.admin.entity.AdminField;
import com.kakarote.crm9.erp.admin.service.AdminUserService;
import com.kakarote.crm9.utils.ParamsUtil;
import com.kakarote.crm9.utils.R;

import cn.hutool.core.util.StrUtil;
@Service
public class CrmSceneServiceImpl implements CrmSceneService {
	@Autowired
	private CrmSceneMapper mapper;
	@Override
	public boolean save(CrmScene bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CrmScene bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public School findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult deleteByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult filterConditionAndGetPageList(BasePageRequest basePageRequest) {
        JSONObject jsonObject = basePageRequest.getJsonObject();
        String sceneId = jsonObject.getString("sceneId");
        JSONObject data = new JSONObject();
        if(StringUtils.isNotEmpty(sceneId)){
            //data = JSON.parseObject(AdminScene.dao.findById(sceneId).getData());
        }
        if(sceneId == null && jsonObject.getInteger("type") == 1){
            data = new JSONObject().fluentPut("is_transform", new JSONObject().fluentPut("name", "is_transform").fluentPut("condition", "is").fluentPut("value", "0"));
        }
        if(jsonObject.getJSONObject("data") != null){
            if(data != null){
                data.putAll(jsonObject.getJSONObject("data"));
            }
        }
        jsonObject.put("data",data);
        basePageRequest.setJsonObject(jsonObject);
        return getCrmPageList(basePageRequest);
    }
    /**

     * Crm列表页查询
     */
    public RestResult getCrmPageList(BasePageRequest basePageRequest){
        JSONObject jsonObject = basePageRequest.getJsonObject();
        Kv kv = new Kv();
        String realm;
        List<JSONObject> queryList = new ArrayList<>();
        Integer type = jsonObject.getInteger("type");
        //自定义字段列表
        Map<String,CrmField> fieldMap = getAdminFieldMap(type == 9 ? 2 : type);
        //权限标识
        switch(type){
            case 1:
                realm = "leads";
                break;
            case 2:
                realm = "customer";
                break;
            case 3:
                realm = "contacts";
                break;
            case 4:
                realm = "product";
                break;
            case 5:
                realm = "business";
                break;
            case 6:
                realm = "contract";
                break;
            case 7:
                realm = "receivables";
                break;
            case 9:
                realm = "customer";
                break;
            case 0:
                realm = "business";
                if(jsonObject.getJSONObject("data").containsKey("create_time")){
                    JSONObject sqlObject = new JSONObject();
                    JSONObject date=jsonObject.getJSONObject("data").getJSONObject("create_time");
                    sqlObject.put("sql", "and (SELECT COUNT(*) FROM 72crm_crm_business_change as b WHERE b.business_id = a.business_id and (b.create_time between '"+date.getString("start")+"' and  '"+date.getString("end")+"'))>0");
                    sqlObject.put("type", 1);
                    queryList.add(sqlObject);
                    jsonObject.getJSONObject("data").remove("create_time");
                }
                break;
            default:
                return RestResult.buildError("type不符合要求");
        }
        JSONObject data = basePageRequest.getJsonObject().getJSONObject("data");
        if (!appendSqlCondition(kv, fieldMap, queryList, data)){
            return RestResult.buildError("参数包含非法字段");
        }
        String search = basePageRequest.getJsonObject().getString("search");
        if(StrUtil.isNotEmpty(search)){
            if (!appendSqlSearch(type, queryList, search)){
                return RestResult.buildError("参数包含非法字段");
            }
            if(!kv.containsKey("fixed")){
                kv.set("fixed",true);
            }
        }

        String camelField = basePageRequest.getJsonObject().getString("sortField");
        String sortField = StrUtil.toUnderlineCase(camelField);
        String orderNum = basePageRequest.getJsonObject().getString("order");
        if(StrUtil.isEmpty(sortField) || StrUtil.isEmpty(orderNum)){
            kv.set("orderByKey", "update_time").set("orderByType", "desc").set("fieldType", 1);
        }else{
            if(! ParamsUtil.isValid(sortField)){
                return RestResult.buildError("参数包含非法字段");
            }
            orderNum = "2".equals(orderNum) ? "asc" : "desc";
            kv.set("orderByKey", sortField).set("orderByType", orderNum).set("fieldType", fieldMap.get(sortField) != null ? fieldMap.get(sortField).getFieldType() : 0);
        }
        StringBuilder conditions = new StringBuilder();
        if(2 == type){
            conditions.append(" and owner_user_id is not null");
        }else if(9 == type){
            conditions.append(" and owner_user_id is null");
        }else if(4 == type){
            conditions.append(" and status != '3'");
        }
        Long userId = BaseUtil.getUserId();
        List<Integer> roles = BaseUtil.getUser().getRoles();
        if((!type.equals(9) && ! type.equals(4)) && ! BaseConstant.SUPER_ADMIN_USER_ID.equals(userId) && !roles.contains(BaseConstant.SUPER_ADMIN_ROLE_ID)){
            List<Long> longs = Aop.get(AdminUserService.class).queryUserByAuth(userId, realm);
            if(longs != null && longs.size() > 0){
                conditions.append(" and (owner_user_id in (").append(StrUtil.join(",", longs)).append(")");
                if(type.equals(2) || type.equals(6) || type.equals(5)){
                    conditions.append(" or ro_user_id like CONCAT('%,','").append(userId).append("',',%')").append(" or rw_user_id like CONCAT('%,','").append(userId).append("',',%')");
                }
                conditions.append(")");
            }
        }
        JSONObject sqlObject = new JSONObject();
        sqlObject.put("sql", conditions.toString());
        sqlObject.put("type", 1);
        if(!kv.containsKey("fixed")){
            kv.set("fixed",true);
        }
        queryList.add(sqlObject);
        if(StrUtil.isEmpty(basePageRequest.getJsonObject().getString("excel"))){
            kv.set("page", (basePageRequest.getPage() - 1) * basePageRequest.getLimit()).set("limit", basePageRequest.getLimit());
        }
        String selectSql;
        JSONObject resultJsonObject = new JSONObject();
        if(2 == type){
            Integer configType = Db.queryInt("select status from 72crm_admin_config where name = 'customerPoolSetting'");
            selectSql = 1 == configType ? Db.getSql("admin.scene.getCustomerPageList") : "select *,(select count(*) from 72crm_crm_business as a where a.customer_id = views.customer_id) as business_count";
        }else if(6 == type){
            selectSql = "select *,IFNULL((select SUM(a.money) from 72crm_crm_receivables as a where a.check_status = '1' and a.contract_id = views.contract_id),0) as receivedMoney,(IFNUll(money,0) - IFNULL((select SUM(a.money) from 72crm_crm_receivables as a where a.check_status = '1' and a.contract_id = views.contract_id),0)) as unreceivedMoney";
        }else if(9 == type){
            Integer putInPoolTodayNum = Db.queryInt(Db.getSql("admin.scene.queryPutInPoolTodayNum"));
            selectSql = "select *";
            resultJsonObject.put("putInPoolTodayNum", putInPoolTodayNum);
        }else{
            selectSql = "select * ";
        }
        List<String> batchList = queryBatchId(queryList);
        if(batchList.size()==0&&kv.containsKey("field")){
            batchList.add("");
        }
        kv.set("select", selectSql).set("queryList", queryList).set("realm", realm).set("fieldMap", fieldMap).set("label", type == 9 ? 2 : type);
        kv.set("batchList",batchList);
        SqlPara sqlPara;
        if(kv.getInt("fieldType") == 0){
            sqlPara = Db.getSqlPara("admin.scene.queryCrmPageListByFieldType2", kv);
        }else{
            sqlPara = Db.getSqlPara("admin.scene.queryCrmPageListByFieldType1", kv);
        }
        List<Record> recordPage = Db.find(sqlPara);
        if(type == CrmEnum.CRM_BUSINESS.getType()){
            recordPage.forEach(record -> {
                if(record.getInt("is_end") == 1){
                    record.set("status_name", "赢单");
                }else if(record.getInt("is_end") == 2){
                    record.set("status_name", "输单");
                }else if(record.getInt("is_end") == 3){
                    record.set("status_name", "无效");
                }
            });
            setBusinessStatus(recordPage);
        }else if (type == CrmEnum.CRM_CONTRACT.getType()){
            if(recordPage.size() > 0){
                List<Integer> contractIds = recordPage.stream().map(record -> record.getInt("contract_id")).collect(Collectors.toList());
                Record record = Db.findFirst("SELECT IFNULL(SUM(money),0) AS contractMoney,IFNULL(SUM(receivedMoney),0) AS receivedMoney from (SELECT a.money,(SELECT SUM(money) FROM 72crm_crm_receivables AS b where b.contract_id=a.contract_id and b.check_status = 1) as receivedMoney FROM 72crm_crm_contract AS a WHERE a.check_status = '1' AND a.contract_id IN (" + StrUtil.join(",", contractIds) + ")) as x");
                resultJsonObject.put("money", record);
            }
        }
        resultJsonObject.put("list", recordPage);
        SqlPara countSql = Db.getSqlPara("admin.scene.queryCrmPageListCount", kv);
        Integer count = Db.queryInt(countSql.getSql(), countSql.getPara());
        resultJsonObject.put("totalRow", count);
        return R.ok().put("data", resultJsonObject);
    }
    public Map<String,CrmField> getAdminFieldMap(Integer type){
        Map<String,CrmField> adminFieldMap = CaffeineCache.ME.get("field", type);
        if(adminFieldMap == null){
            List<AdminField> adminFields = AdminField.dao.find("SELECT field_name,field_type,type FROM 72crm_admin_field WHERE label=?", type);
            adminFieldMap = new HashMap<>();
            for(AdminField adminField : adminFields){
                adminFieldMap.put(adminField.getFieldName(), adminField);
                if(adminField.getType().equals(12) && ! adminFieldMap.containsKey("dept")){
                    adminFieldMap.put("dept", null);
                }else if(adminField.getType().equals(10) && ! adminFieldMap.containsKey("user")){
                    adminFieldMap.put("user", null);
                }
            }
            CrmField adminField=new CrmField();
            adminField.setFieldType(1);
            adminFieldMap.put("owner_user_id",adminField);
            adminFieldMap.put("create_user_id",adminField);
            adminFieldMap.put("create_time",adminField);
            adminFieldMap.put("update_time",adminField);
            adminFieldMap.put("is_transform",adminField);
            adminFieldMap.put("deal_status",adminField);
            adminFieldMap.put("customer_id",adminField);
            adminFieldMap.put("contract_id",adminField);
            adminFieldMap.put("contacts_id",adminField);
            adminFieldMap.put("leads_id",adminField);
            adminFieldMap.put("receivables_id",adminField);
            adminFieldMap.put("product_id",adminField);
            adminFieldMap.put("business_id",adminField);
        }
        return adminFieldMap;
    }
}
