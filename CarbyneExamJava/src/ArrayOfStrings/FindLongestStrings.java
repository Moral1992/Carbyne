package ArrayOfStrings;

import java.util.*;

public class FindLongestStrings {

	public static void main(String[] args)
	{
		
		String []arr = {"cat", "dog", "red", "is", "cow", "elephant"};
		System.out.println(maxLength(arr));
				
	}
	
	
	static Vector<String> maxLength(String []arr)
	{
		Vector<String> ans = new Vector<String>();
	    int maxChars = 0;
	    
	    for(int i = 0; i < arr.length; i++)
	    {	      	 
	        if (maxChars == arr[i].length())
	        {
	        	ans.add(arr[i]);
	        }
	        
	        else if(maxChars < arr[i].length())
	        {
	        	maxChars = arr[i].length();
	        	ans.clear();
	        	ans.add(arr[i]);
	        }	        
	        
	    }
	 
	    return ans;
	}
}
