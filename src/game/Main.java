package game;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import game.world.World;

/**
 * 
 * @author jung
 * 
 */
public class Main {

	/**
	 * Logging system used to log messages for the game.
	 */
	private static final Logger logger = Logger.getLogger(Server.class
			.getName());
	
	/**
	 * The main class of the game.
	 * @param args is the initial inputs from the controller.
	 */
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			System.out.print("Enter the port of the server (integer from 0 to 65535):");
			int port = Integer.parseInt(in.nextLine());
			Server server = new Server(port);
			World world = new World(port);
			server.init();
			world.init();
		} catch (Throwable t) {
			logger.log(Level.SEVERE, "Error while starting the server.", t);
		}
	}

}
