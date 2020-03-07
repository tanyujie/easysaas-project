package org.easymis.easysaas.imserver.config;

import org.easymis.easysaas.imserver.config.netty.WSServer;
import org.easymis.easysaas.imserver.test.demo1.Demo1WSServer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class NettyBoot implements ApplicationListener<ContextRefreshedEvent> {

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
			try {
				WSServer.getInstance().start();
				//本地测试实例
				Demo1WSServer.getInstance().start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}