package Selenium.exercise;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

public class AllProgram {

	public static void main(String[] args) {
		System.out.print(choountCharacter("Sanjujis"));
		
		secondHeighestword("sanju sas sanju sanju is sas sanju");
		
		// PRIME NUMER
		if(isPrime(12)) {
			System.out.println("IsPrime");
		} else { 
			System.out.println("Not Prime");
		}
		
		// ARMSTRONG
		if(isArmStrong(153)) {
			System.out.println("\n is armstring number");
		}else {
			System.out.println("\n is armstring number");
		}
		
		// BEBONICCI
		printFabonicci(10);
		
		// Palandrom
		if(isPalandrom("sas")){
			System.out.println("\n is palandrom String");
		}else { 
			System.out.println("\n is not palandrom String");
		}
	}
	
	/*
	 * Count Each Character occurring in string.
	 */
	public static HashMap<Character, Integer> choountCharacter(String str) {
		String input = str.replaceAll("\\s", "").toLowerCase();
		char[] charArray= input.toCharArray();
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for (char word:charArray) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			} else {
				map.put(word, 1);
			}
		}
		return map;
	}
	
	/*
	 * Print Second Highest occurring word in string 
	 */
	public static void secondHeighestword(String str) {
		String[] input = str.split(" ");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for (String word: input) {
			if(map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			} else { 
				map.put(word, 1);
			}
		}
		
		// Short array
		Collection<Integer> values = map.values();
		Object[] obj = values.toArray();
		for (int i =0; i<obj.length;i++) {
			int temp;
			for(int j =0; j<obj.length-1; j++) {
				if((int)obj[i] > (int)obj[j]) {
					temp = (int)obj[i];
					obj[i] = obj[j];
					obj[j] = temp;
				}
			}
		}
		
		
		// get 1 index from map.
		for(Entry<String, Integer> entry: map.entrySet()) {
			if(entry.getValue() == obj[1]) {
				System.out.println("\n Second Heighest word is : "+ entry.getKey());
				break;
			}
		}
	}
	
	/*
	 * CheckPrime Number
	 */
	public static boolean isPrime(int number) {
		boolean flag=true;
		for(int i =2;i<number/2;i++) {
			if(number%i == 0) { 
				flag=  false;
				break;
			} else {
				continue;
			}
		}
		return flag;
	}
	
	/*
	 * ArmStrong Number
	 */
	
	public static boolean isArmStrong(int number) {
		String str = Integer.toString(number);
		double total =0;
		for(int i =0;i<str.length();i++) {
			int a = Integer.parseInt(String.valueOf(str.charAt(i)));
			total = total+(Math.pow(a, str.length()));
		}
		return (total == number) ? true : false;
	}
	
	/*
	 * fabonicci  series
	 */
	public static void printFabonicci(int range) {
		int a=0, b=1;
		for(int i=0;i < range; i++) {
			System.out.print(a+ " ");
			int c = a+b;
			a=b; b=c; c=a;
		}
	}
	
	/*
	 * Palandrom Strin
	 */
	
	public static boolean isPalandrom(String str) {
		String newString="";
		for(int i=str.length()-1; i >= 0; i--) {
			newString = newString+str.charAt(i);
		}
		return (str.equals(newString)) ? true : false;
	}
	
	
	
}



