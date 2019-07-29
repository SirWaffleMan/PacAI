package com.blu3flux.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.blu3flux.entity.Entity;
import com.blu3flux.entity.movement.Move;

public class Input implements KeyListener{
	
	private Move move;
	
	public Input(Entity entity){
		this.move = (Move) entity.moveBehavior;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			move.isMovingUp = true;
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			move.isMovingRight = true;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			move.isMovingDown = true;
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			move.isMovingLeft = true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			move.isMovingUp = false;
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			move.isMovingRight = false;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			move.isMovingDown = false;
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			move.isMovingLeft = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}

}
