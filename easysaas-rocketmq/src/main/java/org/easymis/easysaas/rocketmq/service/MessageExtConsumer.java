package org.easymis.easysaas.rocketmq.service;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

/**
 * 截取指定的tag的消息数据
 */
@Service
@RocketMQMessageListener(topic = "message-ext-topic", selectorExpression = "tag1", consumerGroup = "${spring.application.name}-message-ext-consumer")
public class MessageExtConsumer implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener{

  @Override
  public void prepareStart(DefaultMQPushConsumer consumer) {
    // TODO Auto-generated method stub
    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
    consumer.setConsumeTimestamp(UtilAll.timeMillisToHumanString3(System.currentTimeMillis()));
  }

  @Override
  public void onMessage(MessageExt message) {
    System.out.printf("------------message msgId :%s,  body:%s \n",message.getMsgId(),new String(message.getBody()));
  }

}
