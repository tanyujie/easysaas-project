package org.easymis.easysaas.rocketmq.service;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(topic = "${rocketmq.transTopic}", consumerGroup = "string_trans_consumer")
public class StringTransactionalConsumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.printf("------- StringTransactionalConsumer received: %s \n", message);
    }
}
