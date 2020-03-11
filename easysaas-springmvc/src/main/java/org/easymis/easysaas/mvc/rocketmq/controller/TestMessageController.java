package org.easymis.easysaas.mvc.rocketmq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMessageController {
	  
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
	  @RequestMapping(value="/test/rocketorder",method=RequestMethod.POST)
	  public String sendOrdermessage(double price){

	    return "OK";
	  }
}
