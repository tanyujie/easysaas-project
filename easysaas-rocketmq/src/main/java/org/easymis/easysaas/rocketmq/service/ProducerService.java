package org.easymis.easysaas.rocketmq.service;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.easymis.easysaas.rocketmq.domain.OrderPaidEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * 
 Producer:生产者
 *
 */
@Service
public class ProducerService {
  @Autowired
  private RocketMQTemplate rocketMQTemplate;
  @Value("${rocketmq.transTopic}")
  private String springTransTopic;
  @Value("${rocketmq.topic}")
  private String springTopic;
  @Value("${rocketmq.orderTopic}")
  private String orderPaidTopic;
  @Value("${rocketmq.msgExtTopic}")
  private String msgExtTopic;
  private static final String TX_PGROUP_NAME = "myTxProducerGroup";
  
  public void sendMessage(String text){
    SendResult sendResult = rocketMQTemplate.syncSend(springTopic, text);
    System.out.printf("syncSend1 to topic %s sendResult=%s %n", springTopic, sendResult);
  }
  
  public void asyncSendMessage(String text){
    SendResult sendResult = rocketMQTemplate.syncSend(springTopic, MessageBuilder.withPayload(text + " from text message").build());
    System.out.printf("syncSend2 to topic %s sendResult=%s %n", springTopic, sendResult);
  }
  
  public void asyncSendOrderMessage(OrderPaidEvent orderPaidEvent){
    rocketMQTemplate.asyncSend(orderPaidTopic, orderPaidEvent, new SendCallback() {
      
      @Override
      public void onSuccess(SendResult sendResult) {
        System.out.printf("async onSucess SendResult=%s %n", sendResult);
      }
      
      @Override
      public void onException(Throwable e) {
        //或者其他重试操作
        System.out.printf("async onException Throwable=%s %n", e);
      }
    });
  }
  
  /**
   * 配置tag方式发送数据
   * @param text
   */
  public void convertAndSendMessage(String text){
    rocketMQTemplate.convertAndSend(msgExtTopic + ":tag0", "I'm from tag0 " + text);
    rocketMQTemplate.convertAndSend(msgExtTopic + ":tag1", "I'm from tag1 " + text);
  }
  
  public void testTransaction(String[] tags) {
    for(int i=0;i<10;i++){
      Message msg = MessageBuilder.withPayload("rocketmq ni hao " + i).setHeader(RocketMQHeaders.KEYS,"KEYS_" + i).build();
      //SendResult sendResult=rocketMQTemplate.sendMessageInTransaction(springTransTopic+":"+tags[i%tags.length], msg, null);
      SendResult sendResult = rocketMQTemplate.sendMessageInTransaction(TX_PGROUP_NAME, springTransTopic+":"+tags[i%tags.length], msg, null);
      
      System.out.printf("------ send Transactional msg body = %s , sendResult=%s %n",
          msg.getPayload(), sendResult.getSendStatus());
    //  public TransactionSendResult sendMessageInTransaction(final String txProducerGroup, final String destination, final Message<?> message, final Object arg) throws MessagingException {
      
     // public TransactionSendResult sendMessageInTransaction(final String destination, final Message<?> message, final Object arg) throws MessagingException 

//      try {
//        Thread.sleep(10);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
    }
  }
}