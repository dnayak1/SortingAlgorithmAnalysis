

public class CountingSort implements ISort{ 
	
	private long startTime;
	private long stopTime;
	private double totalTime;
	
	
	public double getTotalTime() {
		return totalTime;
	}


	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}
	
	public int[] sort(int[] array,int n) {
        
		if (n == 0)
            return array;
		
        int max = array[0];
        int min = array[0];
        
        for (int i = 1; i < n; i++)
        {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        
        int range = max - min + 2;
 
        int[] count = new int[range];
        
        for (int i = 0; i < n; i++)
            count[array[i] - min]++;
        	//count[array[i]] = count[array[i]] + 1;

        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];

        int j = 0;
        for (int i = 0; i < range; i++)
        {
            while (j < count[i])
            {
                array[j++] = i + min;
            }
        }
        
        /*int[] sortedArray = new int[n+1];
        
        for (int i = n; i>=0; i--){
        	sortedArray[count[array[i]]] = array[i];
        	count[array[i]]--;
        }
        
        return sortedArray;*/
        return array;
        
    }

}
