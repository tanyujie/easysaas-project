package org.easymis.easysaas.mvc.rocketmq.service;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
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
			//同步发送:Producer 向 broker 发送消息，阻塞当前线程等待 broker 响应 发送结果
			SendResult sr=defaultMQProduce.send(msg);
			
			
			 Message msg2 = new Message("Jodie_topic_1023",
	                    "TagA",
	                    "OrderID188",
	                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
			 //2、异步发送;Producer 首先构建一个向 broker 发送消息的任务，把该任务提交给线程池，等执行完该任务时，回调用户自定义的回调函数，执行处理结果。
			defaultMQProduce.send(msg2, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", 1, sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", 1, e);
                    e.printStackTrace();
                }
			});
			System.out.print(sr);
			//Oneway 发送; Oneway 方式只负责发送请求，不等待应答，Producer 只负责把请求发出去，而不处理响应结果。
			defaultMQProduce.sendOneway(msg2);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
