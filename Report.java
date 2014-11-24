package hw2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Report {

	//Print most points
	//Print best cell config 
	//Prefromance Time
	File file = new File("report.txt"); 
	
	
    public Report(File file) throws IOException {
        // TODO Auto-generated constructor stub
    	if(!file.exists()){
			file.createNewFile();
		}
    }

    public void add(String message) {
        // TODO Auto-generated method stub

    }

    public void write(Road mostpoints, CellNetwork bestCellconfig, long startT, long endT, int numCellTower, double sigma) throws IOException {
 
    	long totalT = endT - startT;
    	FileWriter fw = new FileWriter(file);
    	BufferedWriter bw = new BufferedWriter(fw);
		bw.write("Group: Andrew and Nikko" + "\n");
		bw.write("Number of CellTowers: " + numCellTower + "\n" );
		bw.write("Sigma: " + sigma + "\n");
		bw.write("Road: " + mostpoints.id + " = " + mostpoints.amountOfPoints + "\n");
		bw.write("Best Cell Configuration: " + bestCellconfig + "\n");
		bw.write("Performance time: " + totalT + "ms");
		bw.flush();
		bw.close();
		}
    }
