import java.util.ArrayList;

import data_structures.Randomnesss;

public class Plane {
	
	int numberOfPassengers;
	ArrayList<Snake> list;
	
	public Plane() {
		
		Randomnesss r = new Randomnesss();
		list = new ArrayList<Snake>();
		for(int i = 0; i < 100; i++) {
			list.add(new Snake(r.getRandomNumber(), r.getRandomBoolean()));
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Plane p = new Plane();
		int total = 0;
		for(int i = 0; i < p.list.size(); i++) {
			if(p.list.get(i).getVenom()) {
			total += p.list.get(i).getViciousness();
			}
		}
		
		p.numberOfPassengers = 50;
		
		double percent = (total*10)/p.numberOfPassengers;
		
		if(percent >= 100) {
			percent = 100;
		}
		System.out.println(percent);
		
		
		
	}
	
}
