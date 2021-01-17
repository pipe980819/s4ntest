package org.s4n.corrientazos.logic;

public interface Operations {
	
	public Coordinate moveForward(Coordinate currentPosition);
	public Coordinate turnLeft(Coordinate currentPosition);
	public Coordinate turnRight(Coordinate currentPosition);
	public void makeDelivery(String entireRoute);
	public void createReport();

}
