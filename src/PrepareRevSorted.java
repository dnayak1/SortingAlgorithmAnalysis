

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PrepareRevSorted implements IPrepareTestFile {

	public String prepareFile(List<Integer> input) {
		String str="";
		Collections.sort(input);
		Collections.reverse(input);
		for(int i=0; i<input.size();i++){
			str=str+(input.get(i).toString()) + "," + " ";
		}
		
		try{
			str=FileHandler.removeComma(str.trim());		
			FileHandler.writeToFile("revSortedInput.txt", str);		
		}
		catch(IOException e){
			System.out.println("Invalid argument");
		}
	
		System.out.println("Input file for rev sorted exported to the directory");
		return ("revSortedInput.txt");	
	}
		
		
		
}
