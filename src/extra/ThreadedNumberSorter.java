package extra;

import java.util.Random;

public class ThreadedNumberSorter {
	//static final int TOTAL_NUMS = 10000;
	static final int TOTAL_NUMS = 10;
	//Complete the method below so that it uses threads to sort the integer array.
	//Try to get the completion time as short as possible.
	//Use the printArray method to check sorting accuracy
	public static void parallelSort(int[] nums) {
		long startTime = System.nanoTime();
		//Complete this method starting at this point
		
		Thread t1 = new Thread(()-> {int counter = 0; while(counter!=nums.length-1) {compare(counter, nums); counter++;};});
		
		Thread t2 = new Thread(()-> {int counter = nums.length; while(counter!=0) {compare(counter, nums); counter--;}; });
		
		t1.start();
		t2.start();
		
		long totalTime = System.nanoTime() - startTime;
		double timeInSeconds = (double)totalTime / 1_000_000_000;
		System.out.println("The total computing time in seconds was: " + timeInSeconds);
	}
	
	private static int[] compare(int i, int[] nums) {
		if(nums[i+1] < nums[i]) {
			int holder = nums[i+1];
			nums[i+1] = nums[i];
			nums[i] = holder;
			System.out.println("compare");
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] nums = new int[TOTAL_NUMS];

		Random randGen = new Random();
		for (int i = 0; i < TOTAL_NUMS; i++) {
			nums[i] = randGen.nextInt(TOTAL_NUMS);
		}

		printArray(nums);
		parallelSort(nums);
		printArray(nums);
	}
	
	private static void printArray(int[] nums){
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
