package Selenium.exercise;

import java.util.Scanner;

public class ArmStrongNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Any Number");
		int num = sc.nextInt();
		if (isArmStrongnumber(num)) {
			System.out.println(num + " Number is armStrong Number");
		} else {
			System.out.println(num+ " Number is not armStrong Number");
		}
	}
	
	public static  boolean isArmStrongnumber(Integer numer) {
		String string = Integer.toString(numer);
		double power = 0;
		for(int j=0; j<string.length();j++) {
			 int a = Integer.parseInt(String.valueOf(string.charAt(j)));
			 power =  power+(Math.pow(a,string.length()));
		}
		
		return ((power == numer) ? true : false);
	}
}