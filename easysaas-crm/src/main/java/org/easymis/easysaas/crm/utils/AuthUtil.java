package org.easymis.easysaas.crm.utils;

import java.util.HashMap;
import java.util.Map;

import org.easymis.easysaas.crm.common.CrmEnum;

public class AuthUtil {
	 public static Map<String,String> getCrmTablePara(CrmEnum Enum){
	        Map<String,String> tableParaMap = new HashMap<>();
	        switch(Enum){
	            case CRM_CUSTOMER:
	                tableParaMap.put("tableName", "72crm_crm_customer");
	                tableParaMap.put("tableId", "customer_id");
	                tableParaMap.put("realm","customer");
	                break;
	            case CRM_LEADS:
	                tableParaMap.put("tableName", "72crm_crm_leads");
	                tableParaMap.put("tableId", "leads_id");
	                tableParaMap.put("realm","leads");
	                break;
	            case CRM_CONTRACT:
	                tableParaMap.put("tableName", "72crm_crm_contract");
	                tableParaMap.put("tableId", "contract_id");
	                tableParaMap.put("realm","contract");
	                break;
	            case CRM_CONTACTS:
	                tableParaMap.put("tableName", "72crm_crm_contacts");
	                tableParaMap.put("tableId", "contacts_id");
	                tableParaMap.put("realm","contacts");
	                break;
	            case CRM_BUSINESS:
	                tableParaMap.put("tableName", "72crm_crm_business");
	                tableParaMap.put("tableId", "business_id");
	                tableParaMap.put("realm","business");
	                break;
	            case CRM_RECEIVABLES:
	                tableParaMap.put("tableName", "72crm_crm_receivables");
	                tableParaMap.put("tableId", "receivables_id");
	                tableParaMap.put("realm","receivables");
	                break;
	            default:
	                return null;
	        }
	        return tableParaMap;
	    }
    public static boolean isCrmAuth(CrmEnum Enum, String id){
        return isCrmAuth(getCrmTablePara(Enum),id);
    }
    public static boolean isCrmAuth(Map<String,String> tablePara, String id){
        if(tablePara == null){
            return false;
        }
        String userId = BaseUtil.getUserId();
/*        List<Integer> roles = BaseUtil.getUser().getRoles();
        List<Long> longs = Aop.get(AdminUserService.class).queryUserByAuth(userId,tablePara.get("realm"));
        StringBuilder authSql = new StringBuilder("select count(*) from ");
        authSql.append(tablePara.get("tableName")).append(" where ").append(tablePara.get("tableId")).append(" = ").append(id);
        if(! BaseConstant.SUPER_ADMIN_USER_ID.equals(userId) && !roles.contains(BaseConstant.SUPER_ADMIN_ROLE_ID)){
            if(longs != null && longs.size() > 0){
                authSql.append(" and (owner_user_id in (").append(StrUtil.join(",", longs)).append(")");
                if("72crm_crm_customer".equals(tablePara.get("tableName")) || "72crm_crm_business".equals(tablePara.get("tableName")) || "72crm_crm_contract".equals(tablePara.get("tableName"))){
                    authSql.append(" or ro_user_id like CONCAT('%,','").append(userId).append("',',%')").append(" or rw_user_id like CONCAT('%,','").append(userId).append("',',%')");
                }
                authSql.append(")");
            }
        }
        return Db.queryInt(authSql.toString()) == 0;*/
        return true;
    }
}
