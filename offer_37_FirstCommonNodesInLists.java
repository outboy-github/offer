package com.wyw.offer;

public class Offer_37_FirstCommonNodesInLists {

	public static void main(String[] args) {
	
		int[] arr1 = {1,2,3,6,7};
		int[] arr2 = {4,5,6,7};
		Node<Integer> head1 = parseArrayToLinkList(arr1);
		Node<Integer> head2 = parseArrayToLinkList(arr2);
		
		Node<Integer> firstCommonNode = firstCommonNodesInLists(head1, head2);
		if(firstCommonNode != null){
			System.out.println(firstCommonNode.value);
		}
		else{
			System.out.println("the firstCommonNode is not exisit.");
		}
	}
	
	static Node<Integer> firstCommonNodesInLists(Node<Integer> head1, Node<Integer> head2){
		
		int length1 = getLinkListLength(head1);
		int length2 = getLinkListLength(head2);
		Node<Integer> longList = head1;
		Node<Integer> shortList = head2;
		Node<Integer> firstCommonNode = null;
		int distance = length1 - length2;
		if(length2 > length1){
			longList = head2;
			shortList = head1;
			distance = length2 - length1;
		}
		
		for(; distance > 0; distance--){			
			longList = longList.next;
		}
		while(longList != null && shortList != null && !longList.equals(shortList)){
			longList = longList.next;
			shortList = shortList.next;
		}
		firstCommonNode = longList; 
		return firstCommonNode;
	}
	
	static int getLinkListLength(Node<Integer> head1){
		int length = 0;
		Node<Integer> node = head1;
		while(node != null){
			node = node.next;
			length++;
		} 
		return length;
	}
	
	static Node<Integer> parseArrayToLinkList(int[] array){
		Node<Integer> head = null;
		Node<Integer> tmp = null;
		for(int i : array){
			Node<Integer> node = new Node<Integer>(i);
			if(head == null){
				head = node;
				head.next = null;
				tmp = head;
			}
			else{
				tmp.next = node;
				tmp = tmp.next;
			}
		}
		return head;
	}
	
	static class Node<Integer>{
		int value;
		Node<Integer> next;
		Node(int value){
			this.value = value;
		}
		public boolean equals(Node<Integer> node){
			if(this.value == node.value){
				return true;
			}
			else{
				return false;
			}
		}
	}
}
