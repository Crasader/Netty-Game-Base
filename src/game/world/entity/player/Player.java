package game.world.entity.player;

import game.world.Position;
import game.world.entity.Entity;

/**
 * 
 * The player class is an inheritance of the entity class. The player is the user who
 * is playing on or using the client.
 * 
 * @author jung
 * 
 */
public class Player extends Entity {

	/**
	 * The username of the player.
	 */
	private String username;
	
	/**
	 * Constructs a new player with an initial position.
	 * @param position of the player.
	 */
	public Player(Position position) {
		super(position);
	}

	/**
	 * @return the username of the player.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username of the player.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}
