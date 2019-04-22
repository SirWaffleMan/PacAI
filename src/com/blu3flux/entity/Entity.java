package com.blu3flux.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Entity {
	
	protected float X;
	protected float Y;
	protected BufferedImage image;
	
	public Entity(String imgLoc) {
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
	
	protected float getHeight() {
		return (float)image.getHeight();
	}
	
	protected float getWidth() {
		return (float)image.getWidth();
	}
	
	public BufferedImage getImage() {
		return image;
	}
}
