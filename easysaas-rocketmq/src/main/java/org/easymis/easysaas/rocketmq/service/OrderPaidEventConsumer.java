package org.easymis.easysaas.rocketmq.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.easymis.easysaas.rocketmq.domain.OrderPaidEvent;
import org.springframework.stereotype.Service;

/**
 * 

 * 传送对象的类
 */
@Service
@RocketMQMessageListener(topic = "${rocketmq.orderTopic}", consumerGroup = "order-paid-consumer")
public class OrderPaidEventConsumer implements RocketMQListener<OrderPaidEvent>{

  @Override
  public void onMessage(OrderPaidEvent message) {
    System.out.printf("------- OrderPaidEventConsumer received: %s \n", message);
  }

}
