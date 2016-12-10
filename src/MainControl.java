

import java.io.IOException;
import java.util.List;

public class MainControl {
	
	public void AnalyseAlgorithm(){
		
		int[] range;
		List<Integer> inputList;
		//int[] inputArray;
		//int[] outputArray;
		//String outputStr;
		
		TakeRange takeRange = new TakeRange();
		IMakeInputArray makeInput = new RandomInput();
		
		IPrepareTestFile randomTestFile = new PrepareRandom();
		IPrepareTestFile preSortedTestFile = new PreparePreSorted();
		IPrepareTestFile revSortedTestFile = new PrepareRevSorted();
		
		ISort iSort = new InsertionSort();
		ISort cSort = new CountingSort();
		ISort mSort = new MergeSort();
		range = takeRange.SendMaxMinAndSize();
		inputList = makeInput.makeInputArray(range);
		if(inputList == null){
			return;
		}
		
		String randomFileName = randomTestFile.prepareFile(inputList);
		String preSortedFileName = preSortedTestFile.prepareFile(inputList);
		String revSortedFileName = revSortedTestFile.prepareFile(inputList);
		
		int[] randomInputArray = FileHandler.makeArray(randomFileName);
		int[] preSortedInputArray = FileHandler.makeArray(preSortedFileName);
		int[] revSortedInputArray = FileHandler.makeArray(revSortedFileName);
		
		//preparing input files for merge sort
		int[] randomInputArrayMerge = new int[randomInputArray.length];
		int[] preSortedInputArrayMerge = new int[preSortedInputArray.length];
		int[] revSortedInputArrayMerge = new int[revSortedInputArray.length];
		System.arraycopy(randomInputArray, 0, randomInputArrayMerge, 0, randomInputArray.length);
		System.arraycopy(preSortedInputArray, 0, preSortedInputArrayMerge, 0, preSortedInputArray.length);
		System.arraycopy(revSortedInputArray, 0, revSortedInputArrayMerge, 0, revSortedInputArray.length);
		
		//insertion sort average case
		int[] iAvgOutputArray = iSort.sort(randomInputArray,randomInputArray.length);		
		String iAvgOutputStr = "Input Size: " + range[2] + " | " +  "Total time :" + iSort.getTotalTime()+" ms";
		iAvgOutputStr = iAvgOutputStr + System.lineSeparator() + FileHandler.arrayToString(iAvgOutputArray);
			
		//Insertion sort pre-sorted array 
		int[] iBestOutputArray = iSort.sort(preSortedInputArray,preSortedInputArray.length);
		String iBestOutputStr = "Input Size: " + range[2] + " | " + "Total time :" + iSort.getTotalTime()+" ms";
		iBestOutputStr = iBestOutputStr + System.lineSeparator() + FileHandler.arrayToString(iBestOutputArray);
		
		//Insertion sort reverse-sorted array 
		int[] iWorstOutputArray = iSort.sort(revSortedInputArray,revSortedInputArray.length);
		String iWorstOutputStr = "Input Size: " + range[2] + " | " + "Total time :" + iSort.getTotalTime()+" ms";
		iWorstOutputStr = iWorstOutputStr + System.lineSeparator() + FileHandler.arrayToString(iWorstOutputArray);
		System.out.println("Insertion sort completed");
		
		//Counting sort average case
		int[] cAvgOutputArray = cSort.sort(randomInputArray,randomInputArray.length);
		String cAvgOutputStr = "Input Size: " + range[2] + " | " + "Total time :" + cSort.getTotalTime()+" ms";
		cAvgOutputStr = cAvgOutputStr + System.lineSeparator() + FileHandler.arrayToString(cAvgOutputArray);
		
		//Counting sort pre-sorted array
		int[] cBestOutputArray = cSort.sort(preSortedInputArray,preSortedInputArray.length);
		String cBestOutputStr = "Input Size: " + range[2] + " | " + "Total time :" + cSort.getTotalTime()+" ms";
		cBestOutputStr = cBestOutputStr + System.lineSeparator() + FileHandler.arrayToString(cBestOutputArray);
		
		//Counting sort reverse-sorted array
		int[] cWorstOutputArray = cSort.sort(revSortedInputArray,revSortedInputArray.length);
		String cWorstOutputStr = "Input Size: " + range[2] + " | " + "Total time :" + cSort.getTotalTime()+" ms";
		cWorstOutputStr = cWorstOutputStr + System.lineSeparator() + FileHandler.arrayToString(cWorstOutputArray);
		System.out.println("Counting sort completed");
		
		//Merge sort average case
		int[] mAvgOutputArray = mSort.sort(randomInputArrayMerge,randomInputArrayMerge.length);
		String mAvgOutputStr = "Input Size: " + range[2] + " | " + "Total time :" + mSort.getTotalTime()+" ms";
		mAvgOutputStr = mAvgOutputStr + System.lineSeparator() + FileHandler.arrayToString(mAvgOutputArray);
	
		//Merge sort pre-sorted array
		int[] mBestOutputArray = mSort.sort(preSortedInputArrayMerge,preSortedInputArrayMerge.length);
		String mBestOutputStr = "Input Size: " + range[2] + " | " + "Total time :" + mSort.getTotalTime()+" ms";
		mBestOutputStr = mBestOutputStr + System.lineSeparator() + FileHandler.arrayToString(mBestOutputArray);
		
		//Merge sort reverse-sorted array
		int[] mWorstOutputArray = mSort.sort(revSortedInputArrayMerge,revSortedInputArrayMerge.length);
		String mWorstOutputStr = "Input Size: " + range[2] + " | " + "Total time :" + mSort.getTotalTime()+" ms";
		mWorstOutputStr = mWorstOutputStr + System.lineSeparator() + FileHandler.arrayToString(mWorstOutputArray);
		System.out.println("Merge sort completed");
		
		try{
			FileHandler.writeToFile("InsertionSort_randomInputOutput.txt", iAvgOutputStr);
			FileHandler.writeToFile("InsertionSort_PreSortedOutput.txt", iBestOutputStr);
			FileHandler.writeToFile("InsertionSort_RevSortedOutput.txt", iWorstOutputStr);
			FileHandler.writeToFile("CountingSort_randomInputOutput.txt", cAvgOutputStr);
			FileHandler.writeToFile("CountingSort_PreSortedOutput.txt", cBestOutputStr);
			FileHandler.writeToFile("CountingSort_RevSortedOutput.txt", cWorstOutputStr);
			FileHandler.writeToFile("MergeSort_randomInputOutput.txt", mAvgOutputStr); 
			FileHandler.writeToFile("MergeSort_PreSortedOutput.txt", mBestOutputStr);
			FileHandler.writeToFile("MergeSort_RevSortedOutput.txt", mWorstOutputStr);
		}
		catch(IOException e){
			System.out.println("Invalid argument");
		}
		
	}

}
