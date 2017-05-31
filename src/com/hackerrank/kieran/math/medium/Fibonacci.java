package com.hackerrank.kieran.math.medium;

import java.util.*;

public class Fibonacci {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        while(true){
            Fibonacci f = new Fibonacci();
            String input = in.nextLine(); 
            try{
            	long n = Long.parseLong(input);
                System.out.println(f.isFib(n));
            }
            catch(Exception e){
            	System.out.println("Please enter a valid number.");
            }
        }
    }
        
    public Fibonacci(){
        fibs.add((long) 0);
		fibs.add((long) 1);
    }
        
    private int position = 2;
	private int count = 0;
    ArrayList<Long> fibs = new ArrayList<Long>();
        
    public ArrayList<Long> partialFibs(ArrayList<Long> fs, int start, int end){
		
		long previous1 = (long) fs.get(position-1);
		long previous2 = (long) fs.get(position-2);
		Long nextFib = previous1 + previous2;
		
		fs.add(nextFib);
		position++;
		count++;
		
		return (count) == end ? fs : partialFibs(fibs,start,end);
	}
	
	public String isFib(long n){
		position = 2;
		count = 0;	
		ArrayList<Long> partialList = partialFibs(fibs,0,100/*(int) Math.pow(10, 10)*/);
		
		return searchFibs(partialList,n, 0, 100);
	}
	
	public String searchFibs(ArrayList<Long> fs, long n, int start, int end){
		
		if(n <= fs.get(end)){
			int key = Collections.binarySearch(fs,n);
			return (key < 0 || n != fibs.get(key) ? "IsNotFibo" : "IsFibo");
		}
		else{
			return "IsNotFibo";
		}
	}
}