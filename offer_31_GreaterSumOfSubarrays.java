package com.wyw.offer;

public class Offer_31_GreaterSumOfSubarrays {

	public static void main(String[] args) {
		
		int[] array = {-1,-2,-3,-10,-4,-7,-2,-5};
		greaterSumOfSubarrays(array);
	}
	
	static void greaterSumOfSubarrays(int[] array){
		if(array.length == 0){
			System.out.println("array is null");
			return;
		}
		int sum = array[0];
		int greatSum = array[0];
		for(int i = 1; i < array.length; i++){
			if(sum < 0){
				sum = array[i];
			}
			else{
				sum += array[i];
			}
			if(sum > greatSum){
				greatSum = sum;
			}
		}
		System.out.println(greatSum);
	}
}
