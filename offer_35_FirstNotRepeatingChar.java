package com.wyw.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer_35_FirstNotRepeatingChar {

	public static void main(String[] args) {

//		String string = "abaccdebff";
		String string = "aabb";
		FirstNotRepeatingChar(string);
	}
	static void FirstNotRepeatingChar(String string){
		char firstChar = ' ';
		if(string == null || string.trim().length() < 1){
			System.out.println("invalid input.");
			return;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char ch : string.toCharArray()){
			
			if(!map.containsKey(ch)){
				map.put(ch, 1);
			}
			else{
				map.put(ch, Integer.valueOf(map.get(ch)) + 1);
			}
		}
		for(Character ch : list){
			if(Integer.valueOf(map.get(ch)) == 1){
				firstChar = ch;
				break;
			}
		}
		if(firstChar == ' '){
			System.out.println("the not repeat char is not exist.");
		}
		else{
			System.out.println(firstChar);
		}
	}
}
