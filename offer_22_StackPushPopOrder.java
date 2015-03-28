package com.wyw.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_22_StackPushPopOrder {

	public static void main(String[] args) {

		int[] arrPush = {1,2,3,4,5};
		int[] arrPop = {4,5,3,1,2};
		boolean result = isPopOrder(arrPush, arrPop);
		System.out.println(result ? "Yes" : "No");
	}
	private static boolean isPopOrder(int[] pushSeq, int[] popSeq) {

		int length = pushSeq.length;
		Deque<Integer> stack = new ArrayDeque<Integer>(length);

		int i = 0;
		int j = 0;
		while (i < length) {
			stack.push(pushSeq[i]);
			while (!stack.isEmpty() && stack.peek() == popSeq[j]) {
				stack.pop();
				j++;
			}
			i++;
		}
		return stack.isEmpty() ? true : false;
	}
}
