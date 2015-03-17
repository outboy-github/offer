package com.wyw.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Offer_07_QueryWithTwoStacks {

	public static void main(String[] args) {
		QueryWithTwoStacks qWithStack = new QueryWithTwoStacks();
	
		qWithStack.appendTail("a");
		qWithStack.appendTail("b");
		System.out.print(qWithStack.deleteHead());
		
		System.out.println();
		
		StackWithTwoQuerys sWithQueue = new StackWithTwoQuerys();
		
		sWithQueue.push("a");
		sWithQueue.push("b");
		sWithQueue.push("c");
		System.out.print(sWithQueue.pop());
		
	}
	//QueryWithTwoStacks
	public static class QueryWithTwoStacks{
		private Stack<String> stack1 = new Stack<String>();
		private Stack<String> stack2 = new Stack<String>();
		
		public  String appendTail(String e){
			return stack1.push(e);
		}
		
		public  String deleteHead(){
			if(stack2 != null && stack2.size() != 0){
				return stack2.pop();
			}
			else{
				while(stack1 != null && stack1.size() != 0){
					stack2.push(stack1.pop());
				}
				if(stack2 != null && stack2.size() != 0){
					return stack2.pop();
				}
				else{
					System.out.println("queue is null.");
					return null;
				}
			}
		}
	}
	//	StackWithTwoQuerys
	public static class StackWithTwoQuerys{
		private Deque<String> queue1 = new ArrayDeque<String>();
		private Deque<String> queue2 = new ArrayDeque<String>();
		
		public  void push(String e){
			queue1.addLast(e);
		}
		
		public  String pop(){
			if(queue2 != null && queue2.size() != 0){
				return queue2.removeLast();
			}
			else{
				while(queue1 != null && queue1.size() != 0){
					queue2.addFirst(queue1.removeLast());
				}
				if(queue2 != null && queue2.size() != 0){
					return queue2.removeLast();
				}
				else{
					System.out.println("queue is null.");
					return null;
				}
			}
		}
	}
}
