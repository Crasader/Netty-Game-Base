package game.world.entity;

import game.world.Position;

/**
 * 
 * The entity class is used as an inheritance. E.g., for players or non-playe characters
 * 
 * @author jung
 * 
 */
public class Entity {

	/**
	 * The index of the entity.
	 */
	private int index;
	
	/**
	 * The position of the player.
	 */
	private Position position;

	/**
	 * Constructs a new entity.
	 * @param position is the initial position of the entity.
	 */
	public Entity(Position position) {
		this.position = position;
	}
	
	/**
	 * @return the index of the entity.
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * @param index of the entity to set.
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the position of the entity.
	 */
	public Position getPosition() {
		return position;
	}

}
