package extra;

import java.util.Random;

public class ThreadedNumberSorter {
	static final int TOTAL_NUMS = 10000;

	// static final int TOTAL_NUMS = 10;
	// Complete the method below so that it uses threads to sort the integer array.
	// Try to get the completion time as short as possible.
	// Use the printArray method to check sorting accuracy
	public static void parallelSort(int[] nums) {
		long startTime = System.nanoTime();
		// Complete this method starting at this point

		// Thread t1 = new Thread(()-> {int counter = 0; while(counter!=nums.length-1)
		// {compare(counter, nums); counter++;};});

		// Thread t2 = new Thread(()-> {int counter = nums.length-1; while(counter!=0)
		// {compare(counter, nums); counter--;}; });

		// Thread t1 = new Thread(()-> runThread(nums));
		// t1.start();
		Thread t1 = new Thread(()-> runThread2(nums, 0));
		Thread t2 = new Thread(() -> runThread2(nums, 2500));
		Thread t3 = new Thread(() -> runThread2(nums, 5000));
		Thread t4 = new Thread(() -> runThread2(nums, 7500));
		
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		boolean running = true;
		while (running) {
			if(checkThread(nums)) {
				running = false;
			}
		/*	if (!(t2.isAlive() || t1.isAlive() || t3.isAlive() || t4.isAlive())) {
				running = false;
			}*/
		}

		long totalTime = System.nanoTime() - startTime;
		double timeInSeconds = (double) totalTime / 1_000_000_000;
		System.out.println("The total computing time in seconds was: " + timeInSeconds);
	}

	public static void runThread2(int[] nums, int start) {
		int counter = start;
		while (!checkThread(nums)) {
			compare(counter, nums);
			counter++;
			if (counter == nums.length - 1) {
				counter = 0;
			}
		}
	}


	public static boolean checkThread(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i + 1] < nums[i]) {
				return false;
			}
		}
		return true;

	}

	private static int[] compare(int i, int[] nums) {
		if (nums[i + 1] < nums[i]) {
			int holder = nums[i + 1];
			nums[i + 1] = nums[i];
			nums[i] = holder;
			// System.out.println("compare");
		}
		return nums;
	}

	public static void main(String[] args) {
		
		int[] nums = new int[TOTAL_NUMS];

		Random randGen = new Random();
		for (int i = 0; i < TOTAL_NUMS; i++) {
			nums[i] = randGen.nextInt(TOTAL_NUMS);
		}

		//printArray(nums);
		parallelSort(nums);
		printArray(nums);
	}
	
	
	

	private static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	
	
	/*public static void runThread(int[] nums) {

		int counter = 0;
		boolean sort = true;
		while (sort) {
			sort = false;
			for (int i = 0; i < nums.length - 1; i++) {
				if (nums[i + 1] < nums[i]) {
					int holder = nums[i + 1];
					nums[i + 1] = nums[i];
					nums[i] = holder;
					sort = true;
					// System.out.println("compare");
				}
			}
		}

	}*/
}
