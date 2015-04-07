package com.wyw.offer;

public class Offer_46_Accumulate {

	public static void main(String[] args) {

		int n = 0;
		Add add = new Add();
		add.add(n);
		System.out.println(add.sum);
	}
	static class Add{
		int sum = 0;
		boolean add(int n){
			sum += n;
			return ((n - 1 <= 0) || add(n-1));
		}
	}
}
