package com.blu3flux.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.blu3flux.Game;
import com.blu3flux.entity.Pellet;
import com.blu3flux.level.Level;
import com.blu3flux.level.MapEncoding;

public class Renderer extends JPanel {

	private static final long serialVersionUID = 1L;
	private Game game;
	private Level level;
	
	public Renderer(Game g) {
		this.game = g;
		this.level = g.getLevel();
		addKeyListener(game.getInput());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Render black background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		drawMap(g);
		
		// Render Food
		g.setColor(Color.ORANGE);
		for(Pellet p : level.getPellets()) {
			g.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
		}
		
		// Render Pacman
		g.drawImage(level.getPacman().getImage(), level.getPacman().getXRelativeToCenter(), level.getPacman().getYRelativeToCenter(), this);
		// Render ghosts
		g.drawImage(level.getBlinky().getImage(), level.getBlinky().getXRelativeToCenter(), level.getBlinky().getYRelativeToCenter(), this);
		g.drawImage(level.getPinky().getImage(), level.getPinky().getXRelativeToCenter(), level.getPinky().getYRelativeToCenter(), this);
		g.drawImage(level.getInky().getImage(), level.getInky().getXRelativeToCenter(), level.getInky().getYRelativeToCenter(), this);
		g.drawImage(level.getClyde().getImage(), level.getClyde().getXRelativeToCenter(), level.getClyde().getYRelativeToCenter(), this);
	}
	
	void drawMap(Graphics g) {
		int xOffset = 59;
		int yOffset = 38;
		
		// Store obstacle locations of the map: {true=>wall, false=>no wall}
		boolean[][] wallLocations = new boolean[level.getMapData().length+2][level.getMapData()[0].length+2];
		
		// Copy obstacle layout into array
		for(int i = 0; i < level.getMapData().length; i++) {
			for(int j = 0; j < level.getMapData()[i].length; j++) {
				wallLocations[i+1][j+1] = (level.getMapData()[i][j] == MapEncoding.WALL) ? true : false;
				
			}
		}
		
		// Remove last row and column of walls to give illusion of bigger paths
		for(int i = 1; i < wallLocations.length-1; i++) {
			for(int j = 1; j < wallLocations[i].length-1; j++) {
				if(wallLocations[i][j+1] == false || wallLocations[i+1][j] == false || wallLocations[i+1][j+1] == false)
					wallLocations[i][j] = false;
			}
		}
		
		// Draw walls
		g.setColor(Color.BLUE);
		for(int i = 1; i < wallLocations.length-1; i++) {
			for(int j = 1; j < wallLocations[i].length-1; j++) {
				
				int x = xOffset + j * 22;
				int y = yOffset + i * 22;
				
				if(wallLocations[i][j] == true) {
					// RIGHT
					if(wallLocations[i][j+1] == false) {
						g.drawLine(x+22, y, x+22, y+22);
					}
					
					// BOTTOM
					if(wallLocations[i+1][j] == false) {
						g.drawLine(x,y+22, x+22, y+22);
					}
					
					// LEFT
					if(wallLocations[i][j-1] == false) {
						g.drawLine(x,y,x,y+22);
					}
					
					// TOP
					if(wallLocations[i-1][j] == false) {
						g.drawLine(x, y, x+22, y);
					}
				}
			}
		}
	}
}
