package com.wyw.offer;

public class Offer_41_2_ContinuesSquenceWithSum {

	public static void main(String[] args) {
		int sum = 15;
		continuesSquenceWithSum(sum);
	}
	
	static void continuesSquenceWithSum(int sum){
		if(sum < 1){
			System.out.println("the input is faulty");
			return;
		}
		int small = 1;
		int big = 2;
		int curSum = small + big;
		int middle = (1 + sum) / 2;
		while(small < middle){
			if(curSum == sum){
				print(small, big);
				curSum += ++big;
			}
			else if(curSum < sum){
				curSum += ++big;
			}
			else{
				curSum -= small++;
			}
		}
	}
	
	static void print(int small, int big){
		while(small <= big){
			System.out.print(small + " ");
			small++;
		}
		System.out.println();
	}
}
