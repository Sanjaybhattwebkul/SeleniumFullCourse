public class MathTest {
 //https://prnt.sc/zfbdivs7G2AC
 //https://www.onlinegdb.com/online_java_compiler
      public static void main(String[] args) {
                                         
        int x = (10*10)-10;
                                         
        System.out.println(x);

      }
    
    }


    stale   eror. 

    Set<itrator> wondows = driver.getWindowHandlers();

    Input Array = {2,7,0,9,0,6,5,4,0,1,0}
    Output = {2,7,9,6,5,4,1,0,0,0,0}


*************************************

public class Main
{
	public static void main(String[] args) {
	    int[] Array = {2,7,0,9,0,6,5,4,0,1,0,0};
	  
	    for(int i=0; i<Array.length-1; i++){
	        if(Array[i] != 0){
	            System.out.print(Array[i]);
	        }else if (Array[i] ==0 && Array[i+1]==0) {
	             System.out.print(Array[i]);
	        }
	        if(i == Array.length) {
	            break;
	        }
	       
	    }

******************************







=================================

    class First {
      int i = 10;       
      public First(int j) {
        System.out.println(i);
        this.i = j * 10;
      }
    }
       
    class Second extends First {
      public Second(int j) {
        super(j);
        System.out.println(i);
        this.i = j * 20;
      }
    }
      
    public class MainClass {
      public static void main(String[] args) {
        Second n = new Second(20);
        System.out.println(n.i);
      }
    }


      ============================================

      class First {
            public First() {
                System.out.println("a");
            }
        }
         
        class Second extends First {
            public Second() {
                System.out.println("b");
            }
        }
         
        class Third extends Second {
            public Third() {
             
             System.out.println("c");
            }
        }
         
        public class MainClass {
            public static void main(String[] args) {
                Third c = new Third();
            }
        }

=============================

public class MathTest {
 
  public void main(String[] args) {
                                     
    int x = 10*10-10;
                                     
    System.out.println(x);
  }

}