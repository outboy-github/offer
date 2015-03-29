package com.wyw.offer;

import java.util.Random;

public class Offer_26_CopyComplexList {

	public static void main(String[] args) {

		int[] array = {10,5,7,4,12};
		
		Node<Integer> head = parseArrayToLinkList(array);
		
		Node<Integer> headClone = clone(head); 
		System.out.println(headClone.value);
		
	}
	static Node<Integer> clone(Node<Integer> head){
		clonesNodes(head);
		connectSiblingNodes(head);
		return reconnectNodes(head);
	}
	
	static Node<Integer> clonesNodes(Node<Integer> head){
		
		Node<Integer> node = head;
		if(head == null){
			return null;
		}
		/**
		 * 复制的时候，clone节点的每一项都应该单独赋值，否则表copy以后就和以前不一样了
		 * 并且sibling节点应该赋值为null
		 */
		while(node != null){
			Node<Integer> cloneNode = new Node<Integer>();
			cloneNode.value = node.value;
			cloneNode.next = node.next;
			cloneNode.sibling = null;

			node.next = cloneNode;
			node = cloneNode.next;
		}
		return head;
	}
	
	static Node<Integer> connectSiblingNodes(Node<Integer> head){

		if(head == null){
			return null;
		}
		Node<Integer> node = head;
		Node<Integer> cloneNode = new Node<Integer>();
		while(node != null){
			cloneNode = node.next;
			if(node.sibling != null){
				cloneNode.sibling = node.sibling.next;
			}
			node = cloneNode.next;
		}
		return head;
	}
	static Node<Integer> reconnectNodes(Node<Integer> head){
		
		if(head == null){
			return null;
		}
		Node<Integer> node = head;
		Node<Integer> cloneHead = new Node<Integer>();
		Node<Integer> cloneNode = new Node<Integer>();
		
		if(node != null){
			cloneHead = cloneNode = node.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		
		while(node != null){
			
			cloneNode.next = node.next;
			cloneNode = cloneNode.next;
			node.next = cloneNode.next;
			node = node.next;
		}
		return cloneHead;
	}
	
	static Node<Integer> parseArrayToLinkList(int[] array){
		Node<Integer> head = null;
		Node<Integer> tmp = null;
		int length = array.length;
		if(length == 0 ){
			return null;
		}
		for(int i = 0; i < length; i++){
			Node<Integer> node = new Node<Integer>(array[i]);
			int randomNum = new Random().nextInt(length);
			Node<Integer> sibNode = head;
			while(randomNum != 0){
				if(sibNode != null)
					sibNode = sibNode.next;
				randomNum--;
			}
			if(head == null){
				head = node;
				head.next = null;
				head.sibling = null;
				tmp = head;
			}
			else{
				tmp.next = node;
				tmp.sibling = sibNode;
				tmp = tmp.next;
			}
		}
		return head;
	}
	
	static class Node<Integer>{
		int value;
		Node<Integer> next;
		Node<Integer> sibling;
		Node(){
		}
		Node(int value){
			this.value = value;
		}
	}
}
