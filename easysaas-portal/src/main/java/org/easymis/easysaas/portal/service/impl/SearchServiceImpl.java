package org.easymis.easysaas.portal.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.easymis.easysaas.common.result.PageData;
import org.easymis.easysaas.common.result.PageVO;
import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.common.utils.PayUtils;
import org.easymis.easysaas.portal.config.ElasticSearchConfig;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyDto;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyExport;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyExportHistory;
import org.easymis.easysaas.portal.entitys.vo.ExportQueryVo;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;
import org.easymis.easysaas.portal.entitys.vo.SearchVo;
import org.easymis.easysaas.portal.entitys.vo.SecurityUserDetails;
import org.easymis.easysaas.portal.service.CompanyExportHistoryService;
import org.easymis.easysaas.portal.service.CompanyExportService;
import org.easymis.easysaas.portal.service.GeneralTaskService;
import org.easymis.easysaas.portal.service.SearchService;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SearchServiceImpl implements SearchService {
	@Autowired
	private JestClient jestClient;
    @Autowired
    CompanyExportService queryRecordService;
	@Autowired
	CompanyExportHistoryService exportHistoryRecordService;
    @Autowired
    private GeneralTaskService generalTaskService;
	
	@Override
	public PageData esQuery(SearchVo searchVo) throws IOException, ElasticSearchMaxRecordException {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		PageData pageData = new PageData();

		if (!StringUtils.isEmpty(searchVo.getWd())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("companyName", searchVo.getWd().trim()).operator(Operator.AND).analyzer("ik_max_word"));
			// boolQueryBuilder.must(QueryBuilders.matchQuery("name", wd.trim()));
		}
		// 搜索范围
		if (!StringUtils.isEmpty(searchVo.getSearchType())) {
			if ("company".equals(searchVo.getSearchType())) {

			} else if ("human".equals(searchVo.getSearchType())) {

			} else if ("service".equals(searchVo.getSearchType())) {

			} else if ("trademark".equals(searchVo.getSearchType())) {

			} else if ("contact".equals(searchVo.getSearchType())) {

			} else if ("scope".equals(searchVo.getSearchType())) {

			}

		}
		// 机构类型
		if (!StringUtils.isEmpty(searchVo.getCompanyType())) {

		}
		// 省份地区
		if (!StringUtils.isEmpty(searchVo.getProvince())) {

		}
		// 区县
		if (!StringUtils.isEmpty(searchVo.getAreaCode())) {

		}
		/** 成立时间范围 */
		if (Objects.nonNull(searchVo.getEstiblishTimeYearType())) {
			// list.add(processParamlist("注册时间", "estiblishTimeYearType",
			// "1年内=1-2年=2-3年=3-5年=5-10年=10年以上", "1=2=3=4=5=6"));
			LocalDate now = LocalDate.now();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
			Integer estiblishTimeFrom = new Integer(now.minus(1, ChronoUnit.YEARS).format(format));
			Integer estiblishTimeTo = new Integer(now.format(format));
			if (searchVo.getEstiblishTimeYearType() == 1)
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			if (searchVo.getEstiblishTimeYearType() == 2) {
				estiblishTimeFrom = new Integer(now.minus(2, ChronoUnit.YEARS).format(format));
				estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.YEARS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			}

			if (searchVo.getEstiblishTimeYearType() == 3) {
				estiblishTimeFrom = new Integer(now.minus(3, ChronoUnit.YEARS).format(format));
				estiblishTimeTo = new Integer(now.minus(2, ChronoUnit.YEARS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			}
			if (searchVo.getEstiblishTimeYearType() == 4) {
				estiblishTimeFrom = new Integer(now.minus(5, ChronoUnit.YEARS).format(format));
				estiblishTimeTo = new Integer(now.minus(3, ChronoUnit.YEARS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			}
			if (searchVo.getEstiblishTimeYearType() == 5) {
				estiblishTimeFrom = new Integer(now.minus(10, ChronoUnit.YEARS).format(format));
				estiblishTimeTo = new Integer(now.minus(5, ChronoUnit.YEARS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));

			}
			if (searchVo.getEstiblishTimeYearType() == 5) {
				estiblishTimeFrom = new Integer(now.minus(10, ChronoUnit.YEARS).format(format));
				estiblishTimeTo = new Integer(now.minus(5, ChronoUnit.YEARS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));

			}
			if (searchVo.getEstiblishTimeYearType() == 6) {
				estiblishTimeFrom = new Integer(now.minus(1000, ChronoUnit.YEARS).format(format));
				estiblishTimeTo = new Integer(now.minus(10, ChronoUnit.YEARS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));

			}
			// 21-7天内22-15天内23-1个月内24-3个月内25-半年内26-一年内
			if (searchVo.getEstiblishTimeYearType() == 21) {
				estiblishTimeFrom = new Integer(now.minus(7, ChronoUnit.DAYS).format(format));
				estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			} else if (searchVo.getEstiblishTimeYearType() == 22) {
				estiblishTimeFrom = new Integer(now.minus(15, ChronoUnit.DAYS).format(format));
				estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			} else if (searchVo.getEstiblishTimeYearType() == 23) {
				estiblishTimeFrom = new Integer(now.minus(1, ChronoUnit.MONTHS).format(format));
				estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			} else if (searchVo.getEstiblishTimeYearType() == 24) {
				estiblishTimeFrom = new Integer(now.minus(3, ChronoUnit.MONTHS).format(format));
				estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			} else if (searchVo.getEstiblishTimeYearType() == 25) {
				estiblishTimeFrom = new Integer(now.minus(6, ChronoUnit.MONTHS).format(format));
				estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			} else if (searchVo.getEstiblishTimeYearType() == 26) {
				estiblishTimeFrom = new Integer(now.minus(1, ChronoUnit.YEARS).format(format));
				estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
			}

		}
		/** 注册资本金额范围 */

		if (Objects.nonNull(searchVo.getRegisterCapitalNumberType())) {
			// list.add(processParamlist("注册资本", "registeredCapitalNumberType",
			// "100万以下=100-200万=200-500万=500-1000万=1000万以上", "1=2=3=4=5"));
			if (searchVo.getRegisterCapitalNumberType() == 1)
				boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("registered_capital").gte(0).lte(100 * 1000000));
			if (searchVo.getRegisterCapitalNumberType() == 2)
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("registered_capital").gte(100 * 1000000).lte(200 * 1000000));
			if (searchVo.getRegisterCapitalNumberType() == 3)
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("registered_capital").gte(200 * 1000000).lte(500 * 1000000));
			if (searchVo.getRegisterCapitalNumberType() == 4)
				boolQueryBuilder.filter()
						.add(QueryBuilders.rangeQuery("registered_capital").gte(500 * 1000000).lte(1000 * 1000000));
			if (searchVo.getRegisterCapitalNumberType() == 5)
				boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("registered_capital").gte(1000 * 1000000));
		}
		/** 联系方式 */
		if (new Integer(1).equals(searchVo.getHaveContact())) {

		}
		if (new Integer(0).equals(searchVo.getHaveContact())) {

		}
		/** 手机 */
		if (new Integer(1).equals(searchVo.getHaveMobile())) {

		}
		if (new Integer(0).equals(searchVo.getHaveMobile())) {

		}
		/** 商标 */
		if (new Integer(1).equals(searchVo.getHaveTrademark())) {

		}
		if (new Integer(0).equals(searchVo.getHaveTrademark())) {

		}
		/** 邮箱 */
		if (new Integer(1).equals(searchVo.getHaveEmail())) {
			boolQueryBuilder.filter(QueryBuilders.boolQuery().must(QueryBuilders.existsQuery("email"))
					.must(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("email", ""))
							.mustNot(QueryBuilders.termsQuery("email", "无"))));
		}
		if (new Integer(0).equals(searchVo.getHaveEmail())) {
			boolQueryBuilder.filter(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("email", ""))
					.should(QueryBuilders.termsQuery("email", "无"))
					.should(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("email"))));
		}
		/** 网站 */
		if (new Integer(1).equals(searchVo.getHaveWebSite())) {
			boolQueryBuilder.filter(QueryBuilders.boolQuery().must(QueryBuilders.existsQuery("website"))
					.must(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("website", ""))
							.mustNot(QueryBuilders.termsQuery("website", "无"))));
		}
		if (new Integer(0).equals(searchVo.getHaveWebSite())) {
			boolQueryBuilder.filter(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("website", ""))
					.should(QueryBuilders.termsQuery("website", "无"))
					.should(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("website"))));
		}
		/** 高亮公司名 */
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		highlightBuilder.field("companyName");
		searchSourceBuilder.query(boolQueryBuilder);
		searchSourceBuilder.highlighter(highlightBuilder);

		searchSourceBuilder.size(searchVo.getPageSize());
		searchSourceBuilder.from((searchVo.getPageNo() - 1) * searchVo.getPageSize());
		searchSourceBuilder.timeout(TimeValue.timeValueSeconds(20));
//        searchSourceBuilder.fetchSource(false);

		String queryStr = searchSourceBuilder.toString();
		log.info("\n******es语句：" + queryStr);
		Search search = new Search.Builder(queryStr).addIndex(ElasticSearchConfig.INDEX_NAME).build();

		SearchResult result = jestClient.execute(search);
		
		/** 返回字段处理 */
		List<SearchResult.Hit<SearchOutput, Void>> hits = result.getHits(SearchOutput.class, false);

		List<SearchOutput> outList = new ArrayList<>();
		try {
			for (SearchResult.Hit<SearchOutput, Void> esQueryOutputDTOVoidHit : hits) {
				SearchOutput out = esQueryOutputDTOVoidHit.source;
				if (StringUtils.isNotEmpty(out.getCompanyName())) {
					out.setNameHighlight(esQueryOutputDTOVoidHit.highlight.get("companyName").get(0));
				}

				outList.add(out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        Long total = result.getJsonObject().get("hits").getAsJsonObject().get("total").getAsJsonObject().get("value").getAsLong();
        if (outList.size() == 0)
            total = 0L;
        pageData.setInfo(outList);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(total);
        pageVO.setPageSize(searchVo.getPageSize());
        pageVO.setPageNum(searchVo.getPageNo());
        Long pages = total / searchVo.getPageSize();
        if (total % searchVo.getPageSize() > 0)
            pages = pages + 1;
        pageVO.setPages(pages.intValue());
        pageData.setPage(pageVO);     
		return pageData;
	}

	@Override
	public void exportQueryResult(ExportQueryVo exportQueryVo, Integer exportedNumber, String email,
			String memberId, String exportedQueryString, String exportedQueryMD5,
			CompanyExport companyExportRecord) throws Exception{
        List<SearchOutput> queryResultDto = new ArrayList<>();
        SearchVo dto = new SearchVo();
        BeanUtils.copyProperties(exportQueryVo, dto);
        dto.setWd(exportQueryVo.getKeyword());
        PageData pageData = new PageData();
        log.info("exportQueryResult 开始对比：");
        int step = 0;
        int size = 200;
        int repeatRecord = 0;
		List<String> cacheLongs = exportHistoryRecordService.findByShort(memberId, exportedQueryMD5);

        try {
            for (int i = 0; i < 10000; ) {//10000是深度
                dto.setPageNo(step+1);
                dto.setPageSize(size);
                //bug问题点，500页去重处理
                pageData = this.esQuery(dto);
                List<SearchOutput> infoList = (List<SearchOutput>) pageData.getInfo();
                if (infoList.size() == 0) {
                    break;
                } else {//去重处理
                    log.info("去重前数据:" + infoList.size());
                    List<SearchOutput> differenceList = exportHistoryRecordService.compareDifferenceOfTarget(cacheLongs,infoList);
                    log.info("去重后数据:" + differenceList.size());
                    repeatRecord = repeatRecord + (infoList.size() - differenceList.size());
                    if (differenceList.size() != 0) {
                    	cacheList(differenceList,cacheLongs);
                        int diff = exportedNumber - queryResultDto.size();
                        if (diff > differenceList.size()) {
                            queryResultDto.addAll(differenceList);
                            exportHistoryRecordService.saveOutput(differenceList, memberId, exportedQueryMD5);
                        } else if (diff <= differenceList.size() && diff != 0) {
                            queryResultDto.addAll(differenceList.subList(0, diff));
                            exportHistoryRecordService.saveOutput(differenceList.subList(0, diff), memberId, exportedQueryMD5);
                            break;
                        }
                    }

                }
                step++;
                i = i + size;
                log.info("深度对比：i:" + i);
            }
        } catch (IOException e) {
            log.error("查询异常", e);
        }
        log.info("对比去重结束数据：" + queryResultDto.size());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        XSSFWorkbook workbook = converExcel(queryResultDto, repeatRecord);
        workbook.write(outputStream);
        //异步发送邮件
        generalTaskService.sendEmailAsyncExecutor(outputStream.toByteArray(), email);
        queryRecordService.uploadExcel(companyExportRecord, outputStream.toByteArray(), queryResultDto.size(), memberId, dto.getPageNo(), exportQueryVo.getKeyword(), PayUtils.generateNoncestr(16), email);
        if (queryResultDto.size() > 0) {
			List<CompanyExportHistory> historyRecords = queryResultDto.stream()
					.map(element -> new CompanyExportHistory().setCompanyId(element.getCompanyId())
							.setCreateTime(LocalDateTime.now()).setQueryConditionMd5(exportedQueryMD5)
							.setMemberId(memberId))
					.collect(Collectors.toList());
            exportHistoryRecordService.saveBatch(historyRecords);
        }
	}
    public XSSFWorkbook converExcel(List<SearchOutput> queryResult, int repeatRecord) throws IOException {
    	 InputStream fi = this.getClass().getClassLoader().getResourceAsStream("export/企业公示信息导出结果-威客智库.xlsx");

         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

         //--------------------------------------------------------
         Integer length = queryResult.size();
         XSSFWorkbook wb = new XSSFWorkbook(fi);
         XSSFSheet sheet = wb.getSheetAt(0);

         CellStyle cellStyle = wb.createCellStyle();
         cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
         cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
         cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
         cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);


         CellStyle cellTipStyle = wb.createCellStyle();
         cellTipStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
         cellTipStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
         cellTipStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
         cellTipStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
         cellTipStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中   
         cellTipStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中          
         XSSFFont font = wb.createFont();
         font.setFontName("微软雅黑");
         font.setFontHeightInPoints((short) 12);//设置字体大小
         cellTipStyle.setFont(font);

         XSSFRow rowTip = sheet.getRow(0);
         XSSFCell cellTip = rowTip.createCell(0);
         if (repeatRecord > 0) {
             // 创建提示字体
             XSSFFont ftRed = wb.createFont();
             ftRed.setFontName("微软雅黑");
             ftRed.setFontHeightInPoints((short) 12);// 设置字体大小
             ftRed.setColor(HSSFColor.RED.index);
             String sMainText = "企业公示信息导出结果-威客智库";
             String sTipText = "(本次有效导出数据为" + queryResult.size() + "条，已为您自动去重之前已导出的数量" + repeatRecord + "条)";
             String sText = sMainText + sTipText;
             int mianEndIndex = sMainText.length();
             XSSFRichTextString textString = new XSSFRichTextString(sText);
             textString.applyFont(0, mianEndIndex, font);
             textString.applyFont(sText.indexOf(sTipText), sText.indexOf(sTipText) + sTipText.length(), ftRed);

             cellTip.setCellValue(textString);
         } else {
             cellTip.setCellValue("企业公示信息导出结果-威客智库");
         }
         cellTip.setCellStyle(cellTipStyle);


         if (length == 0) {
             XSSFRow row = sheet.createRow(2);
             XSSFCell cell = row.createCell(0);
             cell.setCellValue("已无可导出数据");
             cell.setCellStyle(cellStyle);
         } else {
             for (int i = 0; i < queryResult.size(); i++) {
            	 SearchOutput query = queryResult.get(i);
                 XSSFRow row = sheet.createRow(i + 2);
                 row.createCell(0).setCellValue(i + 1);
                 row.createCell(1).setCellValue(query.getCompanyName());
                 row.createCell(2).setCellValue(query.getLegalPersonName());
                 row.createCell(3).setCellValue(query.getCreditCode());
                 row.createCell(4).setCellValue(query.getTelephone());
                 row.createCell(5).setCellValue(query.getEmail());
                 row.createCell(6).setCellValue(query.getWebsite());
                 row.createCell(7).setCellValue(query.getAddress());
                 row.forEach((Cell cell) -> cell.setCellStyle(cellStyle));
             }

         }
         for (int i = 0; i < sheet.getLastRowNum(); i++) {
             sheet.autoSizeColumn((short) i);
             sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10);
         }


         sheet.protectSheet(UUID.randomUUID().toString());
         return wb;
    }
	public List<String> cacheList(List<SearchOutput> queryResultList,
			List<String> longs) {
		if (queryResultList != null && queryResultList.size() > 0) {
			queryResultList.stream().forEach(action -> {
				longs.add(action.getCompanyId());
			});

		}
		return longs;
	}
}
