package com.wyw.offer;
import java.util.Date;
public class Offer_09_Fibonacci {

	public static void main(String[] args){

		long num = 1000000000;
		System.out.println(new Date().getTime());
		long result = fibonacci(num);
		System.out.println(result);
		System.out.println(new Date().getTime());
	}
	static long fibonacci(long n){
		
		long fn = 0;
		
		if(n == 0 || n == 1){
			return n;
		}
		long fn_0 = 0;
		long fn_1 = 1;
		for(int i = 2; i <= n; i++){
			fn = fn_0 + fn_1;
			fn_0 = fn_1;
			fn_1 = fn;
		}
		return  fn;
	}
}
