package zombies.city;

import java.awt.Color;
import java.sql.Time;
import java.util.List;
import java.util.Random;

import zombies.ZombieSim;

public class City {
	
	public static final Color CITY_COLOR = Color.BLACK;
	public static Color HUMAN_COLOR;
	public static Color ZOMBIE_COLOR;
	public static Color HEALER_COLOR;
	
	private Color colors[][];
	private int width, height;
	private Random rand;
			
	private List<Building> buildings;
	private List<Actor> actors;

	/**
	 * Create a new City and fill it with buildings and people.
	 * 
	 * @param w
	 *            width of city
	 * @param h
	 *            height of city
	 * @param numB
	 *            number of buildings
	 * @param numH
	 *            number of humans
	 */
	public City(int w, int h, List<Building> bs, List<Actor> as, List<Color> cs) {
		width = w;
		height = h;
		colors = new Color[w][h];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				colors[i][j] = Color.BLACK;
			}
		}
		rand = new Random();
		
		buildings = bs;
		actors = as;
		setActorColors(cs.get(0), cs.get(1), cs.get(2));
		
		initialize();
	}
	
	public void setActorColors(Color HUMAN_COLOR, Color ZOMBIE_COLOR, Color HEALER_COLOR) {
		City.HUMAN_COLOR = HUMAN_COLOR;
		City.ZOMBIE_COLOR = ZOMBIE_COLOR;
		City.HEALER_COLOR = HEALER_COLOR;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Random getRand() {
		return rand;
	}
	
	public Color getColor(int x, int y) {
		return colors[x][y];
	}
	
	public void setColor(int x, int y, Color color) {
		colors[x][y] = color;
	}
	
	public void initialize() {
		for (Building b : buildings) {
			b.initialize(this);
		}

		for (Actor p : actors) {
			p.initialize(this);
		}		
	}

	/**
	 * Updates the state of the city for a time step.
	 */
	public void update() {
		int size = actors.size();
		for (int i = 0; i < size; i++) {
			Actor p = actors.get(i);
			p.update(this);
		}
		for (int i = 0; i < size; i++) {
			Actor p = actors.get(i);
			if (p.isZombie()) {
				actors.remove(i);
				actors.add(new Zombie(p.getX(), p.getY(), p.getDir(), ZOMBIE_COLOR));
			} else if (p.isHuman()) {
				actors.remove(i);
				actors.add(new Human(p.getX(), p.getY(), p.getDir(), HUMAN_COLOR));
			}
		}
	}
	
	/**
	 * Draw the buildings and humans.
	 */
	public void draw() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				ZombieSim.dp.setPenColor(colors[x][y]);
				ZombieSim.dp.drawDot(x, y);
			}
		}
	}
}
