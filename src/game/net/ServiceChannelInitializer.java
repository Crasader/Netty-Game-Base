package game.net;

import java.util.logging.Level;
import java.util.logging.Logger;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * A {@link ChannelInitializer} for the service pipeline
 * 
 * @author jung
 */
public class ServiceChannelInitializer extends
		ChannelInitializer<SocketChannel> {
	
	private final ChannelHandler handler;
	
	private static final Logger logger = Logger.getLogger(ServiceChannelInitializer.class.getName());

	public ServiceChannelInitializer(ChannelHandler handler) {
		this.handler = handler;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		pipeline.addLast("timeout", new ReadTimeoutHandler(10));
		//ch.pipeline().addLast("encoder", new Encoder());
		//ch.pipeline().addLast("decoder", new LoginProtocol());
		pipeline.addLast("handler", handler);
		logger.log(Level.INFO, "Connection recieved from " + ch.remoteAddress().getAddress());		
	}

}