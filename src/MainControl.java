

import java.io.IOException;
import java.util.List;

public class MainControl {
	
	public void AnalyseAlgorithm(){
		
		int[] range;
		List<Integer> inputList;
		int[] inputArray;
		int[] outputArray;
		String outputStr;
		
		String fileName;
		TakeRange takeRange = new TakeRange();
		IMakeInputArray makeInput = new RandomInput();
		IPrepareTestFile testFile = new PrepareAverageCase();
		ISort iSort = new InsertionSort();
		ISort cSort = new CountingSort();
		ISort mSort = new MergeSort();
		range = takeRange.SendMaxMinAndSize();
		inputList = makeInput.makeInputArray(range);
		if(inputList == null){
			return;
		}
		fileName = testFile.prepareFile(inputList);
		inputArray = FileHandler.makeOutputArray(fileName);
		outputArray = sort.sort(inputArray,inputArray.length);
		outputStr = "Total time :" + sort.getTotalTime()+" ms";
		outputStr = outputStr + System.lineSeparator() + FileHandler.arrayToString(outputArray);
		try{
			FileHandler.writeToFile("AverageCaseOutput.txt", outputStr);
		}
		catch(IOException e){
			System.out.println("Invalid argument");
		}
		
	}

}
