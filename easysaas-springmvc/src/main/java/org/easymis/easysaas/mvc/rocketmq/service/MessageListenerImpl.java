package org.easymis.easysaas.mvc.rocketmq.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;



public class MessageListenerImpl implements MessageListenerConcurrently {


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        for (MessageExt messageExt : msgs) {
            System.out.println(messageExt);
            try {
                String body = new String(messageExt.getBody(), "UTF-8");
                System.out.println(body);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //System.out.println(messageExt.toString());
            //System.out.println(new String(messageExt.getBody()));
        }     
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
