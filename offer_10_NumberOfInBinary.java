package com.wyw.offer;

public class Offer_10_NumberOfInBinary {

	public static void main(String[] args){

		int num = 2;
		int times = numberOf1(num);
		System.out.println("the number of 1 is : " + times);
		
	}
	static int numberOf1(int n){
		int times = 0;
		while(n != 0){
			n = (n - 1) & n;
			times++;
		}
		return times;
		
	}
}
