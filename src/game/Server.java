package game;

import java.util.logging.Level;
import java.util.logging.Logger;

import game.net.ChannelHandler;
import game.net.ServiceChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 
 * The server class for the game.
 * 
 * @author jung
 * 
 */
public class Server {
	
	/**
	 * Logging system used to log messages for the server
	 */
	private static final Logger logger = Logger.getLogger(Server.class
			.getName());

	/**
	 * The port of the server.
	 */
	private int port;
	
	/**
	 * Creating an empty constructor
	 */
	public Server(int port) throws Exception {
		logger.log(Level.INFO, "Game server is initializing...");
		this.port = port;
	}

	/**
	 * Initializes the Server Channel Handler
	 * 
	 * @throws InterruptedException
	 */
	public void init() throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {

			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ServiceChannelInitializer(new ChannelHandler()))
				.option(ChannelOption.SO_BACKLOG, 128)
				.childOption(ChannelOption.SO_KEEPALIVE, true);

			logger.log(Level.INFO, "Binding to port " + port);
			ChannelFuture f = bootstrap.bind(port).sync();
			logger.log(Level.INFO, "Game server is online");
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

}