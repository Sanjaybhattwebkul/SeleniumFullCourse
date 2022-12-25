package Selenium.exercise;

import java.util.Scanner;

public class PrintAlphabetOnly {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Any String");
		String str = sc.nextLine().replaceAll("[0-9]", "");
		System.out.println(str);
	}

}
