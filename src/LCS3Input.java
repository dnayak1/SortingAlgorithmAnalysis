
public class LCS3Input {  
	
	public static String findLcs(String input1, String input2,String input3)
	{
        int l1 = input1.length();
        int l2 = input2.length();
        int l3 = input3.length();
 
        int[][][] arr = new int[l1 + 1][l2 + 1][l3 + 1];
 
        for (int i = l1 - 1; i >= 0; i--)
        {
            for (int j = l2 - 1; j >= 0; j--)
            {
            	for(int k = l3 - 1;k >= 0;k--)
            	{
            		if (input1.charAt(i) == input2.charAt(j) && input1.charAt(i) == input3.charAt(k) && input2.charAt(j) == input3.charAt(k))
	                    arr[i][j][k] = arr[i + 1][j + 1][k + 1] + 1;
	                else 
	                    arr[i][j][k] = Math.max(Math.max(arr[i + 1][j][k], arr[i][j + 1][k]),arr[i][j][k+1]);
            	}
                
            }
        }
 
        int i = 0, j = 0,k=0;
        StringBuffer sb = new StringBuffer();
        while (i < l1 && j < l2 && k < l3) 
        {
            if (input1.charAt(i) == input2.charAt(j) && input1.charAt(i) == input3.charAt(k) && input2.charAt(j) == input3.charAt(k)) 
            {
                sb.append(input1.charAt(i));
                i++;
                j++;
                k++;
            }
            else if (arr[i + 1][j][k] >= arr[i][j + 1][k] && arr[i + 1][j][k] >= arr[i][j][k + 1]) 
                i++;
            else if (arr[i][j + 1][k] >= arr[i][j][k + 1]  && arr[i][j + 1][k] >= arr[i + 1][j][k])
                j++;
            else
                k++;
        }
        return sb.toString();
    }
	
}
