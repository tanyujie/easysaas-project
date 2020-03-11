package org.easymis.easysaas.mvc.rocketmq.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.easymis.easysaas.mvc.rocketmq.domain.OrderPaidEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	@Autowired(required=false)
	DefaultMQProducer defaultMQProduce;
	@Value("${rocketmq.transTopic}")
	private String springTransTopic;
	@Value("${rocketmq.topic}")
	private String springTopic;
	@Value("${rocketmq.orderTopic}")
	private String orderPaidTopic;
	@Value("${rocketmq.msgExtTopic}")
	private String msgExtTopic;

	public void asyncSendOrderMessage(OrderPaidEvent orderPaidEvent) {
		Message msg= new Message();
		msg.setTopic("BenchmarkTest");
		msg.setTags("push");
		try {
			msg.setBody("OK".getBytes());
			SendResult sr=defaultMQProduce.send(msg);
			System.out.print(sr);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
