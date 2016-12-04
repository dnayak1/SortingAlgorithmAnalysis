

public class MergeSort implements ISort{ 
	
	private long startTime;
	private long stopTime;
	private double totalTime;
	
	
	public double getTotalTime() {
		return totalTime;
	}


	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}
	
	public int[] sort(int array[],int n) {
		startTime=System.nanoTime();
		
        if (n < 2)
            return array;
        int mid = n / 2;
        int leftSize = mid;
        int rightSize = n - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];

        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = array[i];
        }
        sort(left,left.length);
        sort(right,right.length);
        merge(left, right, array);
        stopTime=System.nanoTime();
		totalTime = (stopTime-startTime)/1000.0;
        return array;
    }

    public static void merge(int[] left, int[] right, int[] arr) {
     
    	int leftSize = left.length;
    	int rightSize = right.length;
    	
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while (j < rightSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

}
