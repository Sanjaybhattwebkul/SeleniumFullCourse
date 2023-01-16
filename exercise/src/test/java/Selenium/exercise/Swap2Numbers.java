package Selenium.exercise;

import java.util.Scanner;

public class Swap2Numbers {

	public static void main(String[] args) {
		int a=10, b =30;
		b = b+a;
		a = b-a;
		b = b-a;
		System.out.println(a);
		System.out.println(b);
		
	}

}
