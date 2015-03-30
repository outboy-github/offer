package com.wyw.offer;

public class Offer_27_ConvertBinarySearchTree {

	public static void main(String[] args) {

		int[] array = {10,6,4,8,14,12,16};
		
		Node<Integer> root = parseArrayToTree(array);
		
		Node<Integer> head = convertTree(root);
		System.out.println(head.value);
		
	}
	
	static Node<Integer> convertTree(Node<Integer> root){
		Node<Integer> head = null;
		
		Node<Integer> tail = convertNode(root, head);
		//返回头结点
		head = tail;
		while(head != null && head.left != null){
			head = head.left;
		}
		return head;
	}
	
	static Node<Integer> convertNode(Node<Integer> root, Node<Integer> tail){
		
		if(root == null){
			return null;
		}
		if(root.left != null){
			tail = convertNode(root.left, tail);
		}
		root.left = tail;
		if(tail != null){
			tail.right = root;
		}
		tail = root;

		if(root.right != null){
			tail = convertNode(root.right, tail);
		}
		return tail;
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
