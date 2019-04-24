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
			g.fillRect(food.getRealX(), food.getRealY(), food.getWidth(), food.getHeight());
		}
		// Render pacman
		g.drawImage(game.pacman.getImage(), game.pacman.getRealX()-game.pacman.getWidth()/2, game.pacman.getRealY()-game.pacman.getHeight()/2, this);
		//g.fillRect(game.pacman.getRealX(), game.pacman.getRealY(), game.pacman.getWidth(), game.pacman.getHeight());
		// Render ghosts
		g.drawImage(game.blinky.getImage(), game.blinky.getRealX(), game.blinky.getRealY(), this);
		g.drawImage(game.pinky.getImage(), game.pinky.getRealX(), game.pinky.getRealY(), this);
		g.drawImage(game.inky.getImage(), game.inky.getRealX(), game.inky.getRealY(), this);
		g.drawImage(game.clyde.getImage(), game.clyde.getRealX(), game.clyde.getRealY(), this);
	}
}
