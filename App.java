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
        final String roadFilename = args[0];
        final String imageFilename = args[1];
        final String reportFilename = args[2];
        final int numCellTower = Integer.parseInt(args[3]);
        final double sigma = Double.parseDouble(args[4]);
      

        final boolean isOSM = true;
      
        RoadNetwork roadNetwork;
		try {
			File file = new File(roadFilename);
			roadNetwork = new RoadNetwork(file, isOSM);
			roadNetwork.draw();
	        
	        for(Road road: roadNetwork.roads){
	        	road.setPointAmount();
	        	//System.out.println(road.id + ": " + road.getTotalPointAmount());
	        }
	        
	        Road mostPoints= roadNetwork.hasMostPoints();  //road with the most post points in the road network
	       // System.out.println(mostPoints);
	        
	        long startTime = System.currentTimeMillis();
	        
//	        int numcellTow = 3;
//	        double sigma = 0.2;
	        
	        ArrayList<CellNetwork> cellNetworkConfigurations =
	                mostPoints.getAllCellConfigurations(numCellTower, sigma);
	        
	        
	        for(CellNetwork networks: cellNetworkConfigurations)
        	networks.setAmountOfCoveredPoints(mostPoints);
	        
	        
	        
	        CellNetwork bestCellConfiguration = null;
	        
	        int bestScore = 0;
	        int count = 0;
	      
	        for (CellNetwork cn : cellNetworkConfigurations) {
	            // do test on cn to see if cn's score is better than bestScore
	            // if it is update bestCellConfiguration = cn
	        	for(int i = 0; i < cn.towers.size(); i++ ){		
	        		for(int j = 0; j < cn.towers.size(); j++ ){ // individually compares each tower against each other
	        			if(cn.towers.get(i).u < cn.towers.get(j).u && cn.towers.get(i).z < cn.towers.get(j).z){ //compares Xs()/Ys() + radius with other towers'
	        				System.out.println(cn);
	        				RoadNetwork.deletedTowers.add(cn); //if its true then it adds it to an arrayList of deleted towers
	        				cn.clear();
	        				
           		}
	        	}
           }
	        	
	        	System.out.println(count++);
	        	if(cn.pointsCovered() > bestScore){
	        		bestScore = cn.coveredPoints;
	        		bestCellConfiguration = cn;
	 
	        	}
	        		
	        }
	        System.out.println(roadNetwork.deletedTowers);
//	        System.out.println("Best Score: " +  bestScore);
//	        System.out.println("Best CellConfiguration: " +  bestCellConfiguration);
	        bestCellConfiguration.draw();
	       
	        long finishTime = System.currentTimeMillis();
			try {
				File file2 = new File(reportFilename);
				Report re = new Report(file2);
				re.write(mostPoints, bestCellConfiguration, startTime, finishTime);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//		System.out.println("xmax: " + Boundaries.xmax);
//		System.out.println("xmin: " + Boundaries.xmin);
//		System.out.println("ymax: " + Boundaries.ymax);
//		System.out.println("ymin: " + Boundaries.ymin);
		
		
//
        StdDraw.save(imageFilename);
			
    }
}
