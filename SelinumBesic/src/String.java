import java.util.HashMap;

public class String {

	public static void main(java.lang.String[] args) {
		// TODO Auto-generated method stub
		
		java.lang.String myText = "Sanjay Bhatt";
		
		// Remove all space from string
		myText = myText.replaceAll("\\s", "");		
		int count=1;		
		System.out.println(myText);	
		//char c = 'a';
        for (int i=0; i< myText.length(); i++)
        {
        	//System.out.println(myText.charAt(i));
        	// checking character in string
        	for (int j=1; j< myText.length(); j++) {
        		 if (myText.charAt(i) == myText.charAt(j)) {
        			 count++; 
        		 }
                 	
        		// System.out.println(myText.charAt(j));
        	}       	
           
        	 System.out.println(myText.charAt(i)+"-"+count);
        	 count=0;
        	// System.out.println(count);
        }
        //System.out.println(count);
		   
		    
	}
	
	

}
