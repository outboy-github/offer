package com.wyw.offer;
/**
 * 二分法查找
 * @author wyw
 *
 */
public class Offer_38_NumberOfK {

	public static void main(String[] args) {
	
		int[] array = {1,2,3,3,7};
		int k = 3;
		int result = numberOfK(array, 0, array.length - 1, k);
		if(result > 0){
			System.out.println(result);
		}
		else{
			System.out.println("the k is not in the array or the array is null.");
		}
	}
	static int numberOfK(int[] array, int start, int end, int k){
		if(array.length == 0){
			return -1;
		}
		int indexFirst = findFirstK(array, start, end, k);
		int indexlast = findLastK(array, start, end, k);
		return indexlast - (indexFirst - 1);
	}
	
	static int findFirstK(int[] array, int start, int end, int k){
		int middle = (start + end) / 2;
		if(array[middle] == k){
			if(middle == 0 || (middle > 0 && array[middle - 1] < k)){
				return middle;
			}
			else{
				end = middle - 1;
			}
		}
		else if(array[middle] < k){
				start = middle + 1;
		}
		else{
			end = middle - 1;
		}
		return findFirstK(array, start, end, k);
	}
	
	static int findLastK(int[] array, int start, int end, int k){
		int middle = (start + end) / 2;
		if(array[middle] == k){
			if(middle == end || (middle < end && array[middle + 1] > k)){
				return middle;
			}
			else{
				start = middle + 1;
			}
		}
		else if(array[middle] < k){
				start = middle + 1;
		}
		else{
			end = middle - 1;
		}
		return findLastK(array, start, end, k);
	}
}
