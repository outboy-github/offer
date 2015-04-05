package com.wyw.offer;

public class Offer_39_2_BalancedBinaryTree {

	public static void main(String[] args) {
	
		int[] array = {8,6,3,7,10,9,1};
		
		Node<Integer> root = parseArrayToTree(array);
		boolean result = isBalanceBinaryTree(root);
		System.out.println(result);
	}
	
	static boolean isBalanceBinaryTree(Node<Integer> root){
		
		if(root == null){
			return true;
		}
		int left = getTreeDepth(root.left);
		int right = getTreeDepth(root.right);
		int diff = (left > right) ? left - right : right - left;
		if(diff > 1){
			return false;
		}
		else{
			return isBalanceBinaryTree(root.left) && isBalanceBinaryTree(root.right);
		}
	}
	
	static int getTreeDepth(Node<Integer> root){
		if(root == null){
			return 0;
		}
		int	left = getTreeDepth(root.left);
		int right = getTreeDepth(root.right);
		return (left > right) ? left + 1 : right + 1;
	}
	
	static Node<Integer> parseArrayToTree(int[] array){
		
		Node<Integer> root = null;
		for(int i : array){
			root = insert(root, i);
		}
		return root;
	}
	
	static Node<Integer> insert(Node<Integer> root, int i){
		Node<Integer> node = new Node<Integer>(i);
		if(root == null){
			root = node;
			root.left = null;
			root.right = null;
		}
		else{
			if(i < root.value){
				root.left = insert(root.left, i);
			}
			else{
				root.right = insert(root.right, i);
			}
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
