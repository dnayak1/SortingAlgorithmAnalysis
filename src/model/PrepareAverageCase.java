package model;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import service.FileHandler;

public class PrepareAverageCase implements IPrepareTestFile {

	public void prepareFile(List<Integer> input){
		String str="";
		Collections.shuffle(input);
		for(int i=0; i<input.size();i++){
			str=str+(input.get(i).toString()) + "," + " ";
		}
		
		try{
			str=FileHandler.removeComma(str.trim());		
			FileHandler.writeToFile("AverageCaseInput.txt", str);		
		}
		catch(IOException e){
			System.out.println("Invalid argument");
		}
		
		System.out.println("Input file for average case exported to the directory");
			
	}
		
		
		
}

