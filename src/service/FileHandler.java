package service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	public static void writeToFile(String fileName,String output) throws IOException {
		try{
			File file=new File(fileName);
			FileWriter fileWriter=new FileWriter(file);
			BufferedWriter bufferedOutput=new BufferedWriter(fileWriter);
			bufferedOutput.write(output);
			bufferedOutput.flush();
			bufferedOutput.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static List<Integer> makeArray(String fileName){
		
		List<Integer> outputList = new ArrayList<Integer>();
		File file = new File(fileName);
		BufferedReader br=null;
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
						
			String line;
			String temp[];
			
			while((line = br.readLine()) != null){
				
				//splitting the input using ','.
				temp = line.split(",");
				//loop to put all numbers in list.
				for(int i=0;i<temp.length;i++){		
					outputList.add(Integer.parseInt(temp[i].trim()));
				}
			}			
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
		} catch (IOException e) {
			System.err.println("Input file could not be read");
		}
		return outputList;
	}
	
	public static String removeComma(String str) {
		if (str != null && str.length() > 0 && str.charAt(str.length()-1)==',') {
		      str = str.substring(0, str.length()-1);
		    }
		    return str;
	}


}
