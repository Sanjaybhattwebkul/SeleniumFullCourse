package Selenium.exercise;

import java.util.Scanner;

public class PrintAlphabetOnly {

	/*
	 * Print only Alphabets from string
	 */
	public static void main(String[] args) {
		printOnlyNumbers("sanjay1234");
		nimFromMetrix();
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("\nEnter Any String");
		String str = sc.nextLine().replaceAll("[0-9]", "");
		System.out.println(str);
		
	}
	
	/*
	 * Print minimum number from metrix
	 */
	public static void nimFromMetrix() {
		int metrix[][] = {{1,2,3}, {4,5,6},{7,8,9}};
		int min = metrix[0][0];
		int minRow = 0;		
		for (int i=0; i<3;i++) {
		    for (int j =0; j<3; j++) {
		        if (metrix[i][j]<min) {
		            min = metrix[i][j];
		            minRow = j;
		        }
		    }
		}
		
		System.out.print("\n"+ min);
	}
	
	/*
	 * Print only numbers in string 
	 */
	public static void printOnlyNumbers(String str) {
		String sumbers = str.replaceAll("[^0-9]", "");
		System.out.println("\n"+sumbers);
	}
}
