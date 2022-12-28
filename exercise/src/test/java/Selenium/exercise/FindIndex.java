package Selenium.exercise;

public class FindIndex {

	public static void main(String[] args) {
		int[] a = {1,2,7,5};
		for(int i = 0; i<a.length-1;i++) {
			if(a[i] + a[i+1] == 9) {
				System.out.println(i+" "+ (i+1));
				break;
			}
		}

	}

}
