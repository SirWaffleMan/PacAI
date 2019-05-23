package com.blu3flux.entity;

import com.blu3flux.entity.move.Move;

public class Ghost extends Entity {

	public Ghost(int[][]path,int x, int y, String imgLoc) {
		super(path,imgLoc, new Move());
		setLocation(x,y);
	}

}
