package service;

public class InsertionSort implements ISort{ 
	
	public int[] Sort(int[] array, int n) {
	     int i;
	     if (n > 1) 
	        Sort(array, n - 1);
	     else {
	        int k = array[n];
	        i = n - 1;
	        while (i >= 0  &&  array[i] > k) {
	            array[i + 1] = array[i];
	            i = i - 1;
	        }
	        array[i + 1] = k;
	    }
	    return array;
	 }
	

}
