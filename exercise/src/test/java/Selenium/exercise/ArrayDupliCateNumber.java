package Selenium.exercise;

import java.util.HashMap;

public class ArrayDupliCateNumber {

	public static void main(String[] args) {
		int[] inputArray = {1,1,2,3,5,6};
		HashMap<Integer,Integer> mappedArray = new HashMap<Integer,Integer>();
		System.out.println(inputArray.length);
		for(int i=0;i<inputArray.length;i++) {
			if(mappedArray.containsKey(inputArray[i])) {
				mappedArray.put(inputArray[i], mappedArray.get(inputArray[i])+1);
			}else {
				mappedArray.put(inputArray[i], 1);
			}
		}
		System.out.println(mappedArray);
	}

}
