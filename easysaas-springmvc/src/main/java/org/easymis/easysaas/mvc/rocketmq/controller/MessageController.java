package org.easymis.easysaas.mvc.rocketmq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	 /**
	   * 
	   * @param text
	   * @return
	   * 文本消息，同步发送，异步发送
	   */
	  @RequestMapping(value="/rockettext",method = {RequestMethod.POST,RequestMethod.GET})
	  public String sendTextmessage(String text){
	   //producerService.sendMessage(text);
	    //producerService.asyncSendMessage(text);
	    return "发送成功";
	  }
}
