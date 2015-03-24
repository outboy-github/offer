package com.wyw.offer;
/**
 * index : the index of char[] number.
 * n : the length of number
 * current : number
 * @author wyw
 */
public class Offer_12_Print1ToMaxOfNDigits_other {

	public static void main(String[] args){
		int n = 2;
		Print1ToMaxOfNDigits(n);
	}
	
	static void Print1ToMaxOfNDigits(int n){
		if(n < 0){
			return;
		}
		char[] current = new char[n];
		current[0] = '0';
		for(char ch = '0'; ch <= '9'; ch++){
			current[0] = ch;
			printNumRecursively(current, n, 0);
		}
	}
	
	static void printNumRecursively(char[] current, int n, int index){
		if(index == n - 1){
			printNum(current);
			return;
		}
		for(char ch = '0'; ch <= '9'; ch++){
			current[index+1] = ch;
			printNumRecursively(current, n, index + 1);
		}
	}
	
	static void printNum(char[] current){
		int index = -1;
		for(int i = 0; i < current.length; i++){
			if(current[i] != '0'){
				 index = i;
				 break;
			}
		}
		if(index == -1){
			System.out.print("0 ");
		}
		else{
			System.out.print(new String(current).substring(index) + " ");
		}
	}
}
