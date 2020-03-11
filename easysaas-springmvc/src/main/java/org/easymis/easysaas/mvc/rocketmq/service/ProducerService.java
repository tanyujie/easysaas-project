package org.easymis.easysaas.mvc.rocketmq.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	  @Value("${rocketmq.transTopic}")
	  private String springTransTopic;
	  @Value("${rocketmq.topic}")
	  private String springTopic;
	  @Value("${rocketmq.orderTopic}")
	  private String orderPaidTopic;
	  @Value("${rocketmq.msgExtTopic}")
	  private String msgExtTopic;
	  

}
