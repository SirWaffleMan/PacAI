package com.blu3flux.GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.blu3flux.Game;
import com.blu3flux.entity.Food;

public class Renderer extends JPanel {

	private static final long serialVersionUID = 1L;
	private Game game;
	
	public Renderer(Game g) {
		this.game = g;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Render black background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Render Level
		g.drawImage(game.level1.getImage(), 0, 0, this);
		// Render Food
		g.setColor(Color.ORANGE);
		for(Food food : game.food) {
			g.fillRect((int)food.getX(), (int)food.getY(), (int)food.getWidth(), (int)food.getHeight());// TODO: Take a closer look at integer casting
		}
		// Render pacman
		g.drawImage(game.pacman.getImage(), (int)game.pacman.getX(), (int)game.pacman.getY(), this); // TODO: Take a closer look at integer casting
		// Render ghosts
		g.drawImage(game.blinky.getImage(), (int)game.blinky.getX(), (int)game.blinky.getY(), this); // TODO: Take a closer look at integer casting
		g.drawImage(game.pinky.getImage(), (int)game.pinky.getX(), (int)game.pinky.getY(), this); // TODO: Take a closer look at integer casting
		g.drawImage(game.inky.getImage(), (int)game.inky.getX(), (int)game.inky.getY(), this); // TODO: Take a closer look at integer casting
		g.drawImage(game.clyde.getImage(), (int)game.clyde.getX(), (int)game.clyde.getY(), this); // TODO: Take a closer look at integer casting
	}
}
