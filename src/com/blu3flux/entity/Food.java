package com.blu3flux.entity;

public class Food extends Entity{
	
	private float size = 5;

	public Food(String imgLoc) {
		super(imgLoc);
	}
	
	public Food(float x, float y) {
		super("");
		this.X = x;
		this.Y = y;
	}
	
	@Override
	public float getWidth() {
		return size;
	}
	
	@Override
	public float getHeight() {
		return size;
	}
	

}
