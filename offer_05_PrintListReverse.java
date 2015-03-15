package com.wyw.offer;

import java.util.Stack;

public class Offer_05_PrintListReversingly {

	public static void main(String[] args) {
		
		String[] strList = {"a","b","c"};
		
		Node first =  parseListToLinkList(strList);
		
		//method_1
		ReverseByStack(first);
		System.out.println();
		
		//method_2
		ReverseByRecursion(first);
	}
//	mothod_1 
	private static void ReverseByStack(Node node){
		String[] result = null;
		Stack<String> stack = new Stack();
		while(node != null){
			stack.push(node.value);
			node = node.next;
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop() + " ");
		}
	}
	
//	method_2
	public static void ReverseByRecursion(Node node){
		Node tmp = null;
		if(node.next != null){
			ReverseByRecursion(node.next);
		}
		System.out.print(node.value+" ");
	}

	private static Node parseListToLinkList(String[] array){
		Node first = null;
		Node c = first;
		for(String i : array){
		
			Node node = new Node(i);
			if(first == null){
				first = node;
				c = first;
			}else{
				c.next = node;
				c = c.next;
			}
		}
		return first;
	}
	public static class NodeList{
		Node first = null;
		Node last = null;
		
		private void addNodeToList(Node node){
			if(first == null){
				first = node;
			}
			else{
				Node tmp = first;
				while(tmp.next != null){
					tmp = tmp.next;
				}
				tmp.next = node;
			}
		}
	}
	private static class Node{
		String value;
		Node next;
		public Node(String value){
			this.value = value;
		}
	}
}

