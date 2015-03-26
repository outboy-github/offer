package com.wyw.offer;

public class Offer_18_SubstrctureInTree{

	public static void main(String[] args){
		
		int[] array1 = {8,6,5,7,10};
		int[] array2 = {6,5,7};
		
		Node<Integer> root1 = parseArrayToTree(array1);
		Node<Integer> root2 = parseArrayToTree(array2);
		
		System.out.println(hasEqualValue(root1,root2));
	}
	
	static boolean hasSubTree(Node<Integer> root1, Node<Integer> root2){
		if(root2 == null){
			return true;
		}
		if(root1 == null){
			return false;
		}

		if(root1.value != root2.value){
			return false;
		}
		return hasSubTree(root1.right, root2.right) && hasSubTree(root1.left, root2.left);
	}
	static boolean hasEqualValue(Node<Integer> root1, Node<Integer> root2){
		
		Node<Integer> node = root1;
		boolean result = false;
		if(node != null && root2 != null){
			if(node.value == root2.value){
				hasSubTree(node, root2);
			}
			if(!result){
				result = hasSubTree(node.left, root2);
			}
			if(!result){
				result = hasSubTree(node.right, root2);
			}
		}
		return result;
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
