package com.blu3flux;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import com.blu3flux.input.Input;
import com.blu3flux.level.Level;
import com.blu3flux.level.LevelEncoding;

public class Game implements Runnable{
	
	// Game Properties
	boolean isRunning;
	int gameSpeed = 7500000;
	Thread thread;
	
	// Player input
	Input input;
	
	// Game Level
	ArrayList<Level> level;
	
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
		getLevel().tick();
	}
	
	private void init() {
		level = new ArrayList<Level>();
		thread = new Thread(this);
		loadLevel("assets/level1.png");
		input = new Input(getLevel().getPacman());
	}
	
	private void loadLevel(String fileName) {
		
		// Read level PNG data
		BufferedImage levelDataImage = null;
		try {
			levelDataImage = ImageIO.read(new File(fileName));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// Encode level data
		LevelEncoding[][] levelData = new LevelEncoding[levelDataImage.getHeight()][levelDataImage.getWidth()];
		for(int i = 0; i < levelData.length; i++) {
			for(int j = 0; j < levelData[i].length; j++) {
				
				int color = levelDataImage.getRGB(j, i);
				
				if(color == -1) {
					levelData[i][j] = LevelEncoding.PATH;
				}else if(color == -256) {
					levelData[i][j] = LevelEncoding.PELLET;
				}else {
					levelData[i][j] = LevelEncoding.WALL;
				}
				
			}
		}
		level.add(new Level(levelData));
	}
	
	public Level getLevel() {
		return level.get(0);
	}
	
	public Input getInput() {
		return this.input;
	}
	
}
