package com.blu3flux;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.blu3flux.entity.Food;
import com.blu3flux.entity.Ghost;
import com.blu3flux.entity.Pacman;
import com.blu3flux.input.Input;

public class Game implements Runnable{
	
	// Game Properties
	private boolean isRunning;
	private int gameSpeed = 7500000;
	private Thread thread;
	
	// Game Entities
	public Level level1;
	public Pacman pacman;
	public Ghost blinky;
	public Ghost pinky;
	public Ghost inky;
	public Ghost clyde;
	public ArrayList<Food> food;
	
	// Game Data
	public int[][]path;
	
	// Player input
	public Input input;
	
	public Game() {
		init();
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
		pacman.tick();
	}
	
	private void init() {
		level1 = new Level("assets/level1.png");
		food  = new ArrayList<Food>();
		thread = new Thread(this);
		loadLevel();
		pacman = new Pacman(path,"assets/pacman.png");
		blinky = new Ghost(path,400, 322,"assets/blinky.png");
		inky = new Ghost(path,357, 390,"assets/inky.png");
		pinky = new Ghost(path,400, 390,"assets/pinky.png");
		clyde = new Ghost(path,443, 390,"assets/clyde.png");
		input = new Input(pacman);
	}
	
	private void loadLevel() {
		
		// Read level path
		BufferedImage pathImage = null;
		try {                
            pathImage = ImageIO.read(new File("assets/level1_map.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		path = new int[pathImage.getHeight()][pathImage.getWidth()];
		for(int i = 0; i < path.length; i++) {
			for(int j = 0; j < path[i].length; j++) {
				
				path[i][j] = (pathImage.getRGB(j, i) == -1) ? 1 : 0;
				
				if(pathImage.getRGB(j,i) == -256) {
					food.add(new Food(103 + j * 22, 81 + i * 22));
				}
			}
		}
		
	}
	
}
