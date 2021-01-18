package org.s4n.corrientazos.logic;

import java.util.ArrayList;
import java.util.List;

import org.s4n.corrientazos.logic.Coordinate;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DronTest {

	private Dron dron = new Dron(3, "01", 10);
	private static final String ROUTE1 = "AAAAIAA,DDDAIAD,AAIADAD";
	private static final String ROUTE2 = "DDAAAAI,AAIADAD,IIDAAADIDI";
	private static final String ROUTE3 = "AAAAADAAAIAAAD,DDAAAAI,IIDAAADIDI";
	private static final String ROUTE4 = "AAIADAD,DDDAIAD,AAAAIAA";
	
	@Test
	public void makeDeliveryWithRoute1_FailsDirectionOfFirstCoordinate() {
		dron.makeDelivery(ROUTE1);
		List<Coordinate> coordinatesReturn = dron.getDeliveryCoordinates();
		Assert.assertTrue(!coordinatesReturn.isEmpty());
		Assert.assertEquals(-2, coordinatesReturn.get(0).getX());
		Assert.assertEquals(4, coordinatesReturn.get(0).getY());
		Assert.assertEquals(Direction.N, coordinatesReturn.get(0).getDirection());
	}
	
	@Test
	public void makeDeliveryWithRoute1_ExpectedResult() {
		dron.makeDelivery(ROUTE1);
		dron.createReport();
		List<Coordinate> coordinatesReturn = dron.getDeliveryCoordinates();
		Assert.assertTrue(!coordinatesReturn.isEmpty());
		Assert.assertEquals(-2, coordinatesReturn.get(0).getX());
		Assert.assertEquals(4, coordinatesReturn.get(0).getY());
		Assert.assertEquals(Direction.W, coordinatesReturn.get(0).getDirection());
		Assert.assertEquals(-1, coordinatesReturn.get(1).getX());
		Assert.assertEquals(3, coordinatesReturn.get(1).getY());
		Assert.assertEquals(Direction.S, coordinatesReturn.get(1).getDirection());
		Assert.assertEquals(0, coordinatesReturn.get(2).getX());
		Assert.assertEquals(0, coordinatesReturn.get(2).getY());
		Assert.assertEquals(Direction.W, coordinatesReturn.get(2).getDirection());
	}
	
	@Test
	public void makeDeliveryWithRoute2_ExpectedResult() {
		dron.makeDelivery(ROUTE2);
		dron.createReport();
		List<Coordinate> coordinatesReturn = dron.getDeliveryCoordinates();
		Assert.assertTrue(!coordinatesReturn.isEmpty());
		Assert.assertEquals(0, coordinatesReturn.get(0).getX());
		Assert.assertEquals(-4, coordinatesReturn.get(0).getY());
		Assert.assertEquals(Direction.E, coordinatesReturn.get(0).getDirection());
		Assert.assertEquals(3, coordinatesReturn.get(1).getX());
		Assert.assertEquals(-3, coordinatesReturn.get(1).getY());
		Assert.assertEquals(Direction.S, coordinatesReturn.get(1).getDirection());
		Assert.assertEquals(6, coordinatesReturn.get(2).getX());
		Assert.assertEquals(-3, coordinatesReturn.get(2).getY());
		Assert.assertEquals(Direction.E, coordinatesReturn.get(2).getDirection());
	}
	
	@Test
	public void makeDeliveryWithRoute3_ExpectedResult() {
		dron.makeDelivery(ROUTE3);
		dron.createReport();
		List<Coordinate> coordinatesReturn = dron.getDeliveryCoordinates();
		Assert.assertTrue(!coordinatesReturn.isEmpty());
		Assert.assertEquals(3, coordinatesReturn.get(0).getX());
		Assert.assertEquals(8, coordinatesReturn.get(0).getY());
		Assert.assertEquals(Direction.E, coordinatesReturn.get(0).getDirection());
		Assert.assertEquals(-1, coordinatesReturn.get(1).getX());
		Assert.assertEquals(8, coordinatesReturn.get(1).getY());
		Assert.assertEquals(Direction.S, coordinatesReturn.get(1).getDirection());
		Assert.assertEquals(2, coordinatesReturn.get(2).getX());
		Assert.assertEquals(8, coordinatesReturn.get(2).getY());
		Assert.assertEquals(Direction.E, coordinatesReturn.get(2).getDirection());
	}
	
	@Test
	public void makeDeliveryWithRoute4_ExpectedResult() {
		dron.makeDelivery(ROUTE4);
		dron.createReport();
		List<Coordinate> coordinatesReturn = dron.getDeliveryCoordinates();
		Assert.assertTrue(!coordinatesReturn.isEmpty());
		Assert.assertEquals(-1, coordinatesReturn.get(0).getX());
		Assert.assertEquals(3, coordinatesReturn.get(0).getY());
		Assert.assertEquals(Direction.E, coordinatesReturn.get(0).getDirection());
		Assert.assertEquals(-2, coordinatesReturn.get(1).getX());
		Assert.assertEquals(4, coordinatesReturn.get(1).getY());
		Assert.assertEquals(Direction.N, coordinatesReturn.get(1).getDirection());
		Assert.assertEquals(-4, coordinatesReturn.get(2).getX());
		Assert.assertEquals(8, coordinatesReturn.get(2).getY());
		Assert.assertEquals(Direction.W, coordinatesReturn.get(2).getDirection());
	}

}
