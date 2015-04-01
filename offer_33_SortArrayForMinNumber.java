package com.wyw.offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Offer_33_SortArrayForMinNumber {

	public static void main(String[] args) {

		int[] array = {31,3,325};
		String result = sortArrayForMinNumber(array);
		System.out.println(result);
	}
	static String sortArrayForMinNumber(int[] array){
		
		Queue<String> queue = new PriorityQueue<String>(array.length, new Comparator<String>(){
			public int compare(String o1, String o2){
				String tmp1 = o1.concat(o2);
				String tmp2 = o2.concat(o1);
				int compareResult = tmp1.compareTo(tmp2);
				if(compareResult > 0){
					return 1;
				}
				else if(compareResult < 0){
					return -1;					
				}
				else{
					return 0;
				}
			}
		});
		
		for(int i : array){
			queue.add(String.valueOf(i));
		}
		StringBuffer sb = new StringBuffer();
		while(!queue.isEmpty()){
			System.out.println(queue.peek());
			sb.append(queue.poll());
			
		}
		return sb.toString();
	}
}
