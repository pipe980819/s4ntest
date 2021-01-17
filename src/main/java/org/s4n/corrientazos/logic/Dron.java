package org.s4n.corrientazos.logic;

import java.util.List;

public class Dron implements Operations {

	private List<Coordinate> cordinates;
	private Coordinate currentPosition;
	private int numberOfDeliveries;

	public Dron() {
	}

	public Dron(int numberOfDeliveries) {
		this.numberOfDeliveries = numberOfDeliveries;
		this.currentPosition = new Coordinate(0, 0, Direction.N);
	}

	public void moveForward() {
		int currentX = getCurrentPosition().getX();
		int currentY = getCurrentPosition().getY();
		Direction currentDirection = getCurrentPosition().getDirection();

		if (Direction.N.equals(currentDirection)) {
			currentPosition.setY(currentY + 1);
		} else if (Direction.E.equals(currentDirection)) {
			currentPosition.setX(currentX + 1);
		} else if (Direction.S.equals(currentDirection)) {
			currentPosition.setY(currentY - 1);
		} else if (Direction.W.equals(currentDirection)) {
			currentPosition.setX(currentX - 1);
		}

	}

	public void turnLeft() {
		Direction currentDirection = getCurrentPosition().getDirection();

		if (Direction.N.equals(currentDirection)) {
			getCurrentPosition().setDirection(Direction.W);
		} else if (Direction.W.equals(currentDirection)) {
			getCurrentPosition().setDirection(Direction.S);
		} else if (Direction.S.equals(currentDirection)) {
			getCurrentPosition().setDirection(Direction.E);
		} else if (Direction.E.equals(currentDirection)) {
			getCurrentPosition().setDirection(Direction.N);
		}
	}

	public void turnRight() {
		Direction currentDirection = getCurrentPosition().getDirection();

		if (Direction.N.equals(currentDirection)) {
			getCurrentPosition().setDirection(Direction.E);
		} else if (Direction.E.equals(currentDirection)) {
			getCurrentPosition().setDirection(Direction.S);
		} else if (Direction.S.equals(currentDirection)) {
			getCurrentPosition().setDirection(Direction.W);
		} else if (Direction.W.equals(currentDirection)) {
			getCurrentPosition().setDirection(Direction.N);
		}

	}

	public void makeDelivery(String route) {
		for (int i = 0; i < route.length(); i++) {
			char movement = route.charAt(i);
			if (movement == 'A') {
				moveForward();
			} else if (movement == 'I') {
				turnLeft();
			} else if (movement == 'D') {
				turnRight();
			} else {
				System.out.println("Wrong movement");
			}
		}

	}

	public List<Coordinate> getCordinates() {
		return cordinates;
	}

	public void setCordinates(List<Coordinate> cordinates) {
		this.cordinates = cordinates;
	}

	public Coordinate getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Coordinate currentPosition) {
		this.currentPosition = currentPosition;
	}

	public int getNumberOfDeliveries() {
		return numberOfDeliveries;
	}

	public void setNumberOfDeliveries(int numberOfDeliveries) {
		this.numberOfDeliveries = numberOfDeliveries;
	}

}
