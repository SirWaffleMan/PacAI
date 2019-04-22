package com.blu3flux.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Entity {
	
	protected int X;
	protected int Y;
	protected BufferedImage image;
	
	public Entity(String imgLoc) {
		if(imgLoc != "")
			image = getImage(imgLoc);
	}
	
	protected BufferedImage getImage(String filename) {
        try {                
            return ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public void setX(int x) {
		this.X = x + this.getWidth()/2;
	}
	
	public void setY(int y) {
		this.Y = y + this.getHeight()/2;
	}
	
	public int getX() {
		return this.X - this.getWidth()/2;
	}
	
	public int getY() {
		return this.Y - this.getHeight()/2;
	}
	
	protected int getHeight() {
		return image.getHeight();
	}
	
	protected int getWidth() {
		return image.getWidth();
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
