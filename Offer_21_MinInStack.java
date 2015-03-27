package com.wyw.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_21_MinInStack{

	public static void main(String[] args){
		
		int[] arr = {1,2,4,3};
		
		Stack stack = new Stack();
		
		for(int i = 0; i < arr.length; i++){
			stack.push(arr[i]);
		}
		System.out.println(stack.pop());
		System.out.println(stack.min());
	}
	
	static class Stack{
		
		private Deque<Integer> masterStack = new ArrayDeque<Integer>();
		private Deque<Integer> assistStack = new ArrayDeque<Integer>();
		
		void push(int num){
			masterStack.push(num);
			if(assistStack.isEmpty() || assistStack.peek() > num){
				assistStack.push(num);
			}
			else{
				assistStack.push(assistStack.peek());
			}
			
		}
		int pop(){
			if(!assistStack.isEmpty()){
				assistStack.pop();
				return masterStack.pop();
			}
			else{
				return -1;
			}
		}
		int min(){
			if(!assistStack.isEmpty()){
				return assistStack.pop();
			}
			else{
				return -1;
			}
		}
	}
}
