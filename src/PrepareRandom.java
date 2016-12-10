

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PrepareRandom implements IPrepareTestFile {

	public String prepareFile(List<Integer> input){
		String str="";
		Collections.shuffle(input);
		for(int i=0; i<input.size();i++){
			str=str+(input.get(i).toString()) + "," + " ";
		}
		
		try{
			str=FileHandler.removeComma(str.trim());		
			FileHandler.writeToFile("randomInput.txt", str);		
		}
		catch(IOException e){
			System.out.println("Invalid argument");
		}
		
		System.out.println("Input file for random input exported to the directory");
		return("randomInput.txt");
		
		
			
	}
		
		
		
}

