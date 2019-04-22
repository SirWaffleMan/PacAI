package com.blu3flux;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Level {
	
	private BufferedImage image = null;
	
	public Level(String pathToImage) {
		image = getImage(pathToImage);
	}
	
	private BufferedImage getImage(String filename) {
        try {                
            return ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
	
	public BufferedImage getImage() {
		return image;
	}
}
