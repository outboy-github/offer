package com.wyw.offer;

public class Offer_34_UglyNumber {

	public static void main(String[] args) {

		int index = 1500;
		UglyNumber(index);
	}
	static void UglyNumber(int index){
		if(index < 1){
			System.out.println("invalid input.");
			return;
		}
		int min = 1;
		int[] uglyNumberArray = new int[index];
		uglyNumberArray[0] = 1;
		int nextIndex = 1;
		int uglyIndex2 = 0;
		int uglyIndex3 = 0;
		int uglyIndex5 = 0;
		while(nextIndex < index){
			 min = Min(uglyNumberArray[uglyIndex2]*2,uglyNumberArray[uglyIndex3]*3,uglyNumberArray[uglyIndex5]*5);
			uglyNumberArray[nextIndex] = min;
			while(uglyNumberArray[uglyIndex2] * 2 <= min){
				uglyIndex2++;
			}
			while(uglyNumberArray[uglyIndex3] * 3 <= min){
				uglyIndex3++;
			}
			while(uglyNumberArray[uglyIndex5] * 5 <= min){
				uglyIndex5++;
			}
			nextIndex++;
		}
		System.out.println(min);
	}
	static int Min(int ugly2, int ugly3, int ugly5){
		
		int min = ugly2 < ugly3 ? ugly2 : ugly3;
		min = min < ugly5 ? min : ugly5;
		return min;
	}
}
