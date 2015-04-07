package com.wyw.offer;

public class Offer_47_AddTwoNumbers {

	public static void main(String[] args) {

		int num1 = -9;
		int num2 = 1;
		int result = add(num1, num2);
		System.out.println(result);
	}
	
	static int add(int num1, int num2){
		
		while(num2 != 0){
			int firstResult = num1 ^ num2;
			int secondResult = (num1 & num2) << 1;
			num1 = firstResult;
			num2 = secondResult;
		}
		return num1;
	}
}
