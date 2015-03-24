package com.wyw.offer;

public class Offer_12_Print1ToMaxOfNDigits {

	public static void main(String[] args){
		int n = 3;
		Print1ToMaxOfNDigits(n);
	}
	
	static void Print1ToMaxOfNDigits(int n){
		
		char[] target = new char[n];
		char[] current = new char[n];
		for(int i = 0; i < n; i++){
			target[i] = '9';
			current[i] = '0';
		}
		
		while(compare(target, current)){
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
			current = currentAdd(current);
		}
		System.out.println();
	}
	
	static boolean compare(char[] target, char[] current){
		boolean flag = false;
		/**
		 * target 按位比较 大于则返回true;
		 * 特利是target与current相等的情况
		 */
		if(target.length < current.length){
			return false;
		}
		for(int i = 0; i < target.length; i++){
			if(target[i] - current[i] > 0){
				flag = true;
				break;
			}
		}
		if(new String(target).equals(new String(current))){
			flag = true;
		}
		return flag;
	}
	 static char[] currentAdd(char[] current){
		 boolean flag_1 = false;//进位标志
		 boolean flag_2 = true;//current 增长标志
		 int length = current.length;
		 if(current[length - 1] == '9'){
			 flag_1 = true;
		 }
		 else{
			 current[length - 1] += 1;
		 }
		 if(flag_1 == true){
			 for(char ch : current){
				 if(ch != '9'){
					 flag_2 = false;
				 }
			 }
			 if(flag_2 == true){
				 char[] tmp = new char[current.length + 1];
				 for(int i = 0; i < tmp.length; i++){
					 tmp[i] = '0';
				 }
				 tmp[0] = '1';
				 current = tmp;
			 }
			 for(int i = current.length -1 ; i >= 0; i--){
				 if(current[i] == '9' && flag_1 == true){
					 current[i] = '0';
				} 
				 else if(flag_1 == true){
					 current[i] += 1;
					 flag_1 = false;
				}
			 }
		 }
		 return current;
	 }
}
