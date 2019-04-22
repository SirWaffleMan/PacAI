package com.blu3flux;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.blu3flux.entity.Food;
import com.blu3flux.entity.Ghost;
import com.blu3flux.entity.Pacman;

public class Game {
	
	public Level level1;
	public Pacman pacman;
	public Ghost blinky;
	public Ghost pinky;
	public Ghost inky;
	public Ghost clyde;
	public ArrayList<Food> food = new ArrayList<Food>();
	
	public Game() {
		level1 = new Level("assets/level1.png");
		pacman = new Pacman("assets/pacman.png");
		blinky = new Ghost(400, 322,"assets/blinky.png");
		inky = new Ghost(357, 390,"assets/inky.png");
		pinky = new Ghost(400, 390,"assets/pinky.png");
		clyde = new Ghost(443, 390,"assets/clyde.png");
		readLevelData();
		
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
			food.add(new Food(scanner.nextFloat(), scanner.nextFloat()));
		}
		scanner.close();
		
	}
}
