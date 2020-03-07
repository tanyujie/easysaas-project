package org.easymis.easysaas.netty;




import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;


public class NettyApplication {
	protected static final Logger logger = LoggerFactory.getLogger(NettyApplication.class);

	public static void main(String[] args) {
		logger.info("web开始加载");
		SpringApplication.run(NettyApplication.class, args);
		logger.info("web加载完毕");
	}

}
