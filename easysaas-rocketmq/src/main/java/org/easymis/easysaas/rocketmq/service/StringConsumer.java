package org.easymis.easysaas.rocketmq.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 消费者:消费者需要实现RocketMQListener<T>
 *
 */
@Service
@RocketMQMessageListener(topic = "${rocketmq.topic}", consumerGroup = "string_consumer")
public class StringConsumer implements RocketMQListener<String> {
	@Override
	public void onMessage(String message) {
		System.out.printf("------- StringConsumer received: %s \n", message);
	}
}