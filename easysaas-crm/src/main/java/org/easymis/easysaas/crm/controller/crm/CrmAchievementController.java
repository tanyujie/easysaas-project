package org.easymis.easysaas.crm.controller.crm;

import org.easymis.easysaas.crm.entitys.dto.CrmAchievement;
import org.easymis.easysaas.crm.service.CrmAchievementService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
　 * <p>Title: 业绩目标设置</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年3月1日
 */
public class CrmAchievementController {

	@Autowired
    private CrmAchievementService crmAchievementService;

    /**
     * 设置业绩目标
     */
    public void setAchievement(){
/*        String data = getRawData();
        List<CrmAchievement> crmAchievements = JSON.parseArray(data, CrmAchievement.class);
        renderJson(adminAchievementService.setAchievement(crmAchievements));*/
    }

    /**
     * 查询业绩目标列表
     * @param achievement 业绩目标对象
     */
    public void queryAchievementList(CrmAchievement achievement){
/*        String userId = getPara("userId");
        String departmentId = getParaToInt("deptId");
        renderJson(adminAchievementService.queryAchievementList(achievement,userId,deptId));*/
    }


}
