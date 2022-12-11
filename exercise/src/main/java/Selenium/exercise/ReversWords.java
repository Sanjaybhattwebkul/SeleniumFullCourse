package Selenium.exercise;

public class ReversWords {

	
	public static void main(String[] args) {		
		String name = "SANJAY BHATT WEBKUL";
		String[] nameArray = name.split(" ");		
		for (int i=nameArray.length-1; i>=0; i--) {
			System.out.print(nameArray[i]+" ");
		
		}		
	}

}
