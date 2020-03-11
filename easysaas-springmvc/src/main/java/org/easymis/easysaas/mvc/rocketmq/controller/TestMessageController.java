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
	   * ˳����Ϣ��ȫ��˳����Ϣ������˳����Ϣ��
	   * 
	   * ȫ��˳����Ϣ��Ҫ�� ֤ȫ��˳����Ϣ�� ��Ҫ �Ȱ� Topic �Ķ�д����������Ϊ һ��Ȼ�� Producer �� Consumer �Ĳ�������ҲҪ��һ ��
	   * ����˵��Ϊ�˱�֤���� Topic �� ȫ����Ϣ����ֻ���������еĲ������������ֶ����óɵ��̴߳��� �� ��ʱ �߲��������������Ĺ�����ȫ�ò����� ��
	   * ����˳����Ϣ��Ҫ��֤������Ϣ������Ҫ���Ͷ˺����Ѷ���ϴ��� �� �ڷ��Ͷˣ�Ҫ���� ��ͬһҵ�� ID ����Ϣ���͵�ͬһ�� Message Queue ;
	   * �����ѹ����У�Ҫ������ ͬһ�� Message Queue ��ȡ����Ϣ�������������������ܴﵽ�������� ��
	   * 
	   */
	  @RequestMapping(value="/test/rocketorder",method=RequestMethod.POST)
	  public String sendOrdermessage(double price){
		    OrderPaidEvent orderpaidEvent = new OrderPaidEvent("T001", BigDecimal.valueOf(price));
		    producerService.asyncSendOrderMessage(orderpaidEvent);
	    return "OK";
	  }
}
