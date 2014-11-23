package hw2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
//        final String roadFilename = args[0];
//        final String imageFilename = args[1];
//        final String reportFilename = args[2];
//        final int numCellTower = Integer.parseInt(args[3]);
//        final double sigma = Double.parseDouble(args[4]);

        final boolean isOSM = true;

        RoadNetwork roadNetwork;
		try {
			roadNetwork = new RoadNetwork(new java.io.File("map.xml"), isOSM);
			roadNetwork.draw();
	        
	        for(Road road: roadNetwork.roads){
	        	road.setPointAmount();
	        	System.out.println(road.id + ": " + road.getTotalPointAmount());
	        }
	        
	        Road mostPoints= roadNetwork.hasMostPoints();  //road with the most post points in the road network
	        System.out.println(mostPoints);
	        
	        long startTime = System.currentTimeMillis();
	        
	        int numcellTow = 3;
	        double sigma = 0.2;
	        
	        ArrayList<CellNetwork> cellNetworkConfigurations =
	                mostPoints.getAllCellConfigurations(numcellTow, sigma);
	        
	        
	        for(CellNetwork networks: cellNetworkConfigurations)
        	networks.setAmountOfCoveredPoints(mostPoints);
	        
	        
	        
	        CellNetwork bestCellConfiguration = null;
	        
	        int bestScore = 0;
	      
	        for (CellNetwork cn : cellNetworkConfigurations) {
	            // do test on cn to see if cn's score is better than bestScore
	            // if it is update bestCellConfiguration = cn
	        	System.out.println(cn.towers);
	        	if(cn.pointsCovered() > bestScore){
	        		bestScore = cn.coveredPoints;
	        		bestCellConfiguration = cn;
	 
	        	}
	        		
	        }
	        System.out.println("Best Score: " +  bestScore);
	        System.out.println("Best CellConfiguration: " +  bestCellConfiguration);
	        bestCellConfiguration.draw();
	       
	        long finishTime = System.currentTimeMillis();
			try {
				Report re = new Report(new File("report.txt"));
				re.write(mostPoints, bestCellConfiguration, startTime, finishTime, numcellTow, sigma);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		System.out.println("xmax: " + Boundaries.xmax);
		System.out.println("xmin: " + Boundaries.xmin);
		System.out.println("ymax: " + Boundaries.ymax);
		System.out.println("ymin: " + Boundaries.ymin);
		
		

        /*
         * Get a list of all of the cellular network configurations
         */

        
//        ArrayList<CellNetwork> cellNetworkConfigurations =
//                mostPoints.getAllCellConfigurations(numCellTower, sigma);
//        
//        for(CellNetwork networks: cellNetworkConfigurations)
//        	networks.setAmountOfCoveredPoints(mostPoints);      //fill in the counters for the numbers of covered points for each
//        														//cell network
//        
//        
//        CellNetwork bestCellConfiguration = null;
//        
//        int bestScore = 0;
//      
//        for (CellNetwork cn : cellNetworkConfigurations) {
//            // do test on cn to see if cn's score is better than bestScore
//            // if it is update bestCellConfiguration = cn
//        	if(cn.pointsCovered() > bestScore){
//        		bestScore = cn.coveredPoints;
//        		bestCellConfiguration = cn;
//        	}
//        		
//        }
//        
//        bestCellConfiguration.draw();
//        
//
//        /*
//         * Everything is done
//         * 
//         */
//
        StdDraw.save("map.png");
//        Report report = 
//                new Report(new java.io.File(reportFilename));
//        report.write();
		
		
    }
}
