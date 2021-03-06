    package com.wyw.offer;

    public class Offer_03 {

    	public static void main(String[] args) {
			
         	int[][] array = {{1,2,8,9}, {2,4,9,12},{4,7,10,13}, {6,8,11,15} };
			int num = 0;
			boolean found = find(array,num);
			if(found == true){
				System.out.println("the number is found in the array!");
			}
			else{
				System.out.println("the number is not found in the array!");
			}
		}
		public static boolean find(int[][] array, int num){		 
			boolean found = false;
			if(array[0].length == 0)
				System.out.println("the array is null");
			else{
				int row = 0;
				int col = array[0].length - 1;
				while(row < array.length && col >= 0){
					if(array[row][col] == num){
						found = true;
						break;
					}
					else if(array[row][col] < num)
						row++;
					else
						col--;
				}
			}
			return found;		
		}
    }
