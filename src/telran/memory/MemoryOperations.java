package telran.memory;

public class MemoryOperations {
	public static int getMaxAvaibleMemory() {
		
		int left = 0;
		int right = Integer.MAX_VALUE;
		int middle = right / 2;
		int maxMemoryAvailable = 0;
		
		while(left <= right) {
			try {
				byte ar[] = new byte[middle];
				maxMemoryAvailable = middle;
				left = middle + 1;
				
			} catch (Throwable e) {
				right = middle - 1;
				
			}
			middle = left + (right - left) / 2;
		}
		return maxMemoryAvailable;
	}
}
