package hw1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
//		String roadFilename = args[0];
//		String cellNetworkFile = args[1];
//		String imageFilename = args[2];
//
//		// Reads in tower txt file
//		CellNetwork cellnetwork = new CellNetwork();
//		try {
//			cellnetwork.cellTowers(new File("cell.txt"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		cellnetwork.printOut();
//
//		// Reads in road txt file
//		try {
//			RoadNetwork roadnetwork = new RoadNetwork(new File("road.txt"));
//			// prints roads
//			roadnetwork.print();
//			// draw roads
//			roadnetwork.drawRoad();			
//			// tests for coverage and writes it in the txt file
//			ReportWriter r = new ReportWriter();
//			r.writeReport(cellnetwork.isCovered(roadnetwork));
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		// draw cell towers
//
//		cellnetwork.drawTowers();
//
//		StdDraw.save("image.png");
		
		OSM reader = new OSM();
		
		reader.readOSMFormat(new File("map.xml"));
//		reader.print();
	}
}
