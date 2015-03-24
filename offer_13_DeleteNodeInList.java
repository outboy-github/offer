package com.wyw.offer;

import java.util.Random;

public class Offer_13_DeleteNodeInList {

	public static void main(String[] args){
		String[] strList = {};//{"a","b","c"};
		
		Node<String> first = parseListToLinkList(strList);
		if(first == null){
			System.out.println("list is null.");
		}
		else{
			int i = new Random().nextInt(strList.length);
			Node<String> node = first;
			while(i != 0){
				node = node.next;
				i--;
			}
			deleteNodeInList(first,node);
		}
	}
	
	static void deleteNodeInList(Node<String> first, Node<String> node){
		
		if(first == null){
			System.out.println("list is null.");
		}
		if(node == null)
			System.out.println("the delete node is null. ");
		//the node to delete is not tail--O(1)
		if(node.next != null){
			Node<String> n = node.next;
			node.value = n.value;
			node.next = n.next;
			n.value = null;
			n.next = null;
		}
		//the node to delete is tail--O(n)
		else{
			Node<String> n = first;
			while(n.next != node){
				n = n.next;
			}
			
			n.next.value = null;
			n.next = null;
		}
	}
	
	static Node<String> parseListToLinkList(String[] strList){
		Node<String> first = null;
		Node<String> c = first;
		for(String s : strList){
			Node<String> node = new Node<String>(s);
			if(first == null){
				first = node;
				first.next = null;
				c = first;
			}
			else{
				c.next = node;
				c = c.next;
			}
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
