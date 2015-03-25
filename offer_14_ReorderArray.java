package com.wyw.offer;

public class Offer_14_ReorderArray {

	public static void main(String[] args){
		
		int[] array = {0,-2,2,4,5};
		Function function = new Function();
		int [] result = reorder(array, function);

		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
	}
	static int[] reorder(int[] array, Function function){
		
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
		return array;
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
