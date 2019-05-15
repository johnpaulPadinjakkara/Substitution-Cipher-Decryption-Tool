package ComparisonAlgorithm_BruteForce;

import java.util.ArrayList;

public class BruteForce {
	
	public static int count = 0;
	public static boolean stop = true;
	
	

	public BruteForce() {
		// TODO Auto-generated constructor stub
		
		
		
	}
	
	//Implemention of a brute force method to compare the performance and result with our genetic algorithm
	//(Comparisons with other GAs are also provided in the report).
	
	public static void Brute_Force() {
		
		
		
	}

	// Java program to print all permutations of a
	// given string.
	//Code from::
	//(SOURCE) https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
	public static class Permutation
	{
	    /**
	     * permutation function
	     * @param str string to calculate permutation for
	     * @param l starting index
	     * @param r end index
	     */
	    public static int permute(String str, int l, int r)
	    {
	    	
	    	System.out.println("permute");
	    	
	        if (l == r) {
	            System.out.println(str);
	            count++;
	        }
	        else
	        {
	            for (int i = l; i <= r; i++)
	            {
	                str = swap(str,l,i);
	                permute(str, l+1, r);
	                str = swap(str,l,i);
	                if(!stop) {
	                	break ;
	                }
	            }
	        }
	        
	        return count;
	    }
	 
	    /**
	     * Swap Characters at position
	     * @param a string value
	     * @param i position 1
	     * @param j position 2
	     * @return swapped string
	     */
	    public static  String swap(String a, int i, int j)
	    {
	        char temp;
	        char[] charArray = a.toCharArray();
	        temp = charArray[i] ;
	        charArray[i] = charArray[j];
	        charArray[j] = temp;
	        return String.valueOf(charArray);
	    }
	 
	} 

}
