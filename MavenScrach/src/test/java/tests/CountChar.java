package tests;

import java.util.*;
public class CountChar {

	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5,6,7,8,9,10};
		checkEvn(array);
		if(UniqueNumber(123)) {
			System.out.println("\nNumber is not uniq");
		}else {
			System.out.println("\nNumber is uniq");
		}
			
		
	}
	
	public static void checkEvn(Integer[] strArray) {
		ArrayList<String> newArray = new ArrayList<String>();
		for(int i=0;i<strArray.length;i++) {
			if(strArray[i] % 2 ==0) {
				newArray.add(strArray[i]+"-E");	
			}else {
				newArray.add(strArray[i]+"-O");
			}
		}
		System.out.print("\n"+ newArray);
	}
	
	public static boolean UniqueNumber(Integer number) {
		String input = Integer.toString(number);
		boolean flag=false;
		for(int i = 0; i<input.length()-1;i++) {
			
			for(int j =i+1;j<input.length(); j++) {
				
				if(input.charAt(i) == input.charAt(j)) {
					flag=true;
					break;
				}else {
					continue;
				}
			}
		}
		return flag;
	}
	
}
