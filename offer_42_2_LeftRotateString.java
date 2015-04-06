package com.wyw.offer;

public class Offer_42_2_LeftRotateString {

	public static void main(String[] args) {
		
		String string = "I like sleep.";
		int n = 3;
		char[] words = string.toCharArray();
		//先反转前n个字符,再翻转其他的,最后在全部翻转
		words = reverse(words, n);
		for(char ch : words){
			System.out.print(ch);
		}
	}
	
	static char[] reverse(char[] words, int n){
		
		int start = 0;
		int end = words.length - 1;
	
		reverse(words, start, n - 1);
		reverse(words, n, end);
		reverse(words, start, end);

		return words;
	}
	
	static void reverse(char[] words, int start, int end){
		while(start < end){
			swap(words, start++, end--);
		}
	}
	
	static void swap(char[] words, int start, int end){
		
		char tmp = words[start];
		words[start] = words[end];
		words[end] = tmp;
	}
}
