package test;
/*
public class RevString {

	public static void main(String[] args) {
		

	}

}
*/
import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
public class PublicisSapient {
   public static void main(String[] args) throws IOException {
	  
	   // Read file and get string from file
	   File file = new File(System.getProperty("user.dir")+"/String.text"); 
	   BufferedReader br  = new BufferedReader(new FileReader(file));
	   String[] str  = br.readLine().split(" ");
	   HashMap<String,Integer> map = new HashMap<String,Integer>();
	   for (String word:str) {
		   if (map.containsKey(word)) {
			   map.put(word, map.get(word)+1); 
		   } else {
			   map.put(word, 1);
		   }
	   }
	   
	   Collection<Integer> vaues = map.values();
	   Object[] obj = vaues.toArray();
	   
	   for (int i=0; i <obj.length; i++) {
		   int temp;
		   for (int j=0; j <obj.length-1; j++) {
			   if ((int)obj[i] > (int)obj[j]) {
				   temp = (int)obj[i];
				   obj[i] = (int)obj[j];
				   obj[j] = temp;
			   }
		   }
	   }
	   
	   int count=0;
	   String word="";
	   for (Entry<String, Integer> entry: map.entrySet()) {
		   if (entry.getValue() == obj[0]) {
			   word = entry.getKey();
			   count++;
			}
		  
	   }
	   
	   if(count > 1) {
		  System.out.println(-1);
	   } else {
		  System.out.println(word);
	   }
	   
   }

}