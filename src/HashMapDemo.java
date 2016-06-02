

import java.util.HashMap;

public class HashMapDemo {
   @SuppressWarnings("unchecked")
public static void main(String args[]) {
   // create two hash maps
   HashMap<Integer, String> newmap1 = new HashMap<Integer, String>();
   HashMap<Integer, String> newmap2 = new HashMap<Integer, String>();
      
   // populate 1st map
   newmap1.put(1, "tutorials");
   newmap1.put(2, "point");
   newmap1.put(3, "is best"); 
      
   // clone 1st map
   newmap2=(HashMap<Integer, String>)newmap1.clone();
      
   System.out.println("1st Map: " + newmap1);
   System.out.println("Cloned 2nd Map: " + newmap2);   
   }    
}