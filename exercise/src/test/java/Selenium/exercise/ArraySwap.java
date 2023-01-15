package Selenium.exercise;

import java.util.ArrayList;

public class ArraySwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arrayswap();
		swapZero();
		
	}
	
	public static void arrayswap() {
		int[] array = {1,0,2,3,0,4,0,0,0};
		for(int i=0; i < array.length; i++ ) {
			if( array[i] != 0) {
				System.out.println(array[i]);
			}else if(i != array.length-1) {
				if(array[i]==0 && array[i+1]==0) {
					System.out.println(array[i]);
				}
			}
			if(array[array.length-1]==0 && array[array.length-2]==0 && i ==array.length-1) {
				System.out.println(0);
			}
		}
	}
	
	public static void swapZero() {
		int[] array = {1,0,2,3,0,4,0,0,0};
		ArrayList<Integer> list = new ArrayList<Integer>();
		int count=0;
		for(int i=0; i <array.length; i++) {
			if(array[i] != 0) {
				list.add(array[i]);
			}else {
				count++;
			}
		}
		for(int j=0; j < count; j++) {
			list.add(0);
		}
		System.out.println(list);
	}
}
