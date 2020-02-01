package org.easymis.easysaas.portal.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.easymis.easysaas.common.result.SearchResult;
import org.easymis.easysaas.portal.entitys.mybatis.dto.AnnualReport;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Company;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyInvestor;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyStaff;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Human;
import org.easymis.easysaas.portal.entitys.mybatis.dto.ReportShareholder;
import org.easymis.easysaas.portal.entitys.vo.CompanyInvestorOto;
import org.easymis.easysaas.portal.service.AnnualReportService;
import org.easymis.easysaas.portal.service.CompanyInvestorService;
import org.easymis.easysaas.portal.service.CompanyService;
import org.easymis.easysaas.portal.service.CompanyStaffService;
import org.easymis.easysaas.portal.service.HumanService;
import org.easymis.easysaas.portal.service.ReportChangeRecordService;
import org.easymis.easysaas.portal.service.ReportEquityChangeInfoService;
import org.easymis.easysaas.portal.service.ReportShareholderService;
import org.springframework.beans.BeanUtils;
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

/**
 * 
　 * <p>Title: 股东信息</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年1月29日
 */
@Api(description = "股东信息相关接口")
@Validated
@RequestMapping("/companyInvestor")
@RestController
public class CompanyInvestorController {
    @Autowired
    private CompanyInvestorService companyInvestorService;
    @Autowired
    private CompanyStaffService companyStaffService;
    @Autowired
    private HumanService humanService;
    @Autowired
    private CompanyService companyService;

    
    @Autowired
    AnnualReportService annualReportService;
    @Autowired
    ReportChangeRecordService changeRecordService;
    @Autowired
    ReportShareholderService reportShareholderService;
    
    @Autowired
    ReportEquityChangeInfoService reportEquityChangeInfoService;
    
    @ApiOperation(value = "股东信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "string"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "string")
    })
    @ApiResponses(@ApiResponse(code=0,message = "成功",response =CompanyInvestorOto.class ))
    @GetMapping("/info")
    public SearchResult allInfo(@NotNull @Min(1) String companyId,Integer pageNum ,Integer pageSize) {
        SearchResult result = SearchResult.buildSuccess();
        pageNum = Objects.isNull(pageNum)?1:pageNum;
        pageSize = Objects.isNull(pageSize)?5:pageSize;
             Page page =new Page(pageNum,pageSize);
        PageInfo pageInfo=companyInvestorService.getPage(page, companyId);
        List<CompanyInvestor> list = pageInfo.getList();
        List<CompanyInvestorOto> outputList = new ArrayList<>();
        List<String> humaninvestorIds = new ArrayList<>();
        List<String> companyIds = new ArrayList<>();
        String type = "人民币";

        for (CompanyInvestor investor : list) {
            if (Objects.nonNull(investor.getInvestorType())) {
                if (Objects.equals(investor.getInvestorType(), 1)) {
                    humaninvestorIds.add(investor.getInvestorId());
                } else if (Objects.equals(investor.getInvestorType(), 2)) {
                    companyIds.add(investor.getInvestorId());
                }
            }
        }
        List<Human> humans = new ArrayList<>();
        List<CompanyStaff> staffs = new ArrayList<>();
        if (humaninvestorIds.size() > 0) {
            humans = humanService.list(humaninvestorIds);
            staffs=companyStaffService.findList(companyId, humaninvestorIds);
       
        }
        List<Company> companyList = new ArrayList<>();
        if (companyIds.size() > 0) {
            companyList = companyService.findByIds(companyIds);
        }

        for (CompanyInvestor companyInvestor : list) {
            CompanyInvestorOto entOut = new CompanyInvestorOto();
            BeanUtils.copyProperties(companyInvestor, entOut);
            if (Objects.nonNull(companyInvestor.getInvestorType())) {
            	DecimalFormat df =new DecimalFormat("#");            	
                if (Objects.equals(companyInvestor.getInvestorType(), 1)) {
                    for (Human human : humans) {
                        if (Objects.equals(human.getId(), companyInvestor.getInvestorId())) {
                            entOut.setName(human.getName());
                            break;
                        }

                    }
                    for (CompanyStaff staff : staffs) {
                        if (Objects.equals(staff.getId(), companyInvestor.getInvestorId())) {
                            entOut.setPosition(staff.getStaffTypeName());
                            break;
                        }
                    }

                    String amountStr = Objects.isNull(entOut.getAmount()) ? "" : df.format(entOut.getAmount()) + "万";
                    entOut.setAmountStr(new StringBuilder().append(amountStr).append(type).toString());
                } else if (Objects.equals(companyInvestor.getInvestorType(), 2)) {
                    for (Company company : companyList) {
                        if (Objects.equals(company.getCompanyId(), companyInvestor.getInvestorId())) {
                            entOut.setName(company.getCompanyName());
                            entOut.setPosition("公司");
                            String amountStr = Objects.isNull(entOut.getAmount()) ? "" : df.format(entOut.getAmount()) + "万";
                            entOut.setAmountStr(new StringBuilder().append(amountStr).append(type).toString());
                            break;
                        }
                    }
                }
            }
            outputList.add(entOut);
        }
        pageInfo.setList(outputList);
        result.success(pageInfo);
        return result;

    }
    

    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业id", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageNum", value = "页数", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页显示个数", dataType = "int", required = true)
    })
/*    @ApiOperation("查询企业年报")
    @GetMapping("queryAnnualReport")
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功", response = AnnualReport.class)
    })*/
    public SearchResult getAnnualReport(@NotNull String companyId,Integer pageNum ,Integer pageSize) {
        //bugBUG #576 企业信息，年报接口，接口中未返回企业注册号 - 黄金眼new||功能优化侧分接口，报表和报表明细侧分开；取基本信息接口
        pageNum = Objects.isNull(pageNum)?1:pageNum;
        pageSize = Objects.isNull(pageSize)?1:pageSize;
             Page page =new Page(pageNum,pageSize);
        PageInfo<AnnualReport> pageInfo=annualReportService.getPage(page, companyId);
        List<AnnualReport> annualReports =pageInfo.getList();
        if (annualReports.size() > 0) {
        	//企业基本信息
/*            List<Long> companyIds = annualReports.stream().map(annualReport -> annualReport.getCompanyId()).collect(Collectors.toList());           
            List<Company> sompanyList = companyService.list(companyIds);
            sompanyList.stream().forEach(company -> {
                for (AnnualReport report : annualReports) {
                    Long vCompanyId = report.getCompanyId();
                    if (Objects.equals(company.getId(), vCompanyId)) {
                    	report.setRegNumber(company.getRegNumber());
                    }
                }
            });*/
            
            List<String> annualReportIds = annualReports.stream().map(annualReport -> annualReport.getId()).collect(Collectors.toList());




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




        }
        return SearchResult.buildSuccess(annualReports.get(0).getReportShareholders());
    }
}
