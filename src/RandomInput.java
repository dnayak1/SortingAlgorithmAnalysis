

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomInput implements IMakeInputArray{

	public List<Integer> makeInputArray(int[] inputRange){
		
		Random rand = new Random();
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		int upperLimit = inputRange[1];
		int lowerLimit = inputRange[0];	
		int inputSize = inputRange[2];
	//((upperLimit-lowerLimit)<=100000) &&
		if(upperLimit>lowerLimit && inputSize<(upperLimit-lowerLimit)){	
			for(int i=0;i<inputSize;i++){
				numbers.add(rand.nextInt((upperLimit - lowerLimit) + 1) + lowerLimit);
			}
		}
		else{
			System.out.println("Invalid input");
		}
		return numbers;
	}
}
