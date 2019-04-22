package com.blu3flux.GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.blu3flux.Game;

public class Renderer extends JPanel {

	private static final long serialVersionUID = 1L;
	private Game game;
	
	public Renderer(Game g) {
		this.game = g;
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Render black background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		// Render Level
		g.drawImage(game.level1.getImage(), 0, 0, this);
		// Render pacman
		g.drawImage(game.pacman.getImage(), (int)game.pacman.getX(), (int)game.pacman.getY(), this); // TODO: Take a closer look at integer casting
	}
}
