package com.blu3flux.entity;

import com.blu3flux.entity.move.Move;

public class Pacman extends Entity{
	
	public Pacman() {
		super("assets/pacman.png", new Move());
		setLocation(400,590);
	}
	
}
