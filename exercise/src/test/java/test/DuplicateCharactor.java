package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DuplicateCharactor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//removeDuplicate();
		//missingNumber();
		test();
		// getDuplicateCharactor();

	}

	/*
	 * Print the duplicate characters
	 * 
	 * @Return duplicate character of string
	 */
	public static void getDuplicateCharactor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any String");
		String str = sc.nextLine().replaceAll(" ", "");
		ArrayList<String> newString = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length() - 1; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					newString.add("" + str.charAt(i));
					str = str.replaceAll("" + str.charAt(i), "");
					break;
				}
			}
		}

		System.out.println(newString);
	}

	/*
	 * Remove Duplicate elements from the array
	 * 
	 * @return unique arrayList
	 */
	public static void removeDuplicate() {
		ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 3, 4, 5, 6, 1, 3));
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.size(); i++) {
			if (list.contains(array.get(i))) {
				array.remove(array.get(i));
			} else {
				list.add(array.get(i));
			}
		}
		System.out.println(list);
	}

	/*
	 * Find missing number from array
	 * 
	 * @Return missing number from given array
	 */
	public static void missingNumber() {
		int[] arr = { 1, 2, 3, 5 };
		int total = 1;
		for (int i = 2; i <= (arr.length + 1); i++) {
			total += i;
			total -= arr[i - 2];
		}
		System.out.println(total);
	}

	public static void test()
	{
		int[] arr = {1,2,4,5};
		for(int i=1; i<arr.length; i++) {
			int prevNumber = arr[0];
			if(prevNumber+1 == arr[i]) {
				
			}else {
				System.out.println(arr[i]);
			}
			
		}
	}
	
}
