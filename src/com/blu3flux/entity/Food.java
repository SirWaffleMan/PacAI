package com.blu3flux.entity;

public class Food extends Entity{
	
	private int size = 5;

	public Food(String imgLoc) {
		super(imgLoc);
	}
	
	public Food(int x, int y) {
		super("");
		this.X = x;
		this.Y = y;
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
