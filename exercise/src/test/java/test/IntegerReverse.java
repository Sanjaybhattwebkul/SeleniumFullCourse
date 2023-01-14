package test;

public class IntegerReverse {

	public static void main(String[] args) {
		rev(123);

	}
	
	public static void rev(int num) {
		int rev =0;
		while(num !=0) {
			rev = (rev*10) + (num%10);
			num = num/10;
		}
		System.out.println(rev);
	}

}
