package org.easymis.easysaas.imserver.config.netty.group;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
/**
 * 
 * <p>
 * Title: Im广播组 用于推送全员信息及系统消息 或断开所有用户连接
 * </p>
 * <p>
 * Description:
 * </p>
 * @author 谭宇杰 @date 2020年3月15日
 */
public class BroadcastChannelGroup {
	private static final ChannelGroup CHANNELGROUP = new DefaultChannelGroup("ChannelGroup", GlobalEventExecutor.INSTANCE);
    
    public static void add(Channel channel) {
        CHANNELGROUP.add(channel);
    }
    public static void remove(Channel channel) {
        CHANNELGROUP.remove(channel);
    }
  
    /**
     * 广播 
     * @param msg
     * @return
     */
    public static ChannelGroupFuture broadcast(Object msg) {
        return CHANNELGROUP.writeAndFlush(msg);
    }
    /**
     * 广播
     * @param msg
     * @param matcher
     * @return
     */
    public static ChannelGroupFuture broadcast(Object msg, ChannelMatcher matcher) {
        return CHANNELGROUP.writeAndFlush(msg, matcher);
    }
     
    public static ChannelGroup flush() {
        return CHANNELGROUP.flush();
    }
    /**
     * 丢弃无用连接 
     * @param channel
     * @return
     */
    public static boolean discard(Channel channel) {
        return CHANNELGROUP.remove(channel);
    }
    /**
     * 断开所有连接
     * @return
     */
    public static ChannelGroupFuture disconnect() {
        return CHANNELGROUP.disconnect();
    }
    /**
     * 断开指定连接 
     * @param matcher
     * @return
     */
    public static ChannelGroupFuture disconnect(ChannelMatcher matcher) {
        return CHANNELGROUP.disconnect(matcher);
    }
    /**
     * 
     * @param channel
     * @return
     */
    public static boolean isExist(Channel channel) {
        return CHANNELGROUP.contains(channel);
    }
    public static int size() {
        return CHANNELGROUP.size();
    }
}
