package algorithms;

public class Fibonacci {
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		System.out.println(f.fib(30));
		
	}
	
	
	public String fib(int num) {
		String sequence = "";
		
		for(int i = 1; i <= num; i++) {
			sequence += getFib(i) + " ";
		}
		
		return sequence;
	}
	
	
	
	public int getFib(int num) {
		
		if(num <= 2) {
			return 1;
		}
		
		
		return getFib(num-2) + getFib(num-1);
	}
	
	
}
