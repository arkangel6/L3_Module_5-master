
public class Snake {

	int viciousness;
	boolean venomous;
	
	public Snake(int vi, boolean ve) {
		viciousness = vi;
		venomous = ve;
	}
	
	
	
	public boolean getVenom() {
		return venomous;
	}
	
	public int getViciousness() {
		return viciousness;
	}
}
