package com.wyw.offer;

public class Offer_16_ReverseList{

	public static void main(String[] args){
		
		String[] array = {"a"};//{"a","b","c","d"};
		
		Node<String> head = parseArrayToLink(array);
		if(head != null){
			Node<String> reverseHead = reverseList(head);
			System.out.println(reverseHead.value);
		}
		else{
			System.out.println("array is null.");
		}
	}
	
	static Node<String> reverseList(Node<String> head){
		Node<String> prev = null;
		Node<String> reverseHead = head;
		Node<String> node = head.next;
		while(node != null){
			reverseHead.next = prev;
			prev = reverseHead;
			reverseHead = node;
			node = node.next;
		}
		return reverseHead;
	}
	static Node<String> parseArrayToLink(String[] array){
		
		Node<String> first = null;
		Node<String> tmp = null;
		for(String str : array){
			Node<String> node = new Node<String>(str);
			if(first == null){
				first = node;
			}
			else{
				tmp.next = node;
			}
			tmp = node;
		}
		return first;
	}
	static class Node<String>{
		String value;
		Node<String> next;
		Node(String value){
			this.value = value;
		}
	}
}
