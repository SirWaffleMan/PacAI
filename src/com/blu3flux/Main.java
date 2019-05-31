package com.blu3flux;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.blu3flux.gui.Renderer;

public class Main {
	
	static Game game;
	static JFrame frame;
	static Renderer renderer;

	public static void main(String[] args) {
		init();
		start();
	}
	
	public static void init() {
		// Initialize
		game = new Game();
		frame = new JFrame("PacAI");
		renderer = new Renderer(game);
		
		// Setup window
		renderer.setPreferredSize(new Dimension(682, 748));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(renderer);
		frame.setVisible(true);
		frame.pack();
		renderer.setFocusable(true);
		renderer.requestFocusInWindow();
	}
	
	public static void start() {
		game.start();
		
		while(true) {
			render();
		}
	}
	
	private static void render() {
		renderer.repaint();
	}

}
