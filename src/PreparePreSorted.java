

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PreparePreSorted implements IPrepareTestFile{
	
	public String prepareFile(List<Integer> input) {
		
		String str="";
		Collections.sort(input);
		str = FileHandler.listToString(input);
		try{
			str=FileHandler.removeComma(str.trim());
			FileHandler.writeToFile("preSortedInput.txt", str);
		}
		catch(IOException e){
			System.out.println("Invalid argument");
		}
		
		System.out.println("Input file for pre sorted exported to the directory");
		return ("preSortedInput.txt");
	}

}
