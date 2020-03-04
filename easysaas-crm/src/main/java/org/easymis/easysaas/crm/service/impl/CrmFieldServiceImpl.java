package org.easymis.easysaas.crm.service.impl;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmField;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmFieldSort;
import org.easymis.easysaas.crm.entitys.mybatis.mapper.CrmFieldMapper;
import org.easymis.easysaas.crm.entitys.mybatis.mapper.CrmFieldSortMapper;
import org.easymis.easysaas.crm.entitys.vo.ColumnHeadVo;
import org.easymis.easysaas.crm.service.CrmFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CrmFieldServiceImpl implements CrmFieldService{
	@Autowired
	private CrmFieldMapper mapper;
	@Autowired
	private CrmFieldSortMapper fieldSortMapper;
	@Override
	public boolean save(CrmField bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CrmField bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CrmField findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByOrgId(String orgId,Integer pageNum, Integer pageSize) {
    	PageHelper.startPage(pageNum, pageSize);
    	List<CrmField> fieldList = mapper.findByOrgId(orgId);
		PageInfo<CrmField> p = new PageInfo<CrmField>(fieldList);
        return p;
	}

	@Override
	public RestResult deleteByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ColumnHeadVo> queryListHead(CrmFieldSort fieldSort) {
        //查看userid是否存在于顺序表，没有则插入
        String staffId = "3";//BaseUtil.getMember().getMemberId();
        String orgId="orgId";//BaseUtil.getOrgId();
        Integer number = fieldSortMapper.getCount(orgId,staffId, fieldSort.getLabel());
        if (0 == number) {
/*            List<Record> fieldList;
            if (adminFieldSort.getLabel() == CrmEnum.CRM_CUSTOMER_POOL.getType()){
                fieldList = list(CrmEnum.CRM_CUSTOMER.getType());
            }else {
                fieldList = list(adminFieldSort.getLabel());
            }
            List<AdminFieldSort> sortList = new LinkedList<>();
            FieldUtil fieldUtil = new FieldUtil(sortList, userId, adminFieldSort.getLabel());
            if (null != fieldList) {
                for (Record record : fieldList) {
                    fieldUtil.add(record.getStr("field_name"), record.getStr("name"), record.getInt("type"), record.getInt("field_id"));
                }
            }
            if (CrmEnum.CRM_CUSTOMER.getType() == adminFieldSort.getLabel()){
                fieldUtil.add("dealStatus", "成交状态", 3)
                        .add("poolDay", "距进入公海客户天数", 5)
                        .add("lastTime", "最后跟进时间", 4)
                        .add("lastContent","最后跟进记录",1);
            }else if (CrmEnum.CRM_BUSINESS.getType() == adminFieldSort.getLabel()){
                fieldUtil.add("typeName", "商机状态组", 3).add("statusName", "商机阶段", 3);
            }else if (CrmEnum.CRM_CONTRACT.getType() == adminFieldSort.getLabel()){
                fieldUtil.add("receivedMoney","已收款金额",6).add("unreceivedMoney","未收款金额",6);
            }else if (CrmEnum.CRM_RECEIVABLES.getType() == adminFieldSort.getLabel()){
                fieldUtil.add("contractMoney","合同金额",6);
            }else if (CrmEnum.CRM_CUSTOMER_POOL.getType() == adminFieldSort.getLabel()){
                fieldUtil.add("dealStatus","成交状态",3)
                        .add("lastContent","最后跟进记录",1);
            }else if(CrmEnum.CRM_LEADS.getType() == adminFieldSort.getLabel()){
                fieldUtil.add("lastContent","最后跟进记录",1);
            }
            fieldUtil.add("updateTime", "更新时间",4).add("createTime", "创建时间",4)
                    .add("ownerUserName", "负责人",1).add("createUserName", "创建人",1);
            fieldUtil.getAdminFieldSortList().forEach(fieldSort -> {
                String fieldName = StrUtil.toCamelCase(fieldSort.getFieldName());
                fieldSort.setFieldName(fieldName);
                if ("customerId".equals(fieldSort.getFieldName())){
                    fieldSort.setFieldName("customerName");
                } else if ("categoryId".equals(fieldSort.getFieldName())){
                    fieldSort.setFieldName("categoryName");
                } else if ("contactsId".equals(fieldSort.getFieldName())){
                    fieldSort.setFieldName("contactsName");
                } else if ("companyUserId".equals(fieldSort.getFieldName())){
                    fieldSort.setFieldName("companyUserName");
                } else if ("businessId".equals(fieldSort.getFieldName())){
                    fieldSort.setFieldName("businessName");
                } else if ("contractId".equals(fieldSort.getFieldName())){
                    fieldSort.setFieldName("contractNum");
                } else if ("planId".equals(fieldSort.getFieldName())){
                    fieldSort.setFieldName("planNum");
                }
            });
            sortList = fieldUtil.getAdminFieldSortList();
            for (int i = 0; i < sortList.size(); i++) {
                AdminFieldSort newUserFieldSort = sortList.get(i);
                newUserFieldSort.setSort(i).save();
            }*/
        }

        List<ColumnHeadVo> recordList = mapper.getColumnHead(orgId,fieldSort.getLabel(), staffId);
        //List<ColumnHeadVo> recordList = Db.findByCache("field", "listHead:" + adminFieldSort.getLabel() + userId, Db.getSql("admin.field.queryListHead"), adminFieldSort.getLabel(), userId);
       // recordToFormType(recordList);
        return recordList;
	}

}
