package org.s4n.corrientazos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.s4n.corrientazos.logic.Dron;

public class Corrientazos {

	public static void main(String[] args) throws IOException {
		String routesFolder = "src/main/java/org/s4n/corrientazos/routes/";
		final File folder = new File(routesFolder);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Cuadras a la redonda (10 por defecto):");
		String mapSize = scanner.nextLine();
		if (mapSize.isBlank()) {
			mapSize = "10";
		}
		System.out.println("Almuerzos a entregar por dron (3 por defecto):");
		String numberOfDeliveries = scanner.nextLine();
		if (numberOfDeliveries.isBlank()) {
			numberOfDeliveries = "3";
		}
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.getName().startsWith("in")) {
				File file = new File(fileEntry.getName());
				BufferedReader br = new BufferedReader(new FileReader(routesFolder + file));
				Dron dron = new Dron(Integer.valueOf(numberOfDeliveries));
				String entireRoute = "";
				int delivery = 0;
				try {
					String route;
					while ((route = br.readLine()) != null && delivery < Integer.valueOf(numberOfDeliveries)) {
						if (entireRoute.isBlank()) {
							entireRoute = entireRoute.concat(route);
						} else {
							entireRoute = entireRoute.concat("," + route);
						}
						delivery++;
					}
					dron.makeDelivery(entireRoute);
					dron.createReport();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					br.close();
				}
			}
		}
	}

}