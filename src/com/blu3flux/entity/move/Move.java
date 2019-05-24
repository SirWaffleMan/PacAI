package com.blu3flux.entity.move;

import java.awt.Point;

import com.blu3flux.entity.Direction;

public class Move implements MoveableBehavior{
	
	Direction direction = Direction.RIGHT;
	public boolean isMovingUp = false;
	public boolean isMovingLeft = false;
	public boolean isMovingRight = false;
	public boolean isMovingDown = false;
	int movementSpeed = 1;
	
	@Override
	public Point move(Point p) {
		int x = p.x;
		int y = p.y;
		
		// TODO: Implement moving algorithm
		if(isMovingUp) {
			y--;
		}
		
		if(isMovingRight) {
			x++;
		}
		
		if(isMovingLeft) {
			x--;
		}
		
		if(isMovingDown) {
			y++;
		}
		
		return new Point(x,y);
	}

	public void moveRight() {
		// TODO
	}

	public void moveDown() {
		// TODO
	}

	public void moveLeft() {
		// TODO 
	}

	public void moveUp() {
		// TODO
	}

}
