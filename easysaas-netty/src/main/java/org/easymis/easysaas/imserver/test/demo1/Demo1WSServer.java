package org.easymis.easysaas.imserver.test.demo1;

import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@Component
public class Demo1WSServer {

	private static class SingletionWSServer {
		static final Demo1WSServer instance = new Demo1WSServer();
	}
	
	public static Demo1WSServer getInstance() {
		return SingletionWSServer.instance;
	}
	
	private EventLoopGroup mainGroup;
	private EventLoopGroup subGroup;
	private ServerBootstrap server;
	private ChannelFuture future;
	
	public Demo1WSServer() {
		mainGroup = new NioEventLoopGroup();
		subGroup = new NioEventLoopGroup();
		server = new ServerBootstrap();
		server.group(mainGroup, subGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(new Demo1WSServerInitialzer());
	}
	
	public void start() {
		this.future = server.bind(9088);
		System.err.println("netty websocket server 启动完毕...");
	}
}
