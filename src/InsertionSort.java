

public class InsertionSort implements ISort{ 
	
	private long startTime;
	private long stopTime;
	private double totalTime;
	
	public double getTotalTime() {
		return totalTime;
	}


	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}


	public int[] sort(int[] input, int n) {
		
		int[] array = new int[input.length];
		
		//making a copy of initial array.
		System.arraycopy(input, 0, array, 0, input.length);
		
		//start the timer.
		startTime=System.nanoTime();
	
	    for (int j = 1; j < n; j++) {
	        int key = array[j];
	        int i = j-1;
	        while ( (i > -1) && ( array [i] > key ) ) {
	            array [i+1] = array [i];
	            i--;
	        }
	        array[i+1] = key;
	    }
	    
	    //stopping the timer and taking the time difference 
	    stopTime=System.nanoTime();
		totalTime = (stopTime-startTime)/1000.0;
	    return array;
	}
}
