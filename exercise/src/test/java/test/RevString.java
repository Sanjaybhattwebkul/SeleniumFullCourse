package test;
/*
public class RevString {

	public static void main(String[] args) {
		

	}

}
*/
import java.io.*;
public class RevString {
   public static void main(String[] args) throws IOException {
	   // Read file and get string from file
	   File file = new File("C:\\Users\\pankaj\\Desktop\\test.txt"); 
	   BufferedReader br  = new BufferedReader(new FileReader(file));
	   String str  = br.readLine();
       for( int i=str.length()-1; i >=0; i--)  {
          System.out.print(str.charAt(i));
       }
   }

}