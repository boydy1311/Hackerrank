package com.hackerrank.kieran.math.medium;

import java.util.*;

public class SpecialMultiple {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SpecialMultiple s = new SpecialMultiple();
        long[] sequence = new long[5000];
        sequence = s.generateSequence();
        
        while(true){
        	String input = in.nextLine();
        	try{
        		int n = Integer.parseInt(input);
        		System.out.println(s.getSmallestDivisor(sequence,n));
        	}
        	catch(Exception e){
        		System.out.println("Please enter a valid number");
        	}
        }
        
    }
    
    public long getSmallestDivisor(long[] seq, int n){
		
		long result = 0;
		for(long s : seq){
			if(s % n == 0 ){
				 result = s;
				 break;
			}
		}
		return result;
	}
	
	public long[] generateSequence(){
		
		long[] sequence = new long[5000];
		int number = 1;
		for(int i = 0 ; number <  5001 ; i++, number++){
			
			sequence[i] = Long.parseLong(getNextNum(number));
		}
		return sequence;
	}
	
	
	private String getNextNum(int n){
		String result = "";
		if(n==0){
			return "0";
		}
		else if(n==1){
			return "9";
		}
		else{
			
			int temp = n % 2; //0
			result = temp == 1 ? "9" : "0";
			return getNextNum(n/2) + result;
		}
	}
}