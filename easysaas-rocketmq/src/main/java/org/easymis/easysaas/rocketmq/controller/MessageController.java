package org.easymis.easysaas.rocketmq.controller;

import java.math.BigDecimal;

import org.easymis.easysaas.rocketmq.domain.OrderPaidEvent;
import org.easymis.easysaas.rocketmq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
  @Autowired
  private ProducerService producerService;
  
  @RequestMapping(value="/rockettext",method=RequestMethod.POST)
  public String sendTextmessage(String text){
    producerService.sendMessage(text);
    producerService.asyncSendMessage(text);
    return "发送成功";
  }
  
  @RequestMapping(value="/rocketorder",method=RequestMethod.POST)
  public String sendOrdermessage(double price){
    OrderPaidEvent orderpaidEvent = new OrderPaidEvent("T001", BigDecimal.valueOf(price));
    producerService.asyncSendOrderMessage(orderpaidEvent);
    return "发送成功";
  }
  
  @RequestMapping(value="/rocketmsgext",method=RequestMethod.POST)
  public String sendExtTextmessage(String text){
    producerService.convertAndSendMessage(text);
    return "发送成功";
  }
  
  @RequestMapping(value="/rockettransaction",method=RequestMethod.POST)
  public String sendTransactionTextmessage(String[] tags){
    producerService.testTransaction(tags);
    return "发送成功";
  }
}