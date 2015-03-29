package com.wyw.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Offer_25_PathInTree {

	public static void main(String[] args) {

		int[] array = {10,5,7,4,12};
		Node<Integer> root = parseArrayToTree(array);
		
		int sum = 22;
		int currentSum = 0;
		Deque<Integer> path = new ArrayDeque<Integer>();
		printPathInTree(root, sum,currentSum, path);
		
	}
	
	static void printPathInTree(Node<Integer> root, int sum, int currentSum, Deque<Integer> path){
		
		currentSum += root.value;
		path.addLast(root.value);
		
		boolean isLeaf = root.left == null && root.right == null;
		if(currentSum == sum && isLeaf){
			print(path);
		}
		if(root.left != null){
			printPathInTree(root.left, sum, currentSum, path);
		}
		if(root.right != null){
			printPathInTree(root.right, sum, currentSum, path);
		}
		path.pollLast();
	}
	static void print(Deque<Integer> path){
		Iterator<Integer> iterator = path.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
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
