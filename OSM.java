package hw1;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList; 


public class OSM {
	ArrayList<Point> points = new ArrayList<Point>();
	HashMap<Integer, Point> hashPoints = new HashMap<Integer, Point>();
	ArrayList<Integer> refs = new ArrayList<Integer>();
	
	public void readOSMFormat(File file){
		//extract boundaries
//		try{
//			Scanner scanner = new Scanner(file);
//			while(scanner.hasNext()){
//				String line = scanner.nextLine().replace("^\\s+", "");
//				if(line.startsWith("<bounds")){
//					double xmin = Double.parseDouble(extractStringFromVal(line, "minlat"));
//					double ymin = Double.parseDouble(extractStringFromVal(line, "minlon"));
//					double xmax = Double.parseDouble(extractStringFromVal(line, "maxlat"));
//					double ymax = Double.parseDouble(extractStringFromVal(line, "maxlon"));
////					Boundaries.update(line);
//					System.out.println(xmin);
//				}
//				}
//			scanner.close();
//		}catch (Exception ex){
//			return;
//		}	
		
		try{
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()){
				String line = scanner.nextLine().replace("^\\s+", "");
				if(line.startsWith("<node")){
//			int id = Integer.parseInt(extractStringFromVal(line, "id"));
//			double x = Double.parseDouble(extractStringFromVal(line, "lat"));
//			double y = Double.parseDouble(extractStringFromVal(line, "lon"));
			Point p = new Point(line, true);
			points.add(p);
			hashPoints.put(p.id, p);
			System.out.println(p);
			
		}}
			
		}catch (Exception ex){
			return;
		}
//		
//		try{
//			Scanner scanner = new Scanner(file);
//			while(scanner.hasNext()){
//				String line = scanner.nextLine().replace("^\\s+", "");
//		 if(line.startsWith("<way")){
//			int id = Integer.parseInt(extractStringFromVal(line, "id"));
//			
//		}}
//			
//		}catch (Exception ex){
//			return;
//		}
//		
//		try{
//			Scanner scanner = new Scanner(file);
//			while(scanner.hasNext()){
//				String line = scanner.nextLine().replace("^\\s+", "");
//			if(line.startsWith("<nd")){
//			int ref = Integer.parseInt(extractStringFromVal(line, "ref"));
//			refs.add(ref);
//			System.out.println(ref);
//			
//			}}}catch (Exception ex){
//				return;
//			}
		
	}
	
	
	static String extractStringFromVal(String haystack, String needle) {
        String[] array = haystack.split("\\s+");
        for (String a : array) {
            String[] b = a.split("=");
            if (b.length != 2) {
                continue;
            }
            String key = b[0];
            String val = b[1];
            if(needle.compareToIgnoreCase(key) == 0) {
                return val.replaceAll("\"", "");
            }
        }

        return null;
    }

	public void print(){
		
		for(int i =0; i <points.size(); i++){
		System.out.println(points);
		}
		
		for(int i=0; i<refs.size(); i++){
			System.out.println(refs);
		}
	}
}

