package com.blu3flux.entity;

public class Obstacle {
	int size = 21;
	int x;
	int y;
	
	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSize() {
		return size;
	}
}
