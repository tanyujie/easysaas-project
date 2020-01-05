package org.easymis.easycrm.operation.task;

import java.io.IOException;
import java.util.Date;

import org.easymis.easycrm.operation.socket.SocketOrderMessage;
import org.easymis.easycrm.operation.socket.WebSocketServer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Async
public class OrderMessageTask {
	/** 第一次延迟2秒后执行，之后按fixedDelay的规则每5秒执行一次 */
	@Scheduled(initialDelay = 2000, fixedRate = 5000)
	public void runOrder() throws InterruptedException, IOException {
		Thread.sleep(6000);
		SocketOrderMessage orderMessage = new SocketOrderMessage(1, "1","1",1,new Date());
		WebSocketServer.sendInfo(orderMessage, "20");
	}

}
