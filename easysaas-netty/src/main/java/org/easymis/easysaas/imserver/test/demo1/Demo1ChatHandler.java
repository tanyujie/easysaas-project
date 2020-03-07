package org.easymis.easysaas.imserver.test.demo1;
import java.time.LocalDateTime;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 处理消息的handler
 * TextWebSocketFrame：在netty中，用于为websocket专门处理文本的对象，frame是消息的载体
 */
public class Demo1ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    // 用于记录和管理所有客户端的channel
    private static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // 获取客服端传输过来的消息
        String content = msg.text();
        System.out.println("接受到的数据：" + content);

        for (Channel client : clients) {
            client.writeAndFlush(new TextWebSocketFrame("[服务器在]" + LocalDateTime.now() + "接收到消息, 消息为：" + content));
        }

        // 下面这个方法，和上面的for循环，一致
//        clients.writeAndFlush(new TextWebSocketFrame("[服务器在]" + LocalDateTime.now() + "接收到消息, 消息为：" + content));

    }

    /**
     * 当客户端链接服务端之后（打开链接）
     * 获取客户端的channel，并且放到channelGroup中去进行管理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 当触发handlerRemoved，channelGroup会自动移除对应客户端的channel
//        clients.remove(ctx.channel());
        System.out.println("客户端断开，channel对应的长id为" + ctx.channel().id().asLongText());
        System.out.println("客户端断开，channel对应的短id为" + ctx.channel().id().asShortText());

    }
}
