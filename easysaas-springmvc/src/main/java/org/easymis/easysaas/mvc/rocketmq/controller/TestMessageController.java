package org.easymis.easysaas.mvc.rocketmq.controller;

import java.math.BigDecimal;

import org.easymis.easysaas.mvc.rocketmq.domain.OrderPaidEvent;
import org.easymis.easysaas.mvc.rocketmq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMessageController {
	@Autowired
	private ProducerService producerService;	  
	  /**
	   * 
	   * @param price
	   * @return
	   * 顺锟斤拷锟斤拷息锟斤拷全锟斤拷顺锟斤拷锟斤拷息锟斤拷锟斤拷锟斤拷顺锟斤拷锟斤拷息锟斤拷
	   * 
	   * 全锟斤拷顺锟斤拷锟斤拷息锟斤拷要锟斤拷 证全锟斤拷顺锟斤拷锟斤拷息锟斤拷 锟斤拷要 锟饺帮拷 Topic 锟侥讹拷写锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷为 一锟斤拷然锟斤拷 Producer 锟斤拷 Consumer 锟侥诧拷锟斤拷锟斤拷锟斤拷也要锟斤拷一 锟斤拷
	   * 锟斤拷锟斤拷说锟斤拷为锟剿憋拷证锟斤拷锟斤拷 Topic 锟斤拷 全锟斤拷锟斤拷息锟斤拷锟斤拷只锟斤拷锟斤拷锟斤拷锟斤拷锟叫的诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街讹拷锟斤拷锟矫成碉拷锟竭程达拷锟斤拷 锟斤拷 锟斤拷时 锟竭诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟侥癸拷锟斤拷锟斤拷全锟矫诧拷锟斤拷锟斤拷 锟斤拷
	   * 锟斤拷锟斤拷顺锟斤拷锟斤拷息锟斤拷要锟斤拷证锟斤拷锟斤拷锟斤拷息锟斤拷锟斤拷锟斤拷要锟斤拷锟酵端猴拷锟斤拷锟窖讹拷锟斤拷洗锟斤拷锟� 锟斤拷 锟节凤拷锟酵端ｏ拷要锟斤拷锟斤拷 锟斤拷同一业锟斤拷 ID 锟斤拷锟斤拷息锟斤拷锟酵碉拷同一锟斤拷 Message Queue ;
	   * 锟斤拷锟斤拷锟窖癸拷锟斤拷锟叫ｏ拷要锟斤拷锟斤拷锟斤拷 同一锟斤拷 Message Queue 锟斤拷取锟斤拷锟斤拷息锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟杰达到锟斤拷锟斤拷锟斤拷锟斤拷 锟斤拷
	   * 
	   */
	  @RequestMapping(value="/test/rocketorder",method=RequestMethod.GET)
	  public String sendOrdermessage(double price){
		    OrderPaidEvent orderpaidEvent = new OrderPaidEvent("T001", BigDecimal.valueOf(price));
		    producerService.asyncSendOrderMessage(orderpaidEvent);
	    return "OK";
	  }
}
