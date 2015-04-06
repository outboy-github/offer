package com.wyw.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer_40_NumbersAppearOnce {

	public static void main(String[] args) {
	
		int[] array = {2,4,3,6,3,2,5,5};
		List<Integer> result = new ArrayList<Integer>();
		result = findNumbersAppearOnce(array);
		if(result == null){
			System.out.println("the length of array is less than 2.");
		}
		else{
			for(int i : result){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	static List<Integer> findNumbersAppearOnce(int[] array){
		List<Integer> result = new ArrayList<Integer>();
		int num = 0;
		int num1 = 0;
		int num2 = 0;
		if(array.length < 2){
			return null;
		}
		else{
			int n = findIndexOfThefirst1(array);
			for(int i = 0; i < array.length; i++){
				if(isBitOf1(array[i], n)){
					num1 ^= array[i];
				}
				else{
					num2 ^= array[i];
				}
			}
			result.add(num1);
			result.add(num2);
			return result;
		} 
	}		
	
	static boolean isBitOf1(int num, int n){
		num = num >> n;
		return ((num & 1) == 0) ? false : true;
	}
	
	static int findIndexOfThefirst1(int[] array){
		
		int result = array[0];
		for(int i = 1; i < array.length; i++){
			result ^= array[i]; 
		}
		int index = 0;
		while((result & 1) == 0 && index < Integer.MAX_VALUE){
			result = result >> 1;
			index++;
		}
		return index;
	}
}
