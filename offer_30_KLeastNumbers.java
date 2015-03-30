package com.wyw.offer;

public class Offer_30_KLeastNumbers {

	public static void main(String[] args) {

		int[] array = {4,5,1,6,2,7,3,8};
		int k = 4;
//	kLeastNumbers_1(array, k);
		kLeastNumbers_2(array, k);
		for(int i : array){
			System.out.print(i + " ");
		}
	}
//	method_1
	static void kLeastNumbers_1(int[] array, int k){
			
			if(array.length == 0){
				return;
			}
			int index = partition(array, 0, array.length - 1);
			while(index != k){
				if(index < k){
					index = partition(array, index + 1, array.length - 1);
				}
				if(index > k){
					index = partition(array, 0, index - 1);
				}
			}
		}
//	method_2
	static void kLeastNumbers_2(int[] array, int k){
		
	}
	
	static int partition(int[] array, int start, int end){
			
		int index = start;
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
