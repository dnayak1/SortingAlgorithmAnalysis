
public class LCS {  
	
	public static String findLcs(String input1, String input2)
	   	{
	        int l1 = input1.length();
	        int l2 = input2.length();
	 
	        int[][] arr = new int[l1 + 1][l2 + 1];
	 
	        for (int i = l1 - 1; i >= 0; i--)
	        {
	            for (int j = l2 - 1; j >= 0; j--)
	            {
	                if (input1.charAt(i) == input2.charAt(j))
	                    arr[i][j] = arr[i + 1][j + 1] + 1;
	                else 
	                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
	            }
	        }
	 
	        int i = 0, j = 0;
	        StringBuffer sb = new StringBuffer();
	        while (i < l1 && j < l2) 
	        {
	            if (input1.charAt(i) == input2.charAt(j)) 
	            {
	                sb.append(input1.charAt(i));
	                i++;
	                j++;
	            }
	            else if (arr[i + 1][j] >= arr[i][j + 1]) 
	                i++;
	            else
	                j++;
	        }
	        return sb.toString();
	    }
	

}
