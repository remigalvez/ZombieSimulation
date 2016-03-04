package zombies.city;

import java.awt.Color;

public class Building {

	public static final Color BUILDING_COLOR = Color.DARK_GRAY;

	private int x; // left-most x value
	private int y; // top-most y value
	private int width;
	private int height;

	public Building() {
		this.x = 0;
		this.y = 0;
		this.width = 0;
		this.height = 0;
	}

	public Building(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void initialize(City city) {
		for (int i = y; i < y+height; i++) {
			for (int j = x; j < x+width; j++) {
				city.setColor(i, j, BUILDING_COLOR);
			}
		}
	}

	public void update(City city) {
		// Does nothing; buildings do not change
	}
}
