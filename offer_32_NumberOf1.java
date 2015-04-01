package com.wyw.offer;

public class Offer_32_NumberOf1 {

	public static void main(String[] args) {

		int n = 125;
		numberOf1(n);
		
	}
	static void numberOf1(int n){
		if(n == 0 ){
			return;
		}
		int factor = 1;
		int num = 0;
		int cur,low, high;//当前位值，低位数，高位数
		
		while(n / factor != 0){
			low = n % factor;
			cur = (n / factor) % 10;
			high = n / (factor * 10);
			
			if(cur < 1){
				num += high * factor;
			}
			else if(cur == 1){
				num += high * factor + (low + 1);
			}
			else{
				num += (high + 1) *factor;
			}

			factor *= 10;
			
		}
		System.out.println(num);
	}
}
