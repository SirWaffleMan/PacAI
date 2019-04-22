package com.blu3flux;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.blu3flux.GUI.Renderer;

public class Main {
	
	static Game game;
	static JFrame frame;
	static Renderer renderer;

	public static void main(String[] args) {
		init();
	}
	
	public static void init() {
		// Initialize
		game = new Game();
		frame = new JFrame("PacAI");
		renderer = new Renderer(game);
		
		// Setup window
		renderer.setPreferredSize(new Dimension(800, 800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(renderer);
		frame.setVisible(true);
		frame.pack();
	}

}
