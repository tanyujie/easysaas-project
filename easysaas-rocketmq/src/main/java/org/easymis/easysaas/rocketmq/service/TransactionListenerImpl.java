package org.easymis.easysaas.rocketmq.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;

/**
 * 实现事务性接口
 */
@RocketMQTransactionListener(txProducerGroup = "myTxProducerGroup")
public class TransactionListenerImpl implements RocketMQLocalTransactionListener {
  private AtomicInteger transactionIndex = new AtomicInteger(0);
  private ConcurrentHashMap<String, Integer> localTrans = new ConcurrentHashMap<String, Integer>();
  
  @Override
  public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
    System.out.println("-----------go to executelocal------------------");
    String transId= (String) msg.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
    System.out.printf("#### executeLocalTransaction is executed, msgTransactionId=%s %n",
        transId);
    int value = transactionIndex.getAndIncrement();
    int status = value % 3;
    localTrans.put(transId, status);
    if(status == 0){
      //模拟处理成功提交
      System.out.printf("    # COMMIT # Simulating msg %s related local transaction exec succeeded! ### %n", msg.getPayload());
      return RocketMQLocalTransactionState.COMMIT;
    }
    if(status == 1){
      //模拟数据回滚
      System.out.printf("    # ROLLBACK # Simulating %s related local transaction exec failed! %n", msg.getPayload());
      return RocketMQLocalTransactionState.ROLLBACK;
    }
    System.out.printf("    # UNKNOW # Simulating %s related local transaction exec UNKNOWN! \n");
    return RocketMQLocalTransactionState.UNKNOWN;
  }

  @Override
  public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
//    System.out.println("-----------go to checklocal------------------");
    String transId= (String) msg.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
    RocketMQLocalTransactionState retState = RocketMQLocalTransactionState.COMMIT;
    Integer status = localTrans.get(transId);
    if(null != status){
      switch (status) {
        case 0:
          retState = RocketMQLocalTransactionState.UNKNOWN;
          break;
        case 1:
          retState = RocketMQLocalTransactionState.COMMIT;
          break;
        case 2:
          retState = RocketMQLocalTransactionState.ROLLBACK;
          break;
      }
    }
    System.out.printf("------ !!! checkLocalTransaction is executed once," +
        " msgTransactionId=%s, TransactionState=%s status=%s %n",
    transId, retState, status);
    return retState;
  }

}
