package org.s4n.corrientazos.logic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Dron implements Operations {

	private List<Coordinate> deliveryCoordinates;
	private int numberOfDeliveries;

	public Dron() {}

	public Dron(int numberOfDeliveries) {
		this.numberOfDeliveries = numberOfDeliveries;
		this.deliveryCoordinates = new ArrayList<Coordinate>();
	}

	public Coordinate moveForward(Coordinate currentPosition) {
		int currentX = currentPosition.getX();
		int currentY = currentPosition.getY();
		Direction currentDirection = currentPosition.getDirection();

		if (Direction.N.equals(currentDirection)) {
			currentPosition.setY(currentY + 1);
		} else if (Direction.E.equals(currentDirection)) {
			currentPosition.setX(currentX + 1);
		} else if (Direction.S.equals(currentDirection)) {
			currentPosition.setY(currentY - 1);
		} else if (Direction.W.equals(currentDirection)) {
			currentPosition.setX(currentX - 1);
		}

		return currentPosition;
	}

	public Coordinate turnLeft(Coordinate currentPosition) {
		Direction currentDirection = currentPosition.getDirection();

		if (Direction.N.equals(currentDirection)) {
			currentPosition.setDirection(Direction.W);
		} else if (Direction.W.equals(currentDirection)) {
			currentPosition.setDirection(Direction.S);
		} else if (Direction.S.equals(currentDirection)) {
			currentPosition.setDirection(Direction.E);
		} else if (Direction.E.equals(currentDirection)) {
			currentPosition.setDirection(Direction.N);
		}

		return currentPosition;
	}

	public Coordinate turnRight(Coordinate currentPosition) {
		Direction currentDirection = currentPosition.getDirection();
		if (Direction.N.equals(currentDirection)) {
			currentPosition.setDirection(Direction.E);
		} else if (Direction.E.equals(currentDirection)) {
			currentPosition.setDirection(Direction.S);
		} else if (Direction.S.equals(currentDirection)) {
			currentPosition.setDirection(Direction.W);
		} else if (Direction.W.equals(currentDirection)) {
			currentPosition.setDirection(Direction.N);
		}

		return currentPosition;
	}

	public void makeDelivery(String entireRoute) {
		String[] routes = entireRoute.split(",");
		for (String route : routes) {
			Coordinate currentePosition;
			if (getDeliveryCoordinates().isEmpty()) {
				currentePosition = new Coordinate(0, 0, Direction.N);
			} else {
				Coordinate lastPosition = getDeliveryCoordinates().get(getDeliveryCoordinates().size() - 1);
				currentePosition = new Coordinate(lastPosition.getX(), lastPosition.getY(),
						lastPosition.getDirection());
			}
			for (int i = 0; i < route.length(); i++) {
				char move = route.charAt(i);
				if (move == 'A') {
					currentePosition = moveForward(currentePosition);
				} else if (move == 'I') {
					currentePosition = turnLeft(currentePosition);
				} else if (move == 'D') {
					currentePosition = turnRight(currentePosition);
				} else {
					System.out.println("Wrong movement");
				}
			}
			getDeliveryCoordinates().add(currentePosition);
		}
	}

	public void createReport() {
		List<String> lines = new ArrayList<String>();
		lines.add("== Reporte de entregas ==");
		for (Coordinate deliveryCoordinate : getDeliveryCoordinates()) {
			String direction = "";
			if (Direction.N.equals(deliveryCoordinate.getDirection())) {
				direction = "direccion Norte";
			} else if (Direction.S.equals(deliveryCoordinate.getDirection())) {
				direction = "direccion Sur";
			} else if (Direction.E.equals(deliveryCoordinate.getDirection())) {
				direction = "direccion Oriente";
			} else if (Direction.W.equals(deliveryCoordinate.getDirection())) {
				direction = "direccion Occidente";
			}
			lines.add("\n(" + deliveryCoordinate.getX() + ", " + deliveryCoordinate.getY() + ") " + direction + "\n");
		}
		try {
			Path file = Paths.get("src/main/java/org/s4n/corrientazos/routes/out01.txt");
			Files.write(file, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public List<Coordinate> getDeliveryCoordinates() {
		return deliveryCoordinates;
	}

	public void setDeliveryCoordinates(List<Coordinate> deliveryCoordinates) {
		this.deliveryCoordinates = deliveryCoordinates;
	}

	public int getNumberOfDeliveries() {
		return numberOfDeliveries;
	}

	public void setNumberOfDeliveries(int numberOfDeliveries) {
		this.numberOfDeliveries = numberOfDeliveries;
	}

}
