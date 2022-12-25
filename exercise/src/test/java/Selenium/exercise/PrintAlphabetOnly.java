package Selenium.exercise;

import java.util.Scanner;

public class PrintAlphabetOnly {

	/*
	 * Print only Alphabets from string
	 */
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Any String");
		String str = sc.nextLine().replaceAll("[0-9]", "");
		System.out.println(str);
	}
	
	/*
	 * Print only numbers in string 
	 */
	public void printNumbers(String str) {
		String sumbers = str.replaceAll("[^0-9]", "");
		System.out.println(sumbers);
	}
}
