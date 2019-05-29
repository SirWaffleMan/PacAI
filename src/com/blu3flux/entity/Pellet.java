package com.blu3flux.entity;

import com.blu3flux.entity.movement.NoMove;

public class Pellet extends Entity{
	
	protected int size = 5;
	protected int points = 10;
	
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
