package game.net;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 
 * An extension of {@link SimpleChannelInboundHandler} which is useful in this case
 * vs {@link ChannelInboundHandler} because {@link SimpleChannelInboundHandler} releases the objects
 * right away. {@link ChannelInboundHandlerAdapter} does not.
 * 
 * @author jung
 * 
 */
public class ChannelHandler extends SimpleChannelInboundHandler<Message> {

	@Override
	protected void channelRead0(ChannelHandlerContext arg0, Message arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

}