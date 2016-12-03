

import java.util.Scanner;

public class TakeRange {
	
	public int[] SendMaxMinAndSize(){
		
		int range[] = new int[3];
		Scanner sc=new Scanner(System.in);
		
		try{	
			System.out.println("Enter the lower limit of the range of numbers in file and range should not exceed 100000 numbers");
			range[0]=sc.nextInt();
			
			System.out.println("Enter the upper limit of the range ");
			range[1]=sc.nextInt();
			
			System.out.println("Enter the size of input");
			range[2]=sc.nextInt();	
			
			sc.close();
			
			return range;
			}
		catch(NumberFormatException e){
			System.out.println("Please enter a valid number");
		}
			
		return range;
		
	}

}
