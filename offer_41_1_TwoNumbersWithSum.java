package com.wyw.offer;

public class Offer_41_1_TwoNumbersWithSum {

	public static void main(String[] args) {
	
		int[] array = {1,2,4,7,11,15};
		int sum = 15;
		twoNumbersWithSum(array, 0, array.length - 1, sum);
		
	}
	
	static void twoNumbersWithSum(int[] array, int start, int end, int sum){
		if(array.length < 2){
			System.out.println("the length of array is less than 2.");
			return;
		}
		if(array[start] + array[end] == sum){
			System.out.println(array[start] + " " + array[end]);
		}
		else if(array[start] + array[end] < sum){
			twoNumbersWithSum(array, start + 1, end, sum);
		}
		else{
			twoNumbersWithSum(array, start, end + 1, sum);
		}
	}
}
