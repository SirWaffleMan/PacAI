package com.blu3flux.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.blu3flux.entity.Ghost;
import com.blu3flux.entity.Pacman;
import com.blu3flux.entity.Pellet;

public class Level {
	
	LevelEncoding[][] data;
	
	Pacman pacman;
	Ghost blinky, clyde, inky, pinky;
	ArrayList<Pellet> pellet;
	
	// TEMP
	public BufferedImage image;
	
	public Level(LevelEncoding[][] data) {
		this.data = data;
		init();
	}
	
	private void init() {
		pacman = new Pacman();
		blinky = new Ghost(400,322, "assets/blinky.png");
		inky = new Ghost(357, 390, "assets/inky.png");
		pinky = new Ghost(400,390, "assets/pinky.png");
		clyde = new Ghost(443,390, "assets/clyde.png");
		pellet = new ArrayList<Pellet>();
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(data[i][j] == LevelEncoding.PELLET) {
					pellet.add(new Pellet(103 + j * 22, 81 + i * 22));
				}
			}
		}
		
		
		// TEMP
		try {
			image = ImageIO.read(new File("assets/level1_map.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void tick() {
		pacman.tick();
		blinky.tick();
		inky.tick();
		pinky.tick();
		clyde.tick();
	}
	
	public Pacman getPacman() {
		return this.pacman;
	}
	
	public Ghost getBlinky() {
		return this.blinky;
	}
	
	public Ghost getInky() {
		return this.inky;
	}
	
	public Ghost getPinky() {
		return this.pinky;
	}
	
	public Ghost getClyde() {
		return this.clyde;
	}
	
	public ArrayList<Pellet> getPellets(){
		return this.pellet;
	}
}
