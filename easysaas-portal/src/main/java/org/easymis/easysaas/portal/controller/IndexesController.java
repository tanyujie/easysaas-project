package org.easymis.easysaas.portal.controller;

import org.easymis.easysaas.portal.config.ElasticSearchConfig;
import org.easymis.easysaas.portal.service.BulkProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "索引文件管理接口")
@Validated
@Slf4j
@Controller
@RequestMapping("/indexes")
public class IndexesController {
    @Autowired
    private BulkProcessService bulkProcessService;
    @RequestMapping("/dishonest/insert/all")
    public String insertAll() {
    	bulkProcessService.writeDishonestIndex(ElasticSearchConfig.INDEX_NAME_DISHONEST);
        return "OK";
    }
}
