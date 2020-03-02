package org.easymis.easysaas.crm.controller.crm;

import org.easymis.easysaas.crm.service.CrmAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * 
　 * <p>Title: 客户预约</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年2月21日
 */
@Api(description = "客户预约")
@Controller
@Validated
@Slf4j
public class CrmAppointmentController {
	@Autowired
	CrmAppointmentService appointmentService;
}
