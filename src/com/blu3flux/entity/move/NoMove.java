package com.blu3flux.entity.move;

import java.awt.Point;

public class NoMove implements MoveableBehavior{

	@Override
	public Point move(Point p) {
		return p;
	}

	@Override
	public void moveRight() {}

	@Override
	public void moveDown() {}

	@Override
	public void moveLeft() {}

	@Override
	public void moveUp() {}

}
