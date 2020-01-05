package org.easymis.easycrm.core.controller;

import org.easymis.easycrm.core.service.CompanyInvestorService;
import org.easymis.easycrm.core.service.CompanyService;
import org.easymis.easycrm.core.service.CompanyStaffService;
import org.easymis.easycrm.core.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * @author zh
 * @title: companyInvestorController
 * @projectName companydata
 * @description: 股东信息
 * @date 2019/7/17 10:12
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



    /*     @ApiOperation(value = "股东信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", dataType = "int", required = true)
    })
      @ApiResponses(@ApiResponse(code=0,message = "成功",response =CompanyInvestorOutputVo.class ))
    @GetMapping("/info")
    public SearchResult allInfo(@NotNull @Min(1) Long companyId) {
        SearchResult result = SearchResult.buildSuccess();
        List<CompanyInvestor> list = companyInvestorService.list(new LambdaQueryWrapper<CompanyInvestor>().eq(CompanyInvestor::getCompanyId, companyId));
        List<CompanyInvestorOutputDTO> outputList = new ArrayList<>();
        List<Long> humaninvestorIds = new ArrayList<>();
        List<Long> companyIds = new ArrayList<>();
        CompanyCleanInfo cleanInfo = companyCleanInfoService.getById(companyId);
        String type = "";
        if (Objects.isNull(cleanInfo) == false) {
            type = StringUtils.isEmpty(cleanInfo.getActualCapitalCurrency()) == false ? cleanInfo.getActualCapitalCurrency() : "人民币";
        }
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
            humans = humanService.list(new QueryWrapper<Human>().lambda().in(Human::getId, humaninvestorIds));
            staffs = companyStaffService.list(new QueryWrapper<CompanyStaff>().lambda().eq(CompanyStaff::getCompanyId, companyId).in(CompanyStaff::getStaffId, humaninvestorIds));

        }
        List<Company> companyList = new ArrayList<>();
        if (companyIds.size() > 0) {
            companyList = companyService.list(new QueryWrapper<Company>().lambda().in(Company::getId, companyIds));
        }

        for (CompanyInvestor companyInvestor : list) {
            CompanyInvestorOutputDTO entOut = new CompanyInvestorOutputDTO();
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
                        if (Objects.equals(company.getId(), companyInvestor.getInvestorId())) {
                            entOut.setName(company.getName());
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
        result.success(outputList);
        return result;


    }*/
}
