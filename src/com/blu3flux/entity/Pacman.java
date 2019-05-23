package com.blu3flux.entity;

import com.blu3flux.entity.move.Move;

public class Pacman extends Entity{
	
	public Pacman(int[][]path,String imgLoc) {
		super(path,imgLoc, new Move());
		setLocation(440,587);
	}
	
}
