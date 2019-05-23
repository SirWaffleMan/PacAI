package com.blu3flux.entity.move;

import java.awt.Point;

public interface MoveableBehavior {
	Point move(Point p);
	void moveRight();
	void moveDown();
	void moveLeft();
	void moveUp();
}
