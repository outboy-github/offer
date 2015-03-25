package com.wyw.offer;

public class Offer_15_KthNodeFromEnd{

	public static void main(String[] args){
		
		String[] array = {"a","b","c","d","e"};
		int k = 1;
		Node<String> first = parseArrayToLink(array);
		
		Node<String> kthNode = KthNodeFromEnd(first, k);
		if(kthNode != null){
			System.out.println(kthNode.value);
		}
		else{
			System.out.println("array in null or k is out of the length of the array.");
		}
	}
	static Node<String> KthNodeFromEnd(Node<String> first, int k){
		
		Node<String> kthNode = null;
		
		if(first == null || k == 0){
			return null;
		}
		int end = 1;
		Node<String> node = first.next;
		while(node != null){
			if(end == k){
				break;
			}
			node = node.next;
			end++;
		}
		if(end < k){
			return null;
		}
		kthNode = first;
		while(node != null){
			node = node.next;
			kthNode = kthNode.next;
		}
		return kthNode;
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
