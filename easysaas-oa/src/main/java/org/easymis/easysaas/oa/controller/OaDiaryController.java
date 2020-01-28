package org.easymis.easysaas.oa.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.easymis.easysaas.oa.entitys.mybatis.dto.OaDiary;
import org.easymis.easysaas.oa.service.OaDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.sharepanzer.companydata.common.result.RestResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "日报管理")
@RequestMapping("oaDiary")
@RestController
@Validated
public class OaDiaryController {



	@Autowired
	private OaDiaryService service;
	

	@ApiOperation(value = "保存日报信息", notes = "保存日报信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/save" }, method = { RequestMethod.POST })
	public RestResult save(OaDiary bean) {
		RestResult restResult = new RestResult();
		try {
			service.save(bean);
		} catch (RuntimeException e) {
			e.printStackTrace();
			restResult.fail(e.getMessage());
		}
		return restResult.success();

	}

	@ApiOperation(value = "修改日报信息", notes = "修改日报信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/update" }, method = { RequestMethod.POST })
	public RestResult update(OaDiary bean) {
		RestResult restResult = new RestResult();
		try {
			service.update(bean);
		} catch (RuntimeException e) {
			e.printStackTrace();
			restResult.fail(e.getMessage());
		}
		return restResult.success();

	}

	@ApiOperation(value = "删除日报信息", notes = "删除日报信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({ @ApiImplicitParam(name = "ids", value = "日报id", required = true, dataType = "String[]") })
	@RequestMapping(value = { "/delete" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult delete(@RequestParam(value="ids") List<String> ids) {
		RestResult restResult = new RestResult();
		try {
			service.deleteBatch(ids);
		} catch (RuntimeException e) {
			e.printStackTrace();
			restResult.fail(e.getMessage());
		}
		return restResult.success();

	}

	@ApiOperation(value = "获取日报信息", notes = "获取日报信息", httpMethod = "POST",response = OaDiary.class, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "日报id", required = true, dataType = "String") })
	@RequestMapping(value = { "/get" }, method = { RequestMethod.GET })
	public RestResult findById(String id) {
		RestResult restResult = new RestResult();
		try {
			service.findById(id);
		} catch (RuntimeException e) {
			e.printStackTrace();
			restResult.fail(e.getMessage());
		}
		return restResult.success();

	}

	@ApiOperation(value = "获取日报列表信息", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/getList.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult getList(OaDiary bean) {
		RestResult restResult = new RestResult();
		try {
			List<OaDiary> list = service.getList(bean);
			restResult.success(list);
		} catch (RuntimeException e) {
			e.printStackTrace();
			restResult.fail(e.getMessage());
		}

		return restResult;

	}
	@ApiOperation(value = "获取分页日报列表信息", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/getListByCompanyId.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult getListByCompanyId(@NotNull Long companyId) {
		RestResult restResult = new RestResult();
		try {
			OaDiary bean= new OaDiary();
			//bean.setCompanyId(companyId.toString());
			List<OaDiary> list = service.getList(bean);
			restResult.success(list);
		} catch (RuntimeException e) {
			e.printStackTrace();
			restResult.fail(e.getMessage());
		}

		return restResult;

	}
	@ApiOperation(value = "获取分页日报列表信息", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "categoryId", value = "Id", dataType = "String", required = false),
	})
	@RequestMapping(value = { "/findByPage" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult findByPage(OaDiary bean) {
		RestResult restResult = new RestResult();
		try {
			PageInfo<?> pageInfo = service.findByPage(bean);
			restResult.success(pageInfo);
		} catch (RuntimeException e) {
			e.printStackTrace();
			restResult.fail(e.getMessage());
		}

		return restResult;

	}



}
