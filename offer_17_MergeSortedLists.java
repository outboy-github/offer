package com.wyw.offer;

public class Offer_17_MergeSortedLists{

	public static void main(String[] args){
		
		int[] array1 = {1,1,3,5};
		int[] array2 = {2,4,6,8};
		
		Node<Integer> head1 = parseArrayToLink(array1);
		Node<Integer> head2 = parseArrayToLink(array2);
		
		Node<Integer> head = merge(head1, head2);
		System.out.println(head.value);
	}
	static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
		
		Node<Integer> head = null;
		
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		if(head1.value < head2.value){
			
			head= head1;
			head.next = merge(head1.next,head2);
		}
		else{
			head = head2;
			head.next = merge(head1,head2.next);
		}
		return head;
	}
	static Node<Integer> parseArrayToLink(int[] array){
		
		Node<Integer> first = null;
		Node<Integer> tmp = null;
		for(int str : array){
			Node<Integer> node = new Node<Integer>(str);
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
	static class Node<Integer>{
		Integer value;
		Node<Integer> next;
		Node(Integer value){
			this.value = value;
		}
	}
}
