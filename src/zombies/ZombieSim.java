package zombies;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import zombies.city.City;

public class ZombieSim extends JFrame {

	/* Define constants using static final variables */
	public static final int MAX_X = 60;
	public static final int MAX_Y = 60;
	private static final int DOT_SIZE = 10;
	private static final int SLEEP_TIME = 300;
	private static int SCENE;
	private static final long serialVersionUID = -5176170979783243427L;
	
	private volatile boolean paused = false;

	/** The Dot Panel object you will draw to */
	public static DotPanel dp;

	/*
	 * This fills the frame with a "DotPanel", a type of drawing canvas that
	 * allows you to easily draw squares to the screen.
	 */
	public ZombieSim(final int SCENE) {
		this.SCENE = SCENE;
		startSim();
	}
	
	public void startSim() {
		Scenarios scene = new Scenarios();
		this.setSize(MAX_X * DOT_SIZE, MAX_Y * DOT_SIZE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Braaiinnnnnsss");
		this.setLocationRelativeTo(null);

		/* Create and set the size of the panel */
		dp = new DotPanel(MAX_X, MAX_Y, DOT_SIZE);

		/* Add the panel to the frame */
		Container cPane = this.getContentPane();
		cPane.add(dp);
		
		/*
		 * Initialize the DotPanel canvas: You CANNOT draw to the panel BEFORE
		 * this code is called. You CANNOT add new widgets to the frame AFTER
		 * this is called.
		 */
		this.pack();
		dp.init();
		dp.clear();
		dp.setPenColor(Color.red);
		this.setVisible(true);

		/* Create our city */
		// pass in a building list
		// pass in a human list
		final City world = new City(MAX_X, MAX_Y, scene.getBuildings(SCENE), scene.getActors(SCENE), scene.getColors(SCENE));
		
		KeyListener key = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) 
					paused = !paused;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT && paused) { 
					world.update();
					world.draw();
					dp.repaintAndSleep(0);
				}
			}
			@Override
			public void keyTyped(KeyEvent e) { }
			@Override
			public void keyReleased(KeyEvent e) { }
		};
		
		
		JTextField tf = new JTextField();
		tf.addKeyListener(key);
		getContentPane().add(tf);
		
		/*
		 * This is the Run Loop (aka "simulation loop" or "game loop") It will
		 * loop forever, first updating the state of the world (e.g., having
		 * humans take a single step) and then it will draw the newly updated
		 * simulation. Since we don't want the simulation to run too fast for us
		 * to see, it will sleep after repainting the screen. Currently it
		 * sleeps for 33 milliseconds, so the program will update at about 30
		 * frames per second.
		 */
		while (true) {
			if (paused) 
				while (paused) {}
			// Run update rules for world and everything in it
			world.update();
			// Draw to screen and then refresh
			world.draw();
			dp.repaintAndSleep(SLEEP_TIME);
		}
		
		
	}

	public static void main(String[] args) {
		/* Create a new GUI window */
		ZombieSplash screen = new ZombieSplash();
		int SCENE = screen.getLevel();
		new ZombieSim(SCENE);
	}

}