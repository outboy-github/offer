package com.wyw.offer;

import java.util.Arrays;

public class Offer_44_ContinousCards {

	public static void main(String[] args) {

		int[] array = {0,0,1,5,4,6};

		boolean result = isContinousCards(array);
		System.out.println(result);
	}
	static boolean isContinousCards(int[] array){
		
		if(array.length == 0){
			return false;
		}
		Arrays.sort(array);
		int numberOfZero = 0;
		int numberOfGap = 0;
		//统计0的个数
		for(int i = 0; i < array.length; i++){
			if(array[i] == 0){
				++numberOfZero;
			}
		}
		//统计数组中间隔数目
		int small = numberOfZero;
		int big = small + 1;
		
		while(big < array.length){
			if(array[small] == array[big]){
				return false;
			}
			numberOfGap += big - small -1;
			small = big++;
		}
		return numberOfGap < numberOfZero ? true : false;
	}
}
