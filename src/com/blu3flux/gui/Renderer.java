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
	
	// Constants
	final int spacing = 22;
	
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
		
		// Render map
		drawMap(g);
		
		// Render Pellets
		g.setColor(Color.ORANGE);
		for(int i = 0; i < level.getPellets().size(); i++) {
			
			Pellet p = level.getPellets().get(i);
			
			int x = p.getX() - level.xOrigin;
			int y = p.getY() - level.yOrigin;
			
			x *= spacing;
			y*= spacing;
			
			x+= level.xOrigin + spacing;
			y+= level.yOrigin + spacing;
			
			g.fillRect(x, y, p.getWidth(), p.getHeight());
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
				
				int x = level.xOrigin + j * spacing;
				int y = level.yOrigin + i * spacing;
				
				if(wallLocations[i][j] == true) {
					// Right wall
					if(wallLocations[i][j+1] == false) {
						g.drawLine(x+spacing, y, x+spacing, y+spacing);
					}
					
					// Bottom wall
					if(wallLocations[i+1][j] == false) {
						g.drawLine(x,y+spacing, x+spacing, y+spacing);
					}
					
					// Left wall
					if(wallLocations[i][j-1] == false) {
						g.drawLine(x,y,x,y+spacing);
					}
					
					// Top wall
					if(wallLocations[i-1][j] == false) {
						g.drawLine(x, y, x+spacing, y);
					}
				}
			}
		}
	}
}
