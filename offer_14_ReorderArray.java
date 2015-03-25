package com.wyw.offer;

import java.util.Arrays;

public class Offer_14_ReorderArray {

	public static void main(String[] args){
		
		int[] array = {1,-2,2,4,5};
		Function function = new Function();
		reorder(array, function);
		System.out.println(Arrays.toString(array));
	}
	static void reorder(int[] array, Function function){
		
		if(array == null && array.length <=1){
			return;
		}
		int start = 0;
		int end = array.length - 1;
		while(start < end){
			
			while(start < end && !function.isEven(array[start])){
				start++;
			}
			while(start < end && function.isEven(array[end])){
				end--;
			}
			if(start < end){
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
			}
		}
	}

	 static class Function{
		static boolean isEven(int num){
			boolean result = true;
			if((num & 1) == 1)
				result = false;
			return result;
		}
	}
}
