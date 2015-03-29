package com.wyw.offer;

public class Offer_28_StringPermutation {

	public static void main(String[] args) {

		String string = "abc";
		char[] array = string.toCharArray();
		permutation(array, 0, array.length - 1);
		
	}
	static void permutation(char[] array, int start, int end){
		if(start == end){
			System.out.println(array);
			return;
		}
		for(int i = start; i <= end; i++){
			char tmp = array[i];
			array[i] = array[start];
			array[start] = tmp;
			
			permutation(array, start + 1, end);
			
			tmp = array[start];
			array[start] = array[i];
			array[i] = tmp;
		}
	}
}
