package com.wyw.offer;

public class Offer_45_LastNumberInCircle {

	public static void main(String[] args) {

		int n = 5;
		int m = 3;
		//method_1
		Node<Integer> tail = parseArrayToLinkCircleList(n);
		if(tail == null){
			System.out.println("there is no numbers.");
		}
		else{
			int num = LastNumberInCircle(tail, m);
			System.out.println("method_1:the last number is " + num);
		}
		//method_2
		int num = lastNumberRamianing(n,m);
		System.out.println("method_2:the last number is " + num);
	}
	
	//method_2 利用数学创新方法
	static int lastNumberRamianing(int n, int m){
		if(n < 1 || m < 1){
			System.out.println("the input is error.");
			return -1;
		}
		int last = 0;
		for(int i = 2; i <= n; i++){
			last = (last + m) % i;
		}
		return last;
	}
	
	//method_1 利用单向循环列表
	static int LastNumberInCircle(Node<Integer> tail, int m){
		
		Node<Integer> node = tail;
		while(node != node.next){
			int k = 1;
			while(k < m){
				node = node.next;
				k++;
			}
			//循环后node正好是head的前一个节点
			Node<Integer> tmp = node.next;
			System.out.print(tmp.value + " ");
			node.next = tmp.next;
			tmp.next = null;
		}
		System.out.println();
		return node.value;
	}

	static Node<Integer> parseArrayToLinkCircleList(int n){
		
		Node<Integer> head = null;
		Node<Integer> tmp = null;
		
		for(int i = 0; i < n; i++){
		
			Node<Integer> node = new Node<Integer>(i);
			if(head == null){
				head = node;
				head.next = head;
				tmp = head;
			}
			else{
				tmp.next = node;
				node.next = head;
				tmp = node;
			}
		}
		return tmp;
	}
	
	static class Node<Integer>{
		int value;
		Node<Integer> next;
		Node(int value){
			this.value = value;
		}
	}
}
