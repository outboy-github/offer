package com.wyw.offer;

public class Offer_24_SquenceOfBST {

	public static void main(String[] args) {

//		int[] array = {5,6,7,9,11,10,8};
		int[] array = {7,4,6,5};
		int length = array.length;
		boolean result = isBST(array, 0, length - 1);
		System.out.println(result);
	}
	
	static boolean isBST(int[] array, int start, int end){
		
		if(end - start <= 0){
			return false;
		}
		int root = array[end];
		int i = start;
		//搜索左子树
		for(; i < end; i++){
			if(array[i] > root)
				break;
		}
		//搜索右子树
		int j = i;
		for(; j < end; j++){
			if(array[j] < root)
				return false;
		}
		//每次判断要保证 数组不为空
		//判断左子树
		boolean left = true;
		if(i - 1 - start > 0){
			left = isBST(array, start, i - 1);
		}
		//判断右子树
		boolean right = true;
		if(end - 1 - i > 0)
			right = isBST(array, i, end - 1);
		
		return left && right;
	}
}
