package com.blu3flux.entity;

public class Pacman extends Entity{
	
	public Pacman(String imgLoc) {
		super(imgLoc);
		this.X = 400.0f;
		this.Y = 461.0f;
	}
	
	public float getX() {
		return this.X - this.getWidth()/2.0f;
	}
	
	public float getY() {
		return this.Y - this.getHeight()/2.0f;
	}
}
