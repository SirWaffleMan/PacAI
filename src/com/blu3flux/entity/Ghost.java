package com.blu3flux.entity;

public class Ghost extends Entity {

	public Ghost(int[][]path,int x, int y, String imgLoc) {
		super(path,imgLoc);
		this.realX = x;
		this.realY = y;
	}

}
