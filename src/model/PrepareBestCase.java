package model;

import java.io.IOException;
import java.util.List;

import service.FileHandler;

public class PrepareBestCase implements IPrepareTestFile{
	
	public void prepareFile(List<Integer> input) {
		
		String str="";
		for(int i=0; i<input.size();i++){
			str=str+(input.get(i).toString()) + "," + " ";
		}
		try{
			str=FileHandler.removeComma(str.trim());
			FileHandler.writeToFile("BestCaseInput.txt", str);
		}
		catch(IOException e){
			System.out.println("Invalid argument");
		}
		
		System.out.println("Input file for best case exported to the directory");						
	}

}
