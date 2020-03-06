package org.easymis.easysaas.rocketmq.test;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
public class PushConsumer {	
  /**
   * 内部是使用长轮询Pull方式从MetaQ服务器拉消息，然后再回调用户Listener方法<br>
   */
  public static void main(String[] args) throws InterruptedException,
      MQClientException {
    /**
     * 一个应用创建一个Consumer，由应用来维护此对象，可以设置为全局对象或者单例<br>
     * 注意：ConsumerGroupName需要由应用来保证唯一。
     *不同consumer group里的consumer即便是消费同一个topic下的同一个queue，
     *那消费进度也是分开存储的。也就是说，不同的consumer group内的consumer的消费
     *完全隔离，彼此不受影响。
     */
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(
        "ConsumerGroupName");
    consumer.setNamesrvAddr("192.168.0.123:9876");
    consumer.setInstanceName("Consumber");
    //广播消费是指一个consumer只要订阅了某个topic的消息，那它就会收到该topic下的所有queue里的消息，
    //而不管这个consumer的group是什么。所以对于广播消费来说，consumer group没什么实际意义。consumer可以在实例化时，我们可以指定是集群消费还是广播消费。
    //consumer.setMessageModel(MessageModel.BROADCASTING);
    /**
     * 订阅指定topic下tags分别等于TagA或TagC或TagD
     */
    consumer.subscribe("TopicTest1", "TagA || TagC || TagD");
    /**
     * 订阅指定topic下所有消息<br>
     * 注意：一个consumer对象可以订阅多个topic
     */
    consumer.subscribe("TopicTest2", "*");
    consumer.registerMessageListener(new MessageListenerConcurrently() {
      /**
       * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
       */
      @Override
      public ConsumeConcurrentlyStatus consumeMessage(
          List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        System.out.println(Thread.currentThread().getName()
            + " Receive New Messages: " + msgs.size());
        MessageExt msg = msgs.get(0);
        if (msg.getTopic().equals("TopicTest1")) {
          // 执行TopicTest1的消费逻辑
          if (msg.getTags() != null && msg.getTags().equals("TagA")) {
            // 执行TagA的消费
            System.out.println(new String(msg.getBody()));
          } else if (msg.getTags() != null
              && msg.getTags().equals("TagC")) {
            // 执行TagC的消费
          } else if (msg.getTags() != null
              && msg.getTags().equals("TagD")) {
            // 执行TagD的消费
          }
        } else if (msg.getTopic().equals("TopicTest2")) {
          System.out.println(new String(msg.getBody()));
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
      }
    });
    /**
     * Consumer对象在使用之前必须要调用start初始化，初始化一次即可<br>
     */
    consumer.start();
    System.out.println("Consumer Started.");
  }
}
