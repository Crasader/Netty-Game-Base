package game.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import game.Server;
import game.world.entity.player.Player;

/**
 *
 * Each world has its own unique port. So, the world corresponds to the server it is
 * running on. The world handles all possible interactions between entities and objects.
 * 
 * @author jung
 * 
 */
public class World {

	/**
	 * Logging system used to log messages for the server
	 */
	private static final Logger logger = Logger.getLogger(Server.class
			.getName());
	
	/**
	 * The player start coordinate.
	 */
	public static Position PLAYER_START_POS = new Position(0, 0);
	
	/**
	 * The port of the world (i.e., server port).
	 */
	private int port;
	
	/**
	 * The list of players.
	 */
	private List<Player> players;
	
	/**
	 * The map of regions.
	 * The key is the name of the region and the entry is the region.
	 */
	private Map<String, Region> regions;
	
	/**
	 * Constructs a new world.
	 * @param port of the world.
	 */
	public World(int port) {
		logger.log(Level.INFO, "Game world is initializing...");
		this.port = port;
	}
	
	/**
	 * Initializes the world.
	 */
	public void init() {
		this.players = new ArrayList<Player>();
		this.regions = new HashMap<String, Region>();
		logger.log(Level.INFO, "World is ready...");
	}
	
	/**
	 * Add a new player to the world.
	 * @param username of the player.
	 * @return true if the player is added to the world.
	 */
	public boolean addPlayer(String username) {
		for(Player tmp : players)
			if(username.equals(tmp.getUsername()))
				return false;
		Player player = new Player(World.PLAYER_START_POS.getClone());
		players.add(player);
		player.setUsername(username);
		player.setIndex(players.indexOf(player));
		return true;
	}
	
	/**
	 * Adds a new region to the world.
	 * @param name of the region.
	 * @param bottomLeft is the bottom left corner of the region.
	 * @param topRight if the top right corner of the region.
	 * @return true if the region is added.
	 */
	public boolean addRegion(String name, Position bottomLeft, Position topRight) {
		if (bottomLeft.getX() > topRight.getX() ||
				bottomLeft.getY() > topRight.getY())
			return false;
		regions.put(name, new Region(bottomLeft, topRight));
		return true;
	}
	
	/**
	 * @return the port of the world.
	 */
	public int getPort() {
		return port;
	}
	
}
