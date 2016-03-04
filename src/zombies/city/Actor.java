package zombies.city;

import java.awt.Color;
import java.util.Random;

public abstract class Actor {

	protected Random rand;
	protected Color col;
	protected int x;
	protected int y;
	protected Direction dir;
	protected boolean toZombie = false;
	protected boolean toHuman = false;
	
	// ==========================================================
	// Constructors
	// ==========================================================
	
	public Actor() {
		this.rand = new Random();
		this.x = 0;
		this.y = 0;
		this.dir = Direction.NORTH;
		this.col = Color.WHITE;
	}
	
	public Actor(int x, int y, Direction d, Color c) {
		this.rand = new Random();
		this.x = x;
		this.y = y;
		this.dir = d;
		this.col = c;
	}
	
	// ==========================================================
	// Accessors
	// ==========================================================

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getDir() {
		return dir;
	}

	public Color getColor() {
		return col;
	}
	
	// ==========================================================
	// Initialize
	// ==========================================================

	/**
	 * Places this person in its initial position within the city by coloring the
	 * appropriate dot. Avoids placing the person if something is already there.
	 * Avoids placing the person if they are outside the city limits.
	 * 
	 * @param city
	 */
	public void initialize(City city) {
		// TODO Implement this method
		if (this.x < 0 || this.x > city.getWidth() || this.y < 0 || this.y > city.getHeight() || 
				city.getColor(x, y) != City.CITY_COLOR) {
			System.err.println("Invalid actor position: (x,y) = (" + x + "," + y + ")");
			return;
		}
		
		city.setColor(x, y, col);
	}
	
	// ===========================================================
	// Update
	// ===========================================================
	
	/**
	 * Updates the position of this person in the city by updating the
	 * appropriate dot colors. The person will usually continue to go
	 * in the direction they have been going, but they have a 10% chance
	 * of turning (and moving) left and a 10% chance of turning (and moving) right.
	 * If an obstacle (such as a person/building/city-limit) is in the way,
	 * the person will not move, but will turn and face the opposite direction. 
	 * 
	 * @param city
	 */
	public void update(City city) {}
	
	public void toZombie(City city) {
		toZombie = true;
	}
	
	public void toHuman(City city) {
		toHuman = true;
	}
	
	public boolean isZombie() {	
		return toZombie;
	}
	
	public boolean isHuman() {
		return toHuman;
	}
	
}
