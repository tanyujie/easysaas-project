package org.easymis.easysaas.netty;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyApplication {
	protected static final Logger logger = LoggerFactory.getLogger(NettyApplication.class);

	public static void main(String[] args) {
		logger.info("web开始加载");
		SpringApplication.run(NettyApplication.class, args);
		logger.info("web加载完毕");
	}

}
