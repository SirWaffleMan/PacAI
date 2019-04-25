package com.blu3flux.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Entity {
	
	// Location
	protected int realX;
	protected int realY;
	protected int X;
	protected int Y;
	int[][]path;
	
	// Movement/Direction
	protected Direction direction;
	public boolean isMovingUp = false;
	public boolean isMovingLeft = false;
	public boolean isMovingRight = false;
	public boolean isMovingDown = false;
	private int movementSpeed = 1;
	
	// Image
	protected BufferedImage image;
	
	public Entity(int[][]path,String imgLoc) {
		if(imgLoc != "")
			image = getImage(imgLoc);
		direction = Direction.RIGHT;
		this.path = path;
	}
	
	protected BufferedImage getImage(String filename) {
        try {                
            return ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public void tick() {
		System.out.println(this.direction);
		move();
	}
	
	private void move() {
		
		Direction directionRequest = direction;
		
		if(isMovingUp) {
			if(path[Y-1][X] != 0)
				directionRequest = Direction.UP;
		}
		else if(isMovingRight) {
			if(path[Y][X+1] != 0)
				directionRequest = Direction.RIGHT;
		}
		else if(isMovingDown) {
			if(path[Y+1][X] != 0)
				directionRequest = Direction.DOWN;
		}
		else if(isMovingLeft) {
			if(path[Y][X-1] != 0)
				directionRequest = Direction.LEFT;
		}
		
		if(checkValidMovement(directionRequest)) {
			switch(directionRequest) {
			case UP:
				setRealY(getRealY() - movementSpeed);
				direction = Direction.UP;
				//setRealX(125 + (getX()-1) * 22); // Adjust
				break;
			case RIGHT:
				setRealX(getRealX() + movementSpeed);
				direction = Direction.RIGHT;
				//setRealY(103 + (getY()-1) * 22); // Adjust
				break;
			case DOWN:
				setRealY(getRealY() + movementSpeed);
				direction = Direction.DOWN;
				//setRealX(125 + (getX()-1) * 22); // Adjust
				break;
			case LEFT:
				setRealX(getRealX() - movementSpeed);
				direction = Direction.LEFT;
				//setRealY(103 + (getY()-1) * 22); // Adjust
				break;
			}
		}
		
	}
	
	private boolean checkValidMovement(Direction d) {
		
		switch(d) {
		case UP:
			if(path[Y-1][X] == 1 && (this.realX-125) % 22 == 0)
				return true;
			break;
		case RIGHT:
			if(path[Y][X+1] == 1 && (this.realY-103) % 22 == 0)
				return true;
			break;
		case DOWN:
			if(path[Y+1][X] == 1 && (this.realX-125) % 22 == 0)
				return true;
			break;
		case LEFT:
			if(path[Y][X-1] == 1 && (this.realY-103) % 22 == 0)
				return true;
			break;
		}
		return false;
	}
	
	public void setX(int x) {
		this.X = x;
		this.realX = 125 + 22 * x;
	}
	
	public void setY(int y) {
		this.Y = y;
		this.realY = 103 + 22 * y;
	}
	
	public void setRealX(int x) {
		this.realX = x;
		if((x-103) % 22 == 0)
			this.X = (x - 103) / 22;
	}
	
	public void setRealY(int y) {
		this.realY = y;
		if((y-81) % 22 == 0)
			this.Y = (y - 81) / 22;
	}
	
	public int getRealX() {
		return this.realX;
	}
	
	public int getRealY() {
		return this.realY;
	}
	
	public int getX() {
		return this.X;
	}
	
	public int getY() {
		return this.Y;
	}
	
	public void setDirection(Direction d) {
		this.direction = d;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public int getHeight() {
		return image.getHeight();
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
