package com.blu3flux.entity;

import com.blu3flux.entity.movement.Move;

public class Pacman extends Entity{
	
	public Pacman() {
		super("assets/pacman.png", new Move());
		setLocation(341,551);
	}
	
}
