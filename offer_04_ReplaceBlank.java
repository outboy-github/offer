package com.wyw.offer;

public class Offer_04 {
	public static void main(String[] args) {
		/**
		 * 测试用例
		 */
//		char[] arrayOfbefore = {'w','e',' ', 'a', 'r', 'e', ' ', 'h', 'a','p', 'p', 'y', '.'};
//		char[] arrayOfbefore = {' ','w', 'e',' ', 'a', 'r', 'e', ' ', 'h', 'a','p', 'p', 'y', '.'};
//		char[] arrayOfbefore = {'w','e',' ', 'a', 'r', 'e', ' ', 'h', 'a','p', 'p', 'y', '.', ' '};
		char[] arrayOfbefore = {'w','e',' ', 'a', 'r', 'e', ' ', ' ', ' ', 'h', 'a','p', 'p', 'y', '.'};
//		char[] arrayOfbefore = {' ', ' ', ' '};
//		char[] arrayOfbefore = {' '};
//		char[] arrayOfbefore = {};
		
		char[] arrayOfAfter1 = replaceBlank_1(arrayOfbefore);
		System.out.println(arrayOfAfter1);
		char[] arrayOfAfter2 = replaceBlank_2(arrayOfbefore);
		System.out.println(arrayOfAfter2);
	}
	public static char[] replaceBlank_1(char[] array){		 
		
		int blankNum = 0;
		for(char a : array){
			if(' ' == a){
				blankNum++;
			}
		}
		int lengthOfAfter = array.length + blankNum * 2;
		char[] arrayOfAfter = new char[lengthOfAfter]; 
		int j = lengthOfAfter - 1;
		for(int i = array.length - 1; i>=0; i--){
			if(array[i] != ' '){
				arrayOfAfter[j--] = array[i];
			}
			else{
				arrayOfAfter[j--] = '0';
				arrayOfAfter[j--] = '2';
				arrayOfAfter[j--] = '%';
			}
		}
		return arrayOfAfter;		
	}
	
	public static char[] replaceBlank_2(char[] array){		 
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < array.length; i++){
			if(array[i] != ' '){
				sb.append(array[i]);
			}
			else{
				sb.append('%');
				sb.append('2');
				sb.append('0');
			}
		}
		return sb.toString().toCharArray();		
	}
}
