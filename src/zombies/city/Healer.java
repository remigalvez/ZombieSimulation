package zombies.city;

import java.awt.Color;

public class Healer extends Actor {

	public Healer() {
		super();
	}
	
	public Healer(int x, int y, Direction d, Color c) {
		super(x, y, d, c);
	}
	
	// ==========================================================
	// update
	// ==========================================================

	
	@Override
	public void update(City city) {
		
		city.setColor(x, y, City.CITY_COLOR);
		int random = Math.abs(rand.nextInt()%10);
		switch (dir) {
			case NORTH:
				y--;
				if (random == 0) dir = Direction.WEST;
				else if (random == 1) dir = Direction.EAST;
				for (int i = 1; i <= 10; i++) {
					try {
						if (city.getColor(x,y-i) == City.ZOMBIE_COLOR) {
							dir = Direction.NORTH;
						}
					} catch (IndexOutOfBoundsException e) {
						continue;
					}
				}
				if (y < 0 || y >= city.getHeight() || city.getColor(x, y) != City.CITY_COLOR) {
					y++;
					dir = Direction.SOUTH;
				}
				
				break;
			case EAST:
				x++;
				if (random == 0) dir = Direction.NORTH;
				else if (random == 1) dir = Direction.SOUTH;
				for (int i = 1; i <= 10; i++) {
					try {
						if (city.getColor(x,y-i) == City.ZOMBIE_COLOR) {
							dir = Direction.EAST;
						}
					} catch (IndexOutOfBoundsException e) {
						continue;
					}
				}
				if (x < 0 || x >= city.getWidth() || city.getColor(x, y) != City.CITY_COLOR) {
					x--;
					dir = Direction.WEST;
				}
				break;
			case SOUTH:
				y++;
				if (random == 0) dir = Direction.WEST;
				else if (random == 1) dir = Direction.EAST;
				for (int i = 1; i <= 10; i++) {
					try {
						if (city.getColor(x,y-i) == City.ZOMBIE_COLOR) {
							dir = Direction.SOUTH;
						}
					} catch (IndexOutOfBoundsException e) {
						continue;
					}
				}
				if (y < 0 || y >= city.getHeight() || city.getColor(x, y) != City.CITY_COLOR) {
					y--;
					dir = Direction.NORTH;
				}
				break;
			case WEST:
				x--;
				if (random == 0) dir = Direction.NORTH;
				else if (random == 1) dir = Direction.SOUTH;
				for (int i = 1; i <= 10; i++) {
					try {
						if (city.getColor(x,y-i) == City.ZOMBIE_COLOR) {
							dir = Direction.WEST;
						}
					} catch (IndexOutOfBoundsException e) {
						continue;
					}
				}
				if (x < 0 || x >= city.getWidth() || city.getColor(x, y) != City.CITY_COLOR) {
					x++;
					dir = Direction.EAST;
				}
				break;
			default: 
				System.out.println("No direction...");
				break;
		}
		
		city.setColor(x, y, col);
		
		int randy = rand.nextInt() % 2;
		
		if (x > 0 && city.getColor(x-1, y) == City.ZOMBIE_COLOR && randy == 0) toZombie(city);
		if (x <= city.getWidth()-2 && city.getColor(x+1, y) == City.ZOMBIE_COLOR && randy == 0) toZombie(city);
		if (y > 0 && city.getColor(x, y-1) == City.ZOMBIE_COLOR && randy == 0) toZombie(city);
		if (y <= city.getHeight()-2 && city.getColor(x, y+1) == City.ZOMBIE_COLOR && randy == 0) toZombie(city);
		if (x > 0 && y > 0 && city.getColor(x-1, y-1) == City.ZOMBIE_COLOR && randy == 0) toZombie(city);
		if (x > 0 && y < city.getHeight()-2 && city.getColor(x-1, y+1) == City.ZOMBIE_COLOR && randy == 0) toZombie(city);
		if (x < city.getWidth()-2 && y > 0 && city.getColor(x+1, y-1) == City.ZOMBIE_COLOR && randy == 0) toZombie(city);
		if (x < city.getWidth()-2 && y < city.getHeight()-2 && city.getColor(x+1, y+1) == City.ZOMBIE_COLOR && randy == 0) toZombie(city);
		
		
	}
	
}
