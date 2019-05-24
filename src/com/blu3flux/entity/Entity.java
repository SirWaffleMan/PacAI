package com.blu3flux.entity;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.blu3flux.entity.movement.MoveableBehavior;

public abstract class Entity {
	
	public MoveableBehavior moveBehavior;
	
	// Location
	Point coordinates;
	
	// Image
	protected BufferedImage image;
	
	public Entity(String imgLoc, MoveableBehavior moveBehavior) {
		if(imgLoc != "")
			image = getImage(imgLoc);
		this.moveBehavior = moveBehavior;
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
		move();
	}
	
	private void move() {
		this.coordinates = moveBehavior.move(coordinates);
	}
	
	public void setX(int x) {
		coordinates.x = x;
	}
	
	public void setY(int y) {
		coordinates.y = y;
	}
	
	public int getX() {
		return coordinates.x;
	}
	
	public int getXRelativeToCenter() {
		return getX() - getWidth() / 2;
	}
	
	public int getYRelativeToCenter() {
		return getY() - getHeight() / 2;
	}
	
	public int getY() {
		return coordinates.y;
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

	protected void setLocation(int x, int y) {
		this.coordinates = new Point(x,y);
	}
}
