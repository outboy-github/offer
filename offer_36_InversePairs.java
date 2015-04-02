package com.wyw.offer;

public class Offer_36_InversePairs {

	public static void main(String[] args) {

		int[] array = {7,5,6,4};
		int result = inversePairs(array);
		System.out.println(result);
	}
	static int inversePairs(int[] array){
		int length = array.length;
		int[] copy = new int[length];
		for(int i = 0; i < length; i++){
			copy[i] = array[i];
		}
		int result = inverse(array, copy, 0, length - 1);
		return result;
	}
	
	static int inverse(int[] array, int[] copy, int start, int end){
		
		if(start == end){
			copy[start] = array[start];
			return 0;
		}
		
		int length = (end - start) / 2;
		
		int left = inverse(copy, array, start, start + length);
		int right = inverse(copy, array, start + length + 1, end);
		
		int i = start + length;
		int j = end;
		int nextIndex = end;
		int count = 0;
		
		while(i >= start && j >= start + length +1){
			if(array[i] > array[j]){
				copy[nextIndex--] = array[i--]; 
				count += j - start - length;
			}
			else{
				copy[nextIndex--] = array[j--];
			}
		}
		
		while(i >= start){
			copy[nextIndex--] = array[i--];
		}
		while(j >= start + length + 1){
			copy[nextIndex--] = array[j--];
		}
		
		return count + left + right;
	}
}
