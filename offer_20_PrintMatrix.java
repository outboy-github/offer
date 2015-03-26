package com.wyw.offer;

public class Offer_20_PrintMatrix{

	public static void main(String[] args){
		
		int[][] matrix = {
				{1,2,3,4,5},
				{16,17,18,19,6},
				{15,24,25,20,7},
    			{14,23,22,21,8}};
				{13,12,11,10,9}};
		
		printMatrix(matrix);
	}
	static void printMatrix(int[][] matrix){
		if(matrix.length == 0){
			return;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		int start = 0;
		while(rows > 2*start && cols >2*start){
			
			print(matrix,rows, cols, start);
			start++;
		}
	}
	static void print(int[][] matrix, int rows, int cols, int start){
		
		for(int i = start; i < cols - start; i++){
			System.out.print(matrix[start][i] + " ");
		}
		
		for(int i = start + 1; i < rows - start;  i++){
			System.out.print(matrix[i][cols - 1- start] + " ");
		}
		
		for(int i = cols - 1- (start + 1); i >= start; i--){
			System.out.print(matrix[rows - 1 - start][i] + " ");
		}
		
		for(int i = rows - 1- (start + 1); i >= start + 1; i--){
			System.out.print(matrix[i][start] + " ");
		}
	}
}
