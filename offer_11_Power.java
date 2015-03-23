package com.wyw.offer;

public class Offer_11_Power {

	public static void main(String[] args){

		double base = 2;
		int exponent = 0;
//		double result = power_1(base, exponent);
		double result = power_2(base, exponent);
		System.out.println("the result of power is : " + result);
		
	}
//	method_1
	static double power_1(double base, int exponent){
		
		double result = 0.0;
		if(base == 0){
			return 0.0;
		}
		if(exponent < 0){
			result = 1.0 / power_common_1(base, exponent * -1);
		}
		else{
			result = power_common_1(base, exponent);
		}
		return result;
	}
//	method_2
	static double power_2(double base, int exponent){
		
		double result = 0.0;
		if(base == 0){
			return 0.0;
		}
		if(exponent < 0){
			result = 1.0 / power_common_2(base, exponent * -1);
		}
		else{
			result = power_common_2(base, exponent);
		}
		return result;
	}
	
	static double power_common_1(double base, int exponent){

		double result = 1.0;
		if(base == 0){
			return 0;
		}
		if(exponent == 0){
			return 1.0;
		}
		else{
			for(int i = 1; i <= exponent; i++){
				result *= base;
			}
		
		}
		return result;
	}

	static double power_common_2(double base, int exponent){

		double result = 1.0;
		if(base == 0){
			return 0;
		}
		if(exponent == 0){
			return 1.0;
		}
		if(exponent == 1){
			return base;
		}
		result = power_common_1(base, exponent >> 1);
		result *= result;
		if((exponent & 0x1) == 1){
			result *= base;
		}
		return result;
	}
}
