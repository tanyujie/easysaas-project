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
  /**
   * 
   * @param text
   * @return
   * 文本消息，同步发送，异步发送
   */
  @RequestMapping(value="/rockettext",method=RequestMethod.POST)
  public String sendTextmessage(String text){
    producerService.sendMessage(text);
    producerService.asyncSendMessage(text);
    return "发送成功";
  }
  /**
   * 
   * @param price
   * @return
   * 顺序消息（全局顺序消息，部分顺序消息）
   * 
   * 全局顺序消息：要保 证全局顺序消息， 需要 先把 Topic 的读写队列数设置为 一，然后 Producer 和 Consumer 的并发设置也要是一 ；
   * 简单来说，为了保证整个 Topic 的 全局消息有序，只能消除所有的并发处理，各部分都设置成单线程处理 。 这时 高并发、高吞吐量的功能完全用不上了 。
   * 部分顺序消息：要保证部分消息有序，需要发送端和消费端配合处理 。 在发送端，要做到 把同一业务 ID 的消息发送到同一个 Message Queue ;
   * 在消费过程中，要做到从 同一个 Message Queue 读取的消息不被并发处理，这样才能达到部分有序 。
   * 
   */
  @RequestMapping(value="/rocketorder",method=RequestMethod.POST)
  public String sendOrdermessage(double price){
    OrderPaidEvent orderpaidEvent = new OrderPaidEvent("T001", BigDecimal.valueOf(price));
    producerService.asyncSendOrderMessage(orderpaidEvent);
    return "发送成功";
  }
  
  /**
   * 
   * @param text
   * @return
   * 
   * 
   */
  @RequestMapping(value="/rocketmsgext",method=RequestMethod.POST)
  public String sendExtTextmessage(String text){
    producerService.convertAndSendMessage(text);
    return "发送成功";
  }
  
  /**
   * 
   * @param tags
   * @return
   * 
   * 
   */
  @RequestMapping(value="/rockettransaction",method=RequestMethod.POST)
  public String sendTransactionTextmessage(String[] tags){
    producerService.testTransaction(tags);
    return "发送成功";
  }
}