package org.easymis.easysaas.imserver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.HrmStaffInfo;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.HrmStaffInfoMapper;
import org.easymis.easysaas.imserver.entitys.vo.DepartmentTreeVo;
import org.easymis.easysaas.imserver.entitys.vo.StaffInfoVo;
import org.easymis.easysaas.imserver.service.DepartmentService;
import org.easymis.easysaas.imserver.service.HrmStaffInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.utils.StringUtils;
@Service
public class HrmStaffInfoServiceImpl implements HrmStaffInfoService {
	@Autowired
	private DepartmentService service;
	@Autowired
	private HrmStaffInfoMapper mapper;
	@Override
	public RestResult getListByDepartment(String orgId) {
		if(StringUtils.isEmpty(orgId))
			return RestResult.buildError("组织机构不能为空");
		List<DepartmentTreeVo> departmentTreeList =service.getTree(orgId);
		List<DepartmentTreeVo> firstList =service.getTree(orgId);
		List<HrmStaffInfo> staffList=mapper.findByOrgId(orgId);
		for (int i = 0; i < departmentTreeList.size(); i++) {
			if (firstList.get(i).getLevel()==1) {
				DepartmentTreeVo firstDepartment = departmentTreeList.get(i);				
				List<DepartmentTreeVo> secondList = firstDepartment.getDepartmentList();
				for (int j = 0; j < secondList.size(); j++) {
					if (secondList.get(j).getParentId() != null
							&& secondList.get(j).getParentId().equals(firstDepartment.getId())) {
						DepartmentTreeVo secondDepartment = secondList.get(j);
						secondDepartment.setStaffList(makeStaffList(secondDepartment.getId(),staffList));
						List<DepartmentTreeVo> thirdList = secondDepartment.getDepartmentList();
						for (int k = 0; k < thirdList.size(); k++) {
							if (thirdList.get(k).getParentId() != null
									&& thirdList.get(k).getParentId().equals(secondDepartment.getId())) {
								thirdList.get(k).setStaffList(makeStaffList(thirdList.get(k).getId(),staffList));
							}

						}
						secondDepartment.setStaffList(makeStaffList(secondDepartment.getId(),staffList));
					}
				

				}
				firstDepartment.setStaffList(makeStaffList(firstDepartment.getId(),staffList));
				firstList.add(firstDepartment);
			}
		}
	
		return RestResult.buildSuccess(firstList);
	}

	private List<StaffInfoVo> makeStaffList(String departmentId, List<HrmStaffInfo> staffList) {
		List<StaffInfoVo> list = new ArrayList<StaffInfoVo>();
		for (int i = 0; i < staffList.size(); i++) {
			if (departmentId.equals(staffList.get(i).getDepartmentId())) {
				StaffInfoVo staffInfoVo = new StaffInfoVo();
				BeanUtils.copyProperties(staffList.get(i), staffInfoVo);
				list.add(staffInfoVo);
			}

		}
		return list;

	}

}
