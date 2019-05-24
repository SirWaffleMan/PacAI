package com.blu3flux.gui;

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
		addKeyListener(game.input);
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
			g.fillRect(food.getX(), food.getY(), food.getWidth(), food.getHeight());
		}
		
		// Render Pacman
		g.drawImage(game.pacman.getImage(), game.pacman.getXRelativeToCenter(), game.pacman.getYRelativeToCenter(), this);
		// Render ghosts
		g.drawImage(game.blinky.getImage(), game.blinky.getXRelativeToCenter(), game.blinky.getYRelativeToCenter(), this);
		g.drawImage(game.pinky.getImage(), game.pinky.getXRelativeToCenter(), game.pinky.getYRelativeToCenter(), this);
		g.drawImage(game.inky.getImage(), game.inky.getXRelativeToCenter(), game.inky.getYRelativeToCenter(), this);
		g.drawImage(game.clyde.getImage(), game.clyde.getXRelativeToCenter(), game.clyde.getYRelativeToCenter(), this);
	}
}
