package data_structures;

public class Randomnesss {
	
	public boolean getRandomBoolean() {
		int i = (int)(Math.random()*2)+1;
		
		if(i == 1) {
			return true;
		}
		
			return false;
		
	}
	
	public int getRandomNumber() {
		
		int i = (int)(Math.random()*10)+1;
		
		return i;
		
	}
}
