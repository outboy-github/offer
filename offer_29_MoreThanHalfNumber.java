package com.wyw.offer;

import java.util.Random;

public class Offer_29_MoreThanHalfNumber {

	public static void main(String[] args) {

		int[] array = {1,2,3,2,2,2,5,4,2};
		int result = moreThanHalfNumber(array);
		System.out.println(result);
		
	}
	
	static int moreThanHalfNumber(int[] array){
	
		int result = -1;
		if(array.length == 0){
			return -1;
		}
		int middle = array.length >> 1;
		int index = partition(array, 0, array.length - 1);
		while(index != middle){
			if(index < middle){
				index = partition(array, index + 1, array.length - 1);
			}
			if(index > middle){
				index = partition(array, 0, index - 1);
			}
		}
		result = array[middle];
		if(!isMoreThanHalf(array,middle)){
			return -1;
		}
		return result;
	}
	
	static boolean isMoreThanHalf(int[] array, int middle){
		int times = 0;
		int middleNum = array[middle];
		for(int i = 0; i< array.length; i++){
			if(array[i] == middleNum){
				times++;
			}
		}
		if((times << 1) < array.length){
			return false;
		}
		return true;
	}
	static int partition(int[] array, int start, int end){
		
		int index = new Random().nextInt(end - start) + start;
		int firstBigThanIndex = start - 1;
		swap(array, index, end);
		for(index = start; index <= end; index++){
			if(array[index] < array[end]){
				firstBigThanIndex++;
				if(firstBigThanIndex != index)
				swap(array, firstBigThanIndex, index);
			}
		}
		swap(array, firstBigThanIndex, end);
		
		return firstBigThanIndex;
		
	}
	static void swap(int[] array, int index0, int index1){
		if(array.length != 0){
			int tmp = array[index0];
			array[index0] = array[index1];
			array[index1] = tmp;
		}
	}
}
