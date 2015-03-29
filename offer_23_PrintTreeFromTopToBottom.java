package com.wyw.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_23_PrintTreeFromTopToBottom {

	public static void main(String[] args) {

		int[] array = {8,6,10,5,7,9,11};
		Deque<Node<Integer>> queue = new ArrayDeque<Node<Integer>>();
		Node<Integer> root = parseArrayToTree(array);
		
		printTree(root, queue);
	}
	
	static void printTree(Node<Integer> root, Deque<Node<Integer>> queue){
		
		if(root.left != null){
			queue.addLast(root.left);
		}
		if(root.right != null){
			queue.addLast(root.right);
		}
		System.out.print(root.value + " ");
		while(!queue.isEmpty()){
			printTree(queue.pollFirst(),queue);
		}
	}
	
	static Node<Integer> parseArrayToTree(int[] array){
		Node<Integer> root = null;
		if(array.length == 0 ){
			return null;
		}
		for(int i = 0; i < array.length; i++){
			Node<Integer> node = new Node<Integer>(array[i]);
			root = insert(root, node);
		}
		return root;
	}
	static Node<Integer> insert(Node<Integer> root, Node<Integer> node){
		if(root == null){
			return node;
		}
		if(node.value < root.value){
			root.left = insert(root.left, node);
		}
		else{
			root.right = insert(root.right, node);
		}
		return root;
	}
	
	static class Node<Integer>{
		int value;
		Node<Integer> left;
		Node<Integer> right;
		Node(int value){
			this.value = value;
		}
	}
}
