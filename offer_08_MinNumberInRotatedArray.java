package com.wyw.offer;

public class Offer_08_MinNumberInRotatedArray {
	
	public static void main(String[] args){
		
		int[] array = {1,1,0,1,1,1};
		int minNumIndex = getMinNumberInRotatedArray(array);
		
		System.out.println(array[minNumIndex]);
	}
	static int getMinNumberInRotatedArray(int[] array){
		int minIndex = 0;
		int index1 = 0;
		int index2 = array.length - 1;
		int mid = 0;//(index1 + index2) / 2;
		
		while(array[index1] >= array[index2]){
			if(index1 + 1 == index2){
				minIndex = index2;
				break;
			}
			mid = (index1 + index2) / 2;
			
			if(array[first] == array[mid] && array[mid] == array[last]){
				int tmp = 0;
				for(int i = 1; i< array.length; i++){
					if(array[tmp] > array[i]){
						tmp = i;
					}
				}
				return tmp;
			}
			if(array[mid] > array[index1]){
				index1 = mid;
			}
			else if(array[mid] < array[index2]){
				index2 = mid;
			}
		}
		return minIndex;
}
