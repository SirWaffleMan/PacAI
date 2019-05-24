package com.blu3flux.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.blu3flux.Game;
import com.blu3flux.entity.Pellet;
import com.blu3flux.level.Level;

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
		
		// TODO: Render level
		g.drawImage(level.image, 0, 0, this);
		
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
}
