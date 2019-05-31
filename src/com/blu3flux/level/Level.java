package com.blu3flux.level;

import java.util.ArrayList;


import com.blu3flux.entity.Ghost;
import com.blu3flux.entity.Pacman;
import com.blu3flux.entity.Pellet;

public class Level {
	
	// Holds layout of the map
	MapEncoding[][] mapData;
	
	// All entities in the game
	Pacman pacman;
	Ghost blinky, clyde, inky, pinky;
	ArrayList<Pellet> pellet;
	
	// Constants
	public final int spacing = 22;
	
	
	public Level(MapEncoding[][] data) {
		this.mapData = data;
		init();
	}
	
	private void init() {
		pacman = new Pacman();
		blinky = new Ghost(400,322, "assets/blinky.png");
		inky = new Ghost(357, 390, "assets/inky.png");
		pinky = new Ghost(400,390, "assets/pinky.png");
		clyde = new Ghost(443,390, "assets/clyde.png");
		pellet = new ArrayList<Pellet>();
		
		for(int i = 0; i < mapData.length; i++) {
			for(int j = 0; j < mapData[i].length; j++) {
				if(mapData[i][j] == MapEncoding.PELLET) {
					pellet.add(new Pellet(81 + j * spacing, 59 + i * spacing));
				}
			}
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
	
	public MapEncoding[][] getMapData(){
		return this.mapData;
	}
}
