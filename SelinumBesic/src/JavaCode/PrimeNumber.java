package JavaCode;

import java.util.*;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner num= new Scanner(System.in);
		System.out.println("Enter any number");
		int number= num.nextInt();
		for(int i=2; i <= number; i++) {
			boolean isPrime = true;
			for(int j =2 ; j<i; j++) {
				if(i%j==0) {
					
					isPrime=false;
					break;
				}
			}
			if(isPrime)
			{
			System.out.print(" "+i);
			}
		}

	}

}
