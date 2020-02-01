package org.easymis.easysaas.open.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import org.easymis.easysaas.open.config.datasource.DataSourceType;
import org.easymis.easysaas.open.config.datasource.EasymisDataSource;
import org.easymis.easysaas.open.entitys.mybatis.dto.CompanyExportHistory;
import org.easymis.easysaas.open.entitys.mybatis.mapper.CompanyExportHistoryMapper;
import org.easymis.easysaas.open.entitys.vo.SearchOutput;
import org.easymis.easysaas.open.service.CompanyExportHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompanyExportHistoryServiceImpl implements CompanyExportHistoryService {
	@Autowired
	CompanyExportHistoryMapper mapper;
	@Override
	public List<String> findByShort(String memberId, String exportQueryMD5) {
		// TODO Auto-generated method stub
		return mapper.findByShort(memberId, exportQueryMD5);
	}
/**
     *  1.查询es,每次只查询1000条,每次导出数量5000条,深度默认为10000条.
     *  2.判断当前用户是否有导出权限,能导出数量,不能超过5000条每次.
     *  3.每查询1000条,与ExportHistoryRecord内的记录比对,求这1000条的差集,放入预先设定的列表内.
     *  4.直到取出的导出数量满足,或者到达查询深度20000条.
     *  5.保存导出结果到ExportHistoryRecord表,转化成excel发送到目标邮箱.
     *  对目标列表进行比对,全局比对,不对单一查询去重
 */
	@Override
	public List<SearchOutput> compareDifferenceOfTarget(List<String> longs, List<SearchOutput> targetList) {
		List<SearchOutput> differenceList = new ArrayList<>();
		if (longs.size() > 0) {
			targetList.stream().forEach(target -> {
				if (!longs.contains(target.getCompanyId())) {
					differenceList.add(target);
				}
			});
		} else {
			differenceList.addAll(targetList);
		}
		return differenceList;
	}


	@EasymisDataSource(DataSourceType.Master)
	public void saveOutput(List<SearchOutput> targetList, String memberId, String queryConditionMd5) {
		String random = UUID.randomUUID().toString();
		random=random.replace("-", "");
		List<CompanyExportHistory> shorts = targetList.stream()
				.map(queryOutput -> new CompanyExportHistory().setCompanyId(queryOutput.getCompanyId())
						.setMemberId(memberId).setCreateTime(LocalDateTime.now())
						.setQueryConditionMd5(queryConditionMd5))
				.collect(Collectors.toList());
		mapper.saveBatch(shorts);
}

	@Override
	public void saveBatch(List<CompanyExportHistory> historyRecords) {
		// TODO Auto-generated method stub

	}
    public String generatestr() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        char[] res = new char[16];
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            res[i] = chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return new String(res);
    }
}
