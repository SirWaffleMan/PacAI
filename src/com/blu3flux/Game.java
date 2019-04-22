package com.blu3flux;

import com.blu3flux.entity.Pacman;

public class Game {
	
	public Level level1;
	public Pacman pacman;
	
	public Game() {
		level1 = new Level("assets/level1.png");
		pacman = new Pacman("assets/pacman.png");
	}
}
