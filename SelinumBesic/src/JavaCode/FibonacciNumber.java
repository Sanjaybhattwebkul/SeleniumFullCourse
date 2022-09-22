package JavaCode;

public class FibonacciNumber {

	public static void main(String[] args) {
			FibonacNumber(10,0,1);
	}
	
	public static void FibonacNumber(int count, int number1, int number2) {
		System.out.println(number1);
		System.out.println(number2);
		for(int i=0; i<=count;i++) {
			
			int number3  = number1 + number2;
			System.out.println(number3);
			number1 = number2;
			number2 = number3;
		}
	}

}
