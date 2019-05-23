package com.blu3flux.entity;

import com.blu3flux.entity.move.NoMove;

public class Food extends Entity{
	
	private int size = 5;
	
	public Food(int x, int y) {
		super(null,"",new NoMove());
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
