package com.wyw.offer;

public class Offer_42_1_ReverseWordsInSentence {

	public static void main(String[] args) {
		
		String string = "I like sleep.";
		char[] words = string.toCharArray();
		words = reverse(words);
		for(char ch : words){
			System.out.print(ch);
		}
	}
	static char[] reverse(char[] words){
		int start = 0;
		int end = words.length - 1;
		reverse(words, start, end);
		for(int i = 0; i < words.length; i++){
			if(words[i] == ' '){
				reverse(words, start, i - 1);
				start = i + 1;
			}
			//此时没有空格或最后一个单词.
			else if(i == words.length - 1){
				reverse(words, start, i);
			}
		}
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
