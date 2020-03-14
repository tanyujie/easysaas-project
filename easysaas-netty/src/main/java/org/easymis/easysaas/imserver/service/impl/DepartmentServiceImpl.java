package org.easymis.easysaas.imserver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.Department;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.DepartmentMapper;
import org.easymis.easysaas.imserver.entitys.vo.DepartmentTreeVo;
import org.easymis.easysaas.imserver.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyuncs.utils.StringUtils;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper mapper;
	@Override
	public List<DepartmentTreeVo> getTree(String orgId) {
		List<Department> departmentList = mapper.findByOrgId(orgId);
		List<DepartmentTreeVo> firstList = new ArrayList<DepartmentTreeVo>();
		for (int i = 0; i < departmentList.size(); i++) {
			if (StringUtils.isEmpty(departmentList.get(i).getParentId())) {
				DepartmentTreeVo firstDepartment = new DepartmentTreeVo();
				BeanUtils.copyProperties(departmentList.get(i), firstDepartment);
				List<DepartmentTreeVo> secondList = new ArrayList<DepartmentTreeVo>();
				for (int j = 0; j < departmentList.size(); j++) {
					if (departmentList.get(j).getParentId() != null
							&& departmentList.get(j).getParentId().equals(firstDepartment.getId())) {
						DepartmentTreeVo secondDepartment = new DepartmentTreeVo();
						BeanUtils.copyProperties(departmentList.get(j), secondDepartment);
						List<DepartmentTreeVo> thirdList = new ArrayList<DepartmentTreeVo>();
						for (int k = 0; k < departmentList.size(); k++) {
							if (departmentList.get(k).getParentId() != null
									&& departmentList.get(k).getParentId().equals(secondDepartment.getId())) {
								DepartmentTreeVo thirdDepartment = new DepartmentTreeVo();
								BeanUtils.copyProperties(departmentList.get(k), thirdDepartment);
								thirdDepartment.setDepartmentList(new ArrayList<DepartmentTreeVo>());
								thirdList.add(thirdDepartment);
							}

						}
						secondDepartment.setDepartmentList(thirdList);
						secondList.add(secondDepartment);
					}
				

				}
				firstDepartment.setDepartmentList(secondList);
				firstList.add(firstDepartment);
			}
		}
		return firstList;
	}

}
