package Selenium.exercise;

import java.util.Scanner;

public class CheckNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any Number");
		int inputNumbet = sc.nextInt();
		if(checkNumbers(inputNumbet)) {
			System.out.println(inputNumbet+ " is not unique nuber");
		}else {
			System.out.println(inputNumbet+ " is unique nuber");
		}
		
	}

	public static boolean checkNumbers(int inputNumbet) {
		String number = Integer.toString(inputNumbet);
		boolean flag=false;
		int j,i;
		for(i =0; i<number.length()-1; i++) {			
			for(j =i+1; j<number.length(); j++) {				
				if(number.charAt(i)== number.charAt(j)) {
					flag = true;
					break;
				}else {
					continue;
				}
			}
		}
		
		
		return flag;
	}
}
