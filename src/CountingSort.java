

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
		startTime=System.nanoTime();
        
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
        stopTime=System.nanoTime();
		totalTime = (stopTime-startTime)/1000.0;
        return array;
        
    }

}
