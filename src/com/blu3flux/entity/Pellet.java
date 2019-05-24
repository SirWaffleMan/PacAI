package com.blu3flux.entity;

import com.blu3flux.entity.move.NoMove;

public class Pellet extends Entity{
	
	private int size = 5;
	
	public Pellet(int x, int y) {
		super("",new NoMove());
		setLocation(x,y);
	}
	
	@Override
	public int getWidth() {
		return size;
	}
	
	@Override
	public int getHeight() {
		return size;
	}
	

}
