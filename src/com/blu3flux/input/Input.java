package com.blu3flux.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.blu3flux.entity.Direction;
import com.blu3flux.entity.Entity;

public class Input implements KeyListener{
	
	private Entity entity;
	
	public Input(Entity entity){
		this.entity = entity;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			entity.isMovingUp = true;
			break;
		case KeyEvent.VK_RIGHT:
			entity.isMovingRight = true;
			break;
		case KeyEvent.VK_DOWN:
			entity.isMovingDown = true;
			break;
		case KeyEvent.VK_LEFT:
			entity.isMovingLeft = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			entity.isMovingUp = false;
			break;
		case KeyEvent.VK_RIGHT:
			entity.isMovingRight = false;
			break;
		case KeyEvent.VK_DOWN:
			entity.isMovingDown = false;
			break;
		case KeyEvent.VK_LEFT:
			entity.isMovingLeft = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}
