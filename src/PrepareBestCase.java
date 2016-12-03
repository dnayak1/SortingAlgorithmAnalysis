

import java.io.IOException;
import java.util.List;

public class PrepareBestCase implements IPrepareTestFile{
	
	public String prepareFile(List<Integer> input) {
		
		String str="";
		str = FileHandler.listToString(input);
		try{
			str=FileHandler.removeComma(str.trim());
			FileHandler.writeToFile("BestCaseInput.txt", str);
		}
		catch(IOException e){
			System.out.println("Invalid argument");
		}
		
		System.out.println("Input file for best case exported to the directory");
		return ("BestCaseInput.txt");
	}

}
