package org.easymis.easysaas.portal.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.easymis.easysaas.common.result.SearchResult;
import org.easymis.easysaas.portal.entitys.mybatis.dto.AnnualReport;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Company;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportChangeRecord;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportEquityChangeInfo;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportOutGuaranteeInfo;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportOutboundInvestment;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportShareholder;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportSocialSecurityInfo;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportWebinfo;
import org.easymis.easysaas.portal.service.AnnualReportService;
import org.easymis.easysaas.portal.service.CompanyService;
import org.easymis.easysaas.portal.service.ReportChangeRecordService;
import org.easymis.easysaas.portal.service.ReportEquityChangeInfoService;
import org.easymis.easysaas.portal.service.ReportOutGuaranteeInfoService;
import org.easymis.easysaas.portal.service.ReportOutboundInvestmentService;
import org.easymis.easysaas.portal.service.ReportShareholderService;
import org.easymis.easysaas.portal.service.ReportSocialSecurityInfoService;
import org.easymis.easysaas.portal.service.ReportWebinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "企业年报")
@RequestMapping("annualReport")
@RestController
@Validated
public class AnnualReportController {

	@Autowired
	private CompanyService companyService;
    @Autowired
    AnnualReportService annualReportService;

    @Autowired
    ReportChangeRecordService changeRecordService;

    @Autowired
    ReportEquityChangeInfoService reportEquityChangeInfoService;

    @Autowired
    ReportOutGuaranteeInfoService reportOutGuaranteeInfoService;

    @Autowired
    ReportOutboundInvestmentService investmentService;

    @Autowired
    ReportShareholderService reportShareholderService;

    @Autowired
    ReportSocialSecurityInfoService socialSecurityInfoService;

    @Autowired
    ReportOutGuaranteeInfoService guaranteeInfoService;

    @Autowired
    ReportWebinfoService webinfoService;


    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业id", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示个数", dataType = "int", required = true)
    })
    @ApiOperation("查询企业年报")
    @GetMapping("queryAnnualReport")
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功", response = AnnualReport.class)
    })
    public SearchResult getAnnualReport(@NotNull String companyId,Integer pageNum ,Integer pageSize) {
        pageNum = Objects.isNull(pageNum)?1:pageNum;
        pageSize = Objects.isNull(pageSize)?5:pageSize;
             Page page =new Page(pageNum,pageSize);
        PageInfo<AnnualReport> pageInfo=annualReportService.getPage(page, companyId);
        List<AnnualReport> annualReports =pageInfo.getList();
        if (annualReports.size() > 0) {
        	//企业基本信息
            List<String> companyIds = annualReports.stream().map(annualReport -> annualReport.getCompanyId()).collect(Collectors.toList());           
            List<Company> sompanyList = companyService.findByIds(companyIds);
            sompanyList.stream().forEach(company -> {
                for (AnnualReport report : annualReports) {
                    String vCompanyId = report.getCompanyId();
                    if (Objects.equals(company.getId(), vCompanyId)) {
                    	report.setRegNumber(company.getRegNumber());
                    }
                }
            });
            
            List<String> annualReportIds = annualReports.stream().map(annualReport -> annualReport.getId()).collect(Collectors.toList());
            // 企业变更信息
          //  IPage<ReportChangeRecord> reportChangeRecordPage = new Page<ReportChangeRecord>(pageNum, pageSize);
            List<ReportChangeRecord> records = changeRecordService.listByAnnualreportId(annualReportIds);// bug changeRecordService.list(new QueryWrapper<ReportChangeRecord>().lambda().in(ReportChangeRecord::getAnnualreportId, annualReportIds));
            records.stream().forEach(reportChangeRecord -> {
                for (AnnualReport report : annualReports) {
                    String annualId = report.getId();
                    if (Objects.equals(reportChangeRecord.getAnnualreportId(), annualId)) {
                        List<ReportChangeRecord> recordList = report.getReportChangeRecords();
                        if (Objects.isNull(recordList)) {
                            recordList = new ArrayList();
                            recordList.add(reportChangeRecord);
                            report.setReportChangeRecords(recordList);
                        } else {
                            recordList.add(reportChangeRecord);
                        }
                        break;
                    }
                }
            });
            // 年报股权变更
            List<ReportEquityChangeInfo> infos = reportEquityChangeInfoService.listByAnnualreportId(annualReportIds);// bug reportEquityChangeInfoService.list(new QueryWrapper<ReportEquityChangeInfo>().lambda().in(ReportEquityChangeInfo::getAnnualreportId, annualReportIds));
            infos.stream().forEach(reportEquityChangeInfo -> {
                for (AnnualReport report : annualReports) {
                    String annualId = report.getId();
                    if (Objects.equals(reportEquityChangeInfo.getAnnualreportId(), annualId)) {
                        List<ReportEquityChangeInfo> changeInfos = report.getReportEquityChangeInfos();
                        if (Objects.isNull(changeInfos)) {
                            changeInfos = new ArrayList();
                            changeInfos.add(reportEquityChangeInfo);
                            report.setReportEquityChangeInfos(changeInfos);
                        } else {
                            changeInfos.add(reportEquityChangeInfo);
                        }
                        break;
                    }
                }
            });
            // 年报对外投资
            List<ReportOutboundInvestment> outboundInvestmentList =investmentService.listByAnnualReportId(annualReportIds);// investmentService.list(new QueryWrapper<ReportOutboundInvestment>().lambda().in(ReportOutboundInvestment::getAnnualReportId, annualReportIds));
            outboundInvestmentList.stream().forEach(investment -> {
                for (AnnualReport report : annualReports) {
                    String annualId = report.getId();
                    if (Objects.equals(investment.getAnnualReportId(), annualId)) {
                        List<ReportOutboundInvestment> outboundInvestments = report.getReportOutboundInvestments();
                        if (Objects.isNull(outboundInvestments)) {
                            outboundInvestments = new ArrayList();
                            outboundInvestments.add(investment);
                            report.setReportOutboundInvestments(outboundInvestments);
                        } else {
                            outboundInvestments.add(investment);
                        }
                        break;
                    }
                }
            });

            //年报股东及出资信息
            List<ReportShareholder> shareholders = reportShareholderService.listByAnnualReportId(annualReportIds);// bug reportShareholderService.list(new QueryWrapper<ReportShareholder>().lambda().in(ReportShareholder::getAnnualReportId, annualReportIds));
            shareholders.stream().forEach(reportShareholder -> {
                for (AnnualReport report : annualReports) {
                    String annualId = report.getId();
                    if (Objects.equals(reportShareholder.getAnnualReportId(), annualId)) {
                        List<ReportShareholder> reportShareholders = report.getReportShareholders();
                        if (Objects.isNull(reportShareholders)) {
                            reportShareholders = new ArrayList();
                            reportShareholders.add(reportShareholder);
                            report.setReportShareholders(reportShareholders);
                        } else {
                            reportShareholders.add(reportShareholder);
                        }
                        break;
                    }
                }
            });

            //年报社保信息
            List<ReportSocialSecurityInfo> socialSecurityInfoList = socialSecurityInfoService.listByAnnaulreportId(annualReportIds);//bug socialSecurityInfoService.list(new QueryWrapper<ReportSocialSecurityInfo>().lambda().in(ReportSocialSecurityInfo::getAnnaulreportId, annualReportIds));
            socialSecurityInfoList.stream().forEach(socialSecurityInfo -> {
                for (AnnualReport report : annualReports) {
                    String annualId = report.getId();
                    if (Objects.equals(socialSecurityInfo.getAnnaulreportId(), annualId)) {
                        List<ReportSocialSecurityInfo> socialSecurityInfos = report.getReportSocialSecurityInfos();
                        if (Objects.isNull(socialSecurityInfos)) {
                            socialSecurityInfos = new ArrayList();
                            socialSecurityInfos.add(socialSecurityInfo);
                            report.setReportSocialSecurityInfos(socialSecurityInfos);
                        } else {
                            socialSecurityInfos.add(socialSecurityInfo);
                        }
                        break;
                    }
                }
            });

            //年报对外担保
            List<ReportOutGuaranteeInfo> guaranteeInfoList =guaranteeInfoService.listByAnnualreportId(annualReportIds) ;// bug guaranteeInfoService.list(new QueryWrapper<ReportOutGuaranteeInfo>().lambda().in(ReportOutGuaranteeInfo::getAnnualreportId, annualReportIds));
            guaranteeInfoList.stream().forEach(reportOutGuaranteeInfo -> {
                for (AnnualReport report : annualReports) {
                    String annualId = report.getId();
                    if (Objects.equals(reportOutGuaranteeInfo.getAnnualreportId(), annualId)) {
                        List<ReportOutGuaranteeInfo> guaranteeInfos = report.getReportOutGuaranteeInfos();
                        if (Objects.isNull(guaranteeInfos)) {
                            guaranteeInfos = new ArrayList();
                            guaranteeInfos.add(reportOutGuaranteeInfo);
                            report.setReportOutGuaranteeInfos(guaranteeInfos);
                        } else {
                            guaranteeInfos.add(reportOutGuaranteeInfo);
                        }
                        break;
                    }
                }
            });

            //网站网店

            List<ReportWebinfo> reportWebinfoList = webinfoService.listByAnnualreportId(annualReportIds);//webinfoService.list(new QueryWrapper<ReportWebinfo>().lambda().in(ReportWebinfo::getAnnualreportId, annualReportIds));
            reportWebinfoList.stream().forEach(reportWebinfo -> {
                for (AnnualReport report : annualReports) {
                    String annualId = report.getId();
                    if (Objects.equals(reportWebinfo.getAnnualreportId(), annualId)) {
                        List<ReportWebinfo> webinfos = report.getReportWebinfos();
                        if (Objects.isNull(webinfos)) {
                            webinfos = new ArrayList();
                            webinfos.add(reportWebinfo);
                            report.setReportWebinfos(webinfos);
                        } else {
                            webinfos.add(reportWebinfo);
                        }
                        break;
                    }
                }
            });


        }
		annualReports.stream().forEach(annualReport -> {
			if (annualReport.getReportChangeRecords() == null) {
				annualReport.setReportChangeRecords(new ArrayList<ReportChangeRecord>());
			}
			if (annualReport.getReportEquityChangeInfos() == null) {
				annualReport.setReportEquityChangeInfos(new ArrayList<ReportEquityChangeInfo>());
			}
			if (annualReport.getReportOutboundInvestments() == null) {
				annualReport.setReportOutboundInvestments(new ArrayList<ReportOutboundInvestment>());

			}
			if (annualReport.getReportOutGuaranteeInfos() == null) {
				annualReport.setReportOutGuaranteeInfos(new ArrayList<ReportOutGuaranteeInfo>());

			}
			if (annualReport.getReportShareholders() == null) {
				annualReport.setReportShareholders(new ArrayList<ReportShareholder>());

			}
			if (annualReport.getReportSocialSecurityInfos() == null) {
				annualReport.setReportSocialSecurityInfos(new ArrayList<ReportSocialSecurityInfo>());

			}
			if (annualReport.getReportWebinfos() == null) {
				annualReport.setReportWebinfos(new ArrayList<ReportWebinfo>());
			}

		});
 
        return SearchResult.buildSuccess(annualReports);
    }
}
