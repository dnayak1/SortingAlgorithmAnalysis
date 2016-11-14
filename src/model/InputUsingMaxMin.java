package model;

import java.util.ArrayList;
import java.util.List;

public class InputUsingMaxMin implements IMakeInputArray {
	
	public List<Integer> makeArray(int[] inputRange){
		
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		int upperLimit = inputRange[1];
		int lowerLimit = inputRange[0];	
		
		if(upperLimit>lowerLimit && ((upperLimit-lowerLimit)<=100000)){	
			for(int i=lowerLimit;i<=upperLimit;i++){
					numbers.add(i);
				}
			}
		else{
			System.out.println("Invalid input");
		}
		return numbers;
	}
}
