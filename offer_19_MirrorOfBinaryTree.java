package com.wyw.offer;

public class Offer_19_MirrorOfBinaryTree{

	public static void main(String[] args){
		
		int[] array = {8,6,5,7,10};
		
		Node<Integer> root = parseArrayToTree(array);
		if(root == null){
			System.out.println("array is null.");
		}
	}
	
	static Node<Integer> mirrorOfBinaryTree(Node<Integer> root){
		
		if(root == null){
			return root;
		}
		Node<Integer> tmp = root.right;
		root.right = root.left;
		root.left = tmp;
		if(root.left != null){
			mirrorOfBinaryTree(root.left);
		}
		if(root.right != null){
			mirrorOfBinaryTree(root.right);
		}
		
		return root;
	}
	static Node<Integer> parseArrayToTree(int[] array){
		
		Node<Integer> root = null;
		for(int i : array){
			Node<Integer> node = new Node<Integer>(i);
			if(root == null){
				root = node;
			}
			else{
				insert(root, node);
			}
		}
		
		return root;
	}
	static Node<Integer> insert(Node<Integer> root, Node<Integer> node){
		
		if(root == null){
			root = node;
		}
		else{
			if(root.value < node.value){
				root.right = insert(root.right, node);
			}
			else{
				root.left = insert(root.left, node);
			}
		}
		return root;
	}
	static class Node<Integer>{
		Integer value;
		Node<Integer> left;
		Node<Integer> right;
		Node(Integer value){
			this.value = value;
		}
	}
}
