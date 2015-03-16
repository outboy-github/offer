package com.wyw.offer;

public class Offer_06_ConstructBinaryTree {

	public static void main(String[] args) {
	
		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] inOrder = {4,7,2,1,5,3,8,6};
		
		if(preOrder.length == 0 && inOrder.length == 0){
			System.out.println("Invalid input.");
		}
		NodeBTree<Integer> root = constructBinaryTree(preOrder, inOrder, 0, 0 + preOrder.length -1,
				0, 0 + inOrder.length - 1);
//		前序输出：
		prePrint(root);
		System.out.println();
//		中序输出：
		inPrint(root);
		System.out.println();
//		后序输出：
		postPrint(root);
		System.out.println();
	}
	public static void prePrint(NodeBTree<Integer> root){
		
		if(root == null) return;
		System.out.print(root.value + " ");
		prePrint(root.left);
		prePrint(root.right);
	}
	
	public static void inPrint(NodeBTree<Integer> root){
		
		if(root == null) return;
		prePrint(root.left);
		System.out.print(root.value + " ");
		prePrint(root.right);
	}
	public static void postPrint(NodeBTree<Integer> root){
	
		if(root == null) return;
		prePrint(root.left);
		prePrint(root.right);
		System.out.print(root.value + " ");
	}
	public static NodeBTree<Integer> constructBinaryTree(int[] preOrder,int[] inOrder,
			int preStart, int preEnd, int inStart, int inEnd){
//		前序遍历第一个即为根节点
		NodeBTree<Integer> root = new NodeBTree<Integer>(preOrder[0]);
		root.left = root.right = null;
		//如果preStart == preEnd 则 传入的前序只有一个根节点
		if(preStart == preEnd){
//			如果inStart == inEnd 则 传入的中序只有一个根节点
//			若前序的唯一节点和中序的唯一节点值相等，则返回root节点;反之,输入无效
			if(inStart == inEnd && preOrder[preStart] == inOrder[inStart]){
				return root;
			}
			else{
				System.out.println("Invalid Input.");
			}
		}
		//查找中序中根节点位置，得到left tree的长度
		int rootIndexInOrder = 0;
		
		while(rootIndexInOrder < inOrder.length && inOrder[rootIndexInOrder] != root.value){
			++rootIndexInOrder;
		}
		int leftSubTreeLength = rootIndexInOrder - inStart;
		int rightSubTreeLength = inEnd - rootIndexInOrder;
		if(leftSubTreeLength > 0){//此时存在左子树
			int[] preSubOrder = new int[leftSubTreeLength];
			System.arraycopy(preOrder, preStart+1, preSubOrder, 0, leftSubTreeLength);
			int[] inSubOrder = new int[leftSubTreeLength];
			System.arraycopy(inOrder, inStart,inSubOrder, 0, leftSubTreeLength);
			root.left = constructBinaryTree(preSubOrder, inSubOrder, 0, preSubOrder.length - 1, 0, inSubOrder.length - 1);
		}
		if(leftSubTreeLength < preEnd - preStart){//此时存在右子树
			int[] preSubOrder = new int[rightSubTreeLength];
			System.arraycopy(preOrder, preStart+leftSubTreeLength+1, preSubOrder, 0, rightSubTreeLength);
			int[] inSubOrder = new int[rightSubTreeLength];
			System.arraycopy(inOrder, inStart + leftSubTreeLength +1, inSubOrder, 0, rightSubTreeLength);
			root.right = constructBinaryTree(preSubOrder, inSubOrder, 0, preSubOrder.length - 1, 0, inSubOrder.length - 1);
		}
		return root;
	}
	
	/**
	 * 二叉搜索树节点定义
	 */
	private static class NodeBTree<Integer>{
		Integer value;
		NodeBTree<Integer> left;
		NodeBTree<Integer> right;
		NodeBTree(Integer v){
			this.value = v;
		}
	}
}
