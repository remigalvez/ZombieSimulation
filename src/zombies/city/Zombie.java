package zombies.city;

import java.awt.Color;

public class Zombie extends Actor {
	
	public Zombie() {
		super();
	}
	
	public Zombie(int x, int y, Direction d, Color c) {
		super(x, y, d, c);
	}
	
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
						if (city.getColor(x,y-i) == City.HUMAN_COLOR) {
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
						if (city.getColor(x+i, y) == City.HUMAN_COLOR) {
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
						if (city.getColor(x, y+i) == City.HUMAN_COLOR) {
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
						if (city.getColor(x-i, y) == City.HUMAN_COLOR) {
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
		
		if (x > 0 && city.getColor(x-1, y) == City.HEALER_COLOR) toHuman(city);
		if (x < city.getWidth()-1 && city.getColor(x+1, y) == City.HEALER_COLOR) toHuman(city);
		if (y > 0 && city.getColor(x, y-1) == City.HEALER_COLOR) toHuman(city);
		if (y < city.getHeight()-1 && city.getColor(x, y+1) == City.HEALER_COLOR) toHuman(city);
		if (x > 0 && y > 0 && city.getColor(x-1, y-1) == City.HEALER_COLOR) toHuman(city);
		if (x > 0 && y < city.getHeight()-1 && city.getColor(x-1, y+1) == City.HEALER_COLOR) toHuman(city);
		if (x < city.getWidth()-1 && y > 0 && city.getColor(x+1, y-1) == City.HEALER_COLOR) toHuman(city);
		if (x < city.getWidth()-1 && y < city.getHeight()-1 && city.getColor(x+1, y+1) == City.HEALER_COLOR) toHuman(city);
	}
	
	@Override
	public String toString() {
		return "Zombie";
	}
	
}
