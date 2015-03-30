package com.wyw.offer;

public class Offer_31_GreaterSumOfSubarrays {

	public static void main(String[] args) {

		int[] array = {1,-2,3,10,-4,7,2,-5};
		
		greaterSumOfSubarrays(array);
	}
	
	static void greaterSumOfSubarrays(int[] array){
		if(array.length == 0){
			System.out.println("array is null");
			return;
		}
		int sum = 0;
		int greatSum = 0;
		for(int i : array){
			if(sum <= 0){
				sum = i;
			}
			else{
				sum += i;
			}
			if(sum > greatSum){
				greatSum = sum;
			}
		}
		System.out.println(greatSum);
	}
}
