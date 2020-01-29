package org.easymis.easysaas.portal.controller;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.easymis.easysaas.common.result.SearchResult;
import org.easymis.easysaas.portal.service.SoftwareCopyrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.sharepanzer.companydata.core.entitys.mybatis.dto.SoftwareCopyright;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "软件著作权")
@Validated
@RequestMapping("/softwareCopyright")
@RestController
public class SoftwareCopyrightController {
	@Autowired
	private SoftwareCopyrightService companyService;

	@ApiOperation(value = "软件著作权", response = SoftwareCopyright.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "companyId", value = "公司id", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageNum", value = "页码", required = false, dataType = "string"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "string")
	})
	@GetMapping("/getPage")
	public SearchResult info(@NotNull String companyId, Integer pageNum, Integer pageSize) {
		pageNum = Objects.isNull(pageNum) ? 1 : pageNum;
		pageSize = Objects.isNull(pageSize) ? 10 : pageSize;
		Page page = new Page(pageNum, pageSize);
		SearchResult result = SearchResult.buildSuccess();
		PageInfo staffPageInfo = companyService.findByPage(companyId, pageNum, pageSize);
		result.success(staffPageInfo);
		return result;
	}
}
