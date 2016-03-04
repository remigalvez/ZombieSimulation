package zombies;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zombies.city.Actor;
import zombies.city.Building;
import zombies.city.Direction;
import zombies.city.Healer;
import zombies.city.Human;
import zombies.city.Zombie;

public class Scenarios {
	
	public Map<Integer, List<Color>> colorList = new HashMap<>();
	public Map<Integer, List<Actor>> actorList = new HashMap<>();
	public Map<Integer, List<Building>> buildingList = new HashMap<>();
	
	public Scenarios() {
		
		// Scenario 1
		List<Color> colors1 = new ArrayList<>();
		colors1.add(Color.WHITE);
		colors1.add(null);
		colors1.add(null);
		
		colorList.put(1, colors1);
		
		List<Actor> actors1 = new ArrayList<>();
		actors1.add(new Human(30, 30, Direction.NORTH, Color.WHITE));
		actorList.put(1, actors1);
		
		List<Building> buildings1 = new ArrayList<>();
		buildings1.add(new Building(0, 20, 20, 20));
		buildings1.add(new Building(20, 0, 20, 20));
		buildings1.add(new Building(20, 40, 20, 20));
		buildings1.add(new Building(40, 20, 20, 20));
		buildingList.put(1, buildings1);
		
		// Scenario 2
		List<Color> colors2 = new ArrayList<>();
		colors2.add(Color.BLUE);
		colors2.add(null);
		colors2.add(null);
		
		colorList.put(2, colors2);
		
		List<Actor> actors2 = new ArrayList<>();
		actors2.add(new Human(24, 34, Direction.NORTH, Color.BLUE));
		actors2.add(new Human(27, 34, Direction.NORTH, Color.BLUE));
		actors2.add(new Human(30, 34, Direction.NORTH, Color.BLUE));
		actors2.add(new Human(33, 34, Direction.NORTH, Color.BLUE));
		actors2.add(new Human(36, 34, Direction.NORTH, Color.BLUE));
		
		actors2.add(new Human(24, 26, Direction.SOUTH, new Color(155, 0, 255)));
		actors2.add(new Human(27, 26, Direction.SOUTH, new Color(155, 0, 255)));
		actors2.add(new Human(30, 26, Direction.SOUTH, new Color(155, 0, 255)));
		actors2.add(new Human(33, 26, Direction.SOUTH, new Color(155, 0, 255)));
		actors2.add(new Human(36, 26, Direction.SOUTH, new Color(155, 0, 255)));
		
		actorList.put(2, actors2);
		
		List<Building> buildings2 = new ArrayList<>();
		buildings2.add(new Building(0, 0, 20, 20));
		buildings2.add(new Building(40, 0, 20, 20));
		buildings2.add(new Building(0, 40, 20, 20));
		buildings2.add(new Building(40, 40, 20, 20));
		buildingList.put(2, buildings2);
		
		// Scenario 3
		List<Color> colors3 = new ArrayList<>();
		colors3.add(Color.WHITE);
		colors3.add(Color.MAGENTA);
		colors3.add(Color.GREEN);
		
		colorList.put(3, colors3);
		
		List<Actor> actors3 = new ArrayList<>();
		
		actors3.add(new Zombie(2, 2, Direction.SOUTH, Color.MAGENTA));
		actors3.add(new Zombie(17, 2, Direction.SOUTH, Color.MAGENTA));
		actors3.add(new Human(32, 2, Direction.SOUTH, Color.WHITE));
		actors3.add(new Human(47, 2, Direction.SOUTH, Color.WHITE));
		
		actors3.add(new Zombie(2, 17, Direction.NORTH, Color.MAGENTA));
		actors3.add(new Healer(17, 17, Direction.NORTH, Color.GREEN));
		actors3.add(new Zombie(32, 17, Direction.NORTH, Color.MAGENTA));
		actors3.add(new Human(47, 17, Direction.NORTH, Color.WHITE));
		
		actors3.add(new Human(2, 32, Direction.NORTH, Color.WHITE));
		actors3.add(new Human(17, 32, Direction.NORTH, Color.WHITE));
		actors3.add(new Human(32, 32, Direction.NORTH, Color.WHITE));
		actors3.add(new Human(47, 32, Direction.NORTH, Color.WHITE));
		
		actors3.add(new Human(2, 47, Direction.NORTH, Color.WHITE));
		actors3.add(new Human(17, 47, Direction.NORTH, Color.WHITE));
		actors3.add(new Human(32, 47, Direction.NORTH, Color.WHITE));
		actors3.add(new Zombie(47, 47, Direction.NORTH, Color.MAGENTA));
		
		actorList.put(3, actors3);
		
		List<Building> buildings3 = new ArrayList<>();
		buildings3.add(new Building(5, 5, 10, 10));
		buildings3.add(new Building(5, 20, 10, 10));
		buildings3.add(new Building(5, 35, 10, 10));
		buildings3.add(new Building(5, 50, 10, 10));
		
		buildings3.add(new Building(20, 5, 10, 10));
		buildings3.add(new Building(20, 20, 10, 10));
		buildings3.add(new Building(20, 35, 10, 10));
		buildings3.add(new Building(20, 50, 10, 10));
		
		buildings3.add(new Building(35, 5, 10, 10));
		buildings3.add(new Building(35, 20, 10, 10));
		buildings3.add(new Building(35, 35, 10, 10));
		buildings3.add(new Building(35, 50, 10, 10));
		
		buildings3.add(new Building(50, 5, 10, 10));
		buildings3.add(new Building(50, 20, 10, 10));
		buildings3.add(new Building(50, 35, 10, 10));
		buildings3.add(new Building(50, 50, 10, 10));
		
		buildingList.put(3, buildings3);
		
		// Scenario 4
		List<Color> colors4 = new ArrayList<>();
		colors4.add(Color.WHITE);
		colors4.add(Color.MAGENTA);
		colors4.add(Color.GREEN);
		
		colorList.put(4, colors4);
		
		List<Actor> actors4 = new ArrayList<>();
		
		actors4.add(new Human(2, 2, Direction.SOUTH, Color.WHITE));
		actors4.add(new Human(2, 17, Direction.SOUTH, Color.WHITE));
		actors4.add(new Human(2, 32, Direction.EAST, Color.WHITE));
		actors4.add(new Human(2, 47, Direction.NORTH, Color.WHITE));
		
		actors4.add(new Human(17, 2, Direction.SOUTH, Color.WHITE));
		actors4.add(new Human(17, 17, Direction.SOUTH, Color.WHITE));
		actors4.add(new Healer(17, 32, Direction.EAST, Color.GREEN));
		actors4.add(new Human(17, 47, Direction.NORTH, Color.WHITE));
		
		actors4.add(new Human(32, 2, Direction.SOUTH, Color.WHITE));
		actors4.add(new Human(32, 17, Direction.SOUTH, Color.WHITE));
		actors4.add(new Zombie(32, 32, Direction.WEST, Color.MAGENTA));
		actors4.add(new Human(32, 47, Direction.NORTH, Color.WHITE));
		
		actors4.add(new Human(47, 2, Direction.WEST, Color.WHITE));
		actors4.add(new Human(47, 17, Direction.WEST, Color.WHITE));
		actors4.add(new Human(47, 32, Direction.WEST, Color.WHITE));
		actors4.add(new Human(47, 47, Direction.WEST, Color.WHITE));
		
		actorList.put(4, actors4);
		
		List<Building> buildings4 = new ArrayList<>();
		
		buildings4.add(new Building(5, 5, 20, 10));
		buildings4.add(new Building(5, 20, 20, 10));
		buildings4.add(new Building(35, 20, 20, 10));
		buildings4.add(new Building(35, 5, 20, 10));
		
		buildings4.add(new Building(5, 35, 10, 20));
		buildings4.add(new Building(20, 35, 10, 20));
		buildings4.add(new Building(35, 35, 10, 20));
		buildings4.add(new Building(50, 35, 5, 20));
		
		buildingList.put(4, buildings4);
		
		// Scenario 5
		List<Color> colors5 = new ArrayList<>();
		colors5.add(Color.WHITE);
		colors5.add(Color.MAGENTA);
		colors5.add(Color.GREEN);
		
		colorList.put(5, colors5);
		
		List<Actor> actors5 = new ArrayList<>();
		
		actors5.add(new Human(30, 5, Direction.WEST, Color.WHITE));
		actors5.add(new Human(30, 10, Direction.WEST, Color.WHITE));
		actors5.add(new Human(30, 15, Direction.WEST, Color.WHITE));
		actors5.add(new Human(30, 20, Direction.WEST, Color.WHITE));
		
		actors5.add(new Human(22, 5, Direction.WEST, Color.WHITE));
		actors5.add(new Human(22, 10, Direction.WEST, Color.WHITE));
		actors5.add(new Human(22, 15, Direction.WEST, Color.WHITE));
		actors5.add(new Human(22, 20, Direction.WEST, Color.WHITE));
		
		actors5.add(new Human(5, 30, Direction.SOUTH, Color.WHITE));
		actors5.add(new Human(10, 30, Direction.SOUTH, Color.WHITE));
		actors5.add(new Human(15, 30, Direction.SOUTH, Color.WHITE));
		actors5.add(new Healer(20, 30, Direction.SOUTH, Color.GREEN));
		
		actors5.add(new Human(5, 38, Direction.SOUTH, Color.WHITE));
		actors5.add(new Human(10, 38, Direction.SOUTH, Color.WHITE));
		actors5.add(new Human(15, 38, Direction.SOUTH, Color.WHITE));
		actors5.add(new Healer(20, 38, Direction.SOUTH, Color.GREEN));
		
		actors5.add(new Human(30, 40, Direction.EAST, Color.WHITE));
		actors5.add(new Human(30, 45, Direction.EAST, Color.WHITE));
		actors5.add(new Human(30, 50, Direction.EAST, Color.WHITE));
		actors5.add(new Human(30, 55, Direction.EAST, Color.WHITE));
		
		actors5.add(new Human(38, 40, Direction.EAST, Color.WHITE));
		actors5.add(new Human(38, 45, Direction.EAST, Color.WHITE));
		actors5.add(new Human(38, 50, Direction.EAST, Color.WHITE));
		actors5.add(new Human(38, 55, Direction.EAST, Color.WHITE));
		
		actors5.add(new Human(40, 22, Direction.NORTH, Color.WHITE));
		actors5.add(new Human(45, 22, Direction.NORTH, Color.WHITE));
		actors5.add(new Human(50, 22, Direction.NORTH, Color.WHITE));
		actors5.add(new Human(55, 22, Direction.NORTH, Color.WHITE));
		
		actors5.add(new Zombie(40, 30, Direction.NORTH, Color.MAGENTA));
		actors5.add(new Human(45, 30, Direction.NORTH, Color.WHITE));
		actors5.add(new Human(50, 30, Direction.NORTH, Color.WHITE));
		actors5.add(new Human(55, 30, Direction.NORTH, Color.WHITE));
		
		actorList.put(5, actors5);
		
		List<Building> buildings5 = new ArrayList<>();
		buildingList.put(5, buildings5);
		
	}
	
	public List<Color> getColors(int n) {
		return colorList.get(n);
	}
	
	public List<Actor> getActors(int n) {
		return actorList.get(n);
	}
	
	public List<Building> getBuildings(int n) {
		return buildingList.get(n);
	}
}
