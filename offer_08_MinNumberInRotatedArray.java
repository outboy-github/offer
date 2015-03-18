package com.wyw.offer;

public class Offer_08_MinNumberInRotatedArray {

	public static void main(String[] args){
		
//		int[] array = {1,0,1,1,1};
		int[] array = {3,4,5,1,2};
		int minNum = getMinNumberInRotatedArray(array);
		System.out.println(minNum);
	}
	static int getMinNumberInRotatedArray(int[] array){
		int start = 0;
		int end = array.length - 1;
		int mid = (start + end) / 2;
		
		while(end - start != 1){
			mid = (start + end) / 2;
			if(array[start] == array[mid] && array[mid] == array[end]){
				int tmp = 0;
				for(int i = 1; i< array.length; i++){
					if(array[tmp] > array[i]){
						tmp = i;
					}
				}
				return array[tmp];
			}
			if(array[mid] > array[start]){
				start = mid;
			}
			else if(array[mid] < array[end]){
				end = mid;
			}
		}
		return array[end];
	}
}
