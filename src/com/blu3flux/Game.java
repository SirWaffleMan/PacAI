package com.blu3flux;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.blu3flux.entity.Food;
import com.blu3flux.entity.Ghost;
import com.blu3flux.entity.Pacman;

public class Game implements Runnable{
	// Game Properties
	private boolean isRunning;
	private int gameSpeed = 7500000;
	Thread thread;
	
	
	// Game Entities
	public Level level1;
	public Pacman pacman;
	public Ghost blinky;
	public Ghost pinky;
	public Ghost inky;
	public Ghost clyde;
	public ArrayList<Food> food;
	
	public Game() {
		init();
		readLevelData();
	}
	
	public void start() {
		isRunning = true;
		thread.start();
	}
	
	@Override
	public void run() {
		long last = System.nanoTime();
		while(isRunning) {
			if(System.nanoTime() - last > gameSpeed) {
				last = System.nanoTime();
				tick();
			}
		}
	}
	
	private void tick() {
		
	}
	
	private void init() {
		level1 = new Level("assets/level1.png");
		pacman = new Pacman("assets/pacman.png");
		blinky = new Ghost(400, 322,"assets/blinky.png");
		inky = new Ghost(357, 390,"assets/inky.png");
		pinky = new Ghost(400, 390,"assets/pinky.png");
		clyde = new Ghost(443, 390,"assets/clyde.png");
		food  = new ArrayList<Food>();
		thread = new Thread(this);
	}
	
	public void readLevelData() {
		File levelData = new File("assets/level1.dat");
		Scanner scanner = null;
		try {
			scanner = new Scanner(levelData);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// File format (by line):
		// X_loc <space> Y_loc
		while(scanner.hasNextLine()) {
			food.add(new Food(scanner.nextInt(), scanner.nextInt()));
		}
		scanner.close();
		
	}
	
}
