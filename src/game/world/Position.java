package game.world;

/**
 * 
 * Most objects are to be initialized by their position. Objects can be static or dynamic.
 * For static objects, positions usually remain unchanged and, for dynamic objects, positions
 * can be set.
 * 
 * @author jung
 * 
 */
public class Position implements Cloneable {

	/**
	 * The x-coordinate of the object.
	 */
	private int x;
	
	/**
	 * The y-coordinate of the object.
	 */
	private int y;
	
	/**
	 * Constructs a new position.
	 * @param x is the x-coordinate.
	 * @param y is the y-coordinate.
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Changes the position of the object.
	 * @param x is the x-coordinate.
	 * @param y is the y-coordinate
	 */
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return the x-coordinate of the object.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @param x is the x-coordinate of the object.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y-coordinate of the object.
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y is the y-coordinate of the object.
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return the clone of this position.
	 */
	public Position getClone() {
		try {
			return (Position) this.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
