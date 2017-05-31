package game.world;

/**
 * 
 * Regions are labeled to ensure the interactions between entity are handled in the
 * correct location. Some regions provide restrictions for some objects or entities.
 * The region is to be initialized when the world is initialized.
 * 
 * @author jung
 *
 */
public class Region {

	/**
	 * The bottom left of the position.
	 */
	private Position bottomLeft;
	
	/**
	 * The top right of the position.
	 */
	private Position topRight;
	
	/**
	 * Constructs a new region.
	 * @param bottomLeft is the bottom left corner of the region.
	 * @param topRight if the top right corner of the region.
	 */
	public Region(Position bottomLeft, Position topRight) {
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;
	}
	
	/**
	 * Checks if a position is within the region.
	 */
	public boolean isWithin(Position within) {
		return within.getX() >= bottomLeft.getX() && within.getX() <= topRight.getX() &&
				within.getY() >= bottomLeft.getY() && within.getY() <= topRight.getY();
	}
}
