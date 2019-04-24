package com.blu3flux.entity;

public class Food extends Entity{
	
	private int size = 5;
	
	public Food(int x, int y) {
		super(null,"");
		this.realX = x;
		this.realY = y;
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
