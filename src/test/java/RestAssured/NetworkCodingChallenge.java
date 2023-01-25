package RestAssured;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class NetworkCodingChallenge {

	public static void main(String[] args) {
		//int [] arr = {1,2,3,0,1,0,2,0,3};
	//	System.out.println(rearrangeZeros(arr));
		String str1="Hello world";
	    CountNumberOfCharacter(str1);			
	}
	public static HashMap CountNumberOfCharacter(String str ){
		char arr[]=str.toCharArray();
		HashMap<Character,Integer> map= new HashMap<>();
		for (int i = 0; i < arr.length; i++) 
		{
			if (map.containsKey(arr[i]))
			{
				int count=map.get(arr[i])+1;
				map.put(arr[i], count);
			}else 
			{
				map.put(arr[i], 1);
			}

		}
		for(char key:map.keySet())
		{
			if (key!=' ') 
			{
				if (map.get(key)>1)
				{
					System.out.println(key + " appears "+ map.get(key) + " times");	
				}else {
					System.out.println(key + " appears "+ map.get(key) + " time");
				}
			
			}
			
		}
		return map; 
		
	}
	
	
	// Input: [1,2,3,0,1,0,2,0,3]
		public static ArrayList<Integer> rearrangeZeros(int[] input) {
			int count=0;
			ArrayList<Integer>output= new ArrayList();
			for(int i =0 ; i<input.length; i++) {
				if (input[i]==0) {
					count++;
				}else {
					output.add(input[i]);
				}
			}
			while(count>0) {
				output.add(0);
				count--;
			}
			return output;
		}





}
