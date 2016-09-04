package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Str {
	public static String join(String[] words){
		//String word = "";
		StringBuffer word = new StringBuffer();
		for(String w : words){
			//word = word + w;
			word.append(w);
		}
		
		return  word.toString();
	}
	
	// ArrayList - dynamically resizing array - O(1)
	public static ArrayList<String> merge(String[] words1, String[] words2){
		ArrayList<String> sentence = new ArrayList<String>();
		
		for(String w : words1)
			sentence.add(w);
		
		for(String w : words2)
			sentence.add(w);
		
		return sentence;
	}
	
	//hash tables
	public static HashMap<Integer, String> buildMap(String[] words){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(String w : words){
			int i = 1;
			map.put(i++, w);
		}
		
		return map;
	}
	
	//find the integer twice in the array
	public static int findNumber(int[] arr){
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		for(int num : arr){
			//int i = 1;
			if(map.containsKey(num)){
				return num;
				
			}else{
				map.put(num, num);
			}
		}
		
		return 0;
	}
	
	//One integer is missing in the array ?
	public static int findMissing(int[] arr){
		int res = 0;
		
		for (int i=0; i<arr.length; i++){
			//res ^= (i+1) ^ arr[i];
			res ^= (i+1); // 0 ^ A =A
			res ^=  arr[i];
		}
		
		return res;
	}
	
	public static int findMissing1(int[] arr){
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length;
		int mid = (left+right) /2;
		
		while(left<right){
			mid = (left + right) /2;
			
			if(mid<arr[mid])
				right = mid;
			else
				left = mid+1;
			
		}
		
		return right;
	}
	
	// compress - 
	public static String compress(String str){
		//char[] s = str.toCharArray();
		String mystr = "";
		
		char last = str.charAt(0);
        int count = 1;
        for(int i = 1 ; i<str.length(); i++){
        	if(last == str.charAt(i)){
        		count++;
        	} else {
        		mystr += last + "" + count;
        		
        		last = str.charAt(i);
        		count = 1;
        	}
        }
        
        return mystr + last + count;
	}
	
	// reverse words in a string in-place
	public static String reverseWords(String str){
		if(str == null || str.length() == 0)
			return "";
		
		String[] arr = str.split(" ");
		StringBuffer sb = new StringBuffer();
		for(int i = arr.length -1 ; i >=0; --i){
			if(!arr[i].equals("")){
			//if(arr[i] != ""){
				sb.append(arr[i] + " ");
			}
		}
		
		return sb.toString();
	}
	

	// Fibonacci
	static int fib1(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return fib1(n-1) + fib1(n-2);
	}
	
	// store the intermediate results
	static int fib2(int n){
		if(n ==0)
			return 0;
		
		int[] f = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		
		for(int i =2; i<n+1;i++){
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}
	
	//
	
	
	// test
	public static void main(String args[]){
		String[] words =  {
				"ice", "cream","who","am"
		};
		
		String word = join(words);
		System.out.println(word);
		
		String[] words1 = {"hello", "world", "!"};
		String[] words2 = {"I", "am", "coming"};
		
		String str = merge(words1, words2).toString();
		System.out.println(str);
		
		System.out.println(compress("aabcccccaaa"));
		
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
		
		//int[] arr1 = {};
		
		int[] arr= {0, 1,3,2,4, 5,7};
		//tocheck
		System.out.println(findMissing1(arr));
		//System.out.println(FindNumber(arr));
		//int n = 11;
		//System.out.println(Fib1(n));
		//System.out.println(Fib2(n));
	}

}
