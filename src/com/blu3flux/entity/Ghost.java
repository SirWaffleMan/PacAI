package com.blu3flux.entity;

import com.blu3flux.entity.movement.Move;

public class Ghost extends Entity {

	public Ghost(int x, int y, String imgLoc) {
		super(imgLoc, new Move());
		setLocation(x,y);
	}

}
