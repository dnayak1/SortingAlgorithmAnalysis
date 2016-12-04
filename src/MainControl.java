

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
		IPrepareTestFile averageTestFile = new PrepareAverageCase();
		IPrepareTestFile bestTestFile = new PrepareBestCase();
		IPrepareTestFile worstTestFile = new PrepareWorstCase();
		ISort iSort = new InsertionSort();
		ISort cSort = new CountingSort();
		ISort mSort = new MergeSort();
		range = takeRange.SendMaxMinAndSize();
		inputList = makeInput.makeInputArray(range);
		if(inputList == null){
			return;
		}
		String averageFileName = averageTestFile.prepareFile(inputList);
		String bestFileName = bestTestFile.prepareFile(inputList);
		String worstFileName = worstTestFile.prepareFile(inputList);
		int[] avgInputArray = FileHandler.makeOutputArray(averageFileName);
		int[] bestInputArray = FileHandler.makeOutputArray(bestFileName);
		int[] worstInputArray = FileHandler.makeOutputArray(worstFileName);
		
		//insertion sort average case
		int[] iAvgOutputArray = iSort.sort(avgInputArray,avgInputArray.length);		
		String iAvgOutputStr = "Total time :" + iSort.getTotalTime()+" ms";
		iAvgOutputStr = iAvgOutputStr + System.lineSeparator() + FileHandler.arrayToString(iAvgOutputArray);
			
		//Insertion sort pre-sorted array 
		int[] iBestOutputArray = iSort.sort(bestInputArray,bestInputArray.length);
		String iBestOutputStr = "Total time :" + iSort.getTotalTime()+" ms";
		iBestOutputStr = iBestOutputStr + System.lineSeparator() + FileHandler.arrayToString(iBestOutputArray);
		
		//Insertion sort reverse-sorted array 
		int[] iWorstOutputArray = iSort.sort(worstInputArray,worstInputArray.length);
		String iWorstOutputStr = "Total time :" + iSort.getTotalTime()+" ms";
		iWorstOutputStr = iWorstOutputStr + System.lineSeparator() + FileHandler.arrayToString(iWorstOutputArray);
		
		//Counting sort average case
		int[] cAvgOutputArray = cSort.sort(avgInputArray,avgInputArray.length);
		String cAvgOutputStr = "Total time :" + cSort.getTotalTime()+" ms";
		cAvgOutputStr = cAvgOutputStr + System.lineSeparator() + FileHandler.arrayToString(cAvgOutputArray);
		
		//Counting sort pre-sorted array
		int[] cBestOutputArray = cSort.sort(bestInputArray,bestInputArray.length);
		String cBestOutputStr = "Total time :" + cSort.getTotalTime()+" ms";
		cBestOutputStr = cBestOutputStr + System.lineSeparator() + FileHandler.arrayToString(cBestOutputArray);
		
		//Counting sort reverse-sorted array
		int[] cWorstOutputArray = cSort.sort(worstInputArray,worstInputArray.length);
		String cWorstOutputStr = "Total time :" + cSort.getTotalTime()+" ms";
		cWorstOutputStr = cWorstOutputStr + System.lineSeparator() + FileHandler.arrayToString(cWorstOutputArray);
		
		//Merge sort average case
		int[] mAvgOutputArray = mSort.sort(avgInputArray,avgInputArray.length);
		String mAvgOutputStr = "Total time :" + mSort.getTotalTime()+" ms";
		mAvgOutputStr = mAvgOutputStr + System.lineSeparator() + FileHandler.arrayToString(mAvgOutputArray);
	
		//Merge sort pre-sorted array
		int[] mBestOutputArray = mSort.sort(bestInputArray,bestInputArray.length);
		String mBestOutputStr = "Total time :" + mSort.getTotalTime()+" ms";
		mBestOutputStr = mBestOutputStr + System.lineSeparator() + FileHandler.arrayToString(mBestOutputArray);
		
		//Merge sort reverse-sorted array
		int[] mWorstOutputArray = mSort.sort(worstInputArray,worstInputArray.length);
		String mWorstOutputStr = "Total time :" + mSort.getTotalTime()+" ms";
		mWorstOutputStr = mWorstOutputStr + System.lineSeparator() + FileHandler.arrayToString(mWorstOutputArray);
		
		try{
			FileHandler.writeToFile("InsertionSort_AverageCaseOutput.txt", iAvgOutputStr);
			FileHandler.writeToFile("InsertionSort_PreSortedOutput.txt", iBestOutputStr);
			FileHandler.writeToFile("InsertionSort_RevSortedOutput.txt", iWorstOutputStr);
			FileHandler.writeToFile("CountingSort_AverageCaseOutput.txt", cAvgOutputStr);
			FileHandler.writeToFile("CountingSort_PreSortedOutput.txt", cBestOutputStr);
			FileHandler.writeToFile("CountingSort_RevSortedOutput.txt", cWorstOutputStr);
			FileHandler.writeToFile("MergeSort_AverageCaseOutput.txt", mAvgOutputStr);
			FileHandler.writeToFile("MergeSort_PreSortedOutput.txt", mBestOutputStr);
			FileHandler.writeToFile("MergeSort_RevSortedOutput.txt", mWorstOutputStr);
		}
		catch(IOException e){
			System.out.println("Invalid argument");
		}
		
	}

}
