package com.test.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectInCollections {
	public static void main(String args[])
	  {
	    Character[] chars = new Character[]
	                        { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
	 
	    // First a list
	    List<Character> l = Arrays.stream(chars)
	                              .collect(Collectors.toList());
	 
	    System.out.println(l);
	 
	    // toList gives us a generic list (code creates an ArrayList)
	    // Let's get a linked list
	    List<Character> ll = Arrays.stream(chars)
	                               .collect(
	                       Collectors.toCollection(LinkedList::new));
	 
	    System.out.println(ll);
	 
	    // toSet gives us a generic set (code creates a HashSet)
	    Set<Character> s = Arrays.stream(chars)
	                                   .collect(Collectors.toSet());
	 
	    System.out.println(s);
	 
	    // and now a generic map (code creates a HashMap)
	    Map<Character, Character> m = 
	                        Arrays.stream(chars).collect(
	                  Collectors.toMap((Character k) -> 
	                                       Character.toUpperCase(k),
	                                   Function.identity()));
	 
	    System.out.println(m);
	 
	    // What happens if keys clash?
	    try
	    {
	      Arrays.stream(chars).collect(
	                  Collectors.toMap((Character k) -> 'a', 
	                                   Function.identity()));
	    }
	    catch (IllegalStateException e)
	    {
	      System.out.println("Caught duplicate key");
	    }
	 
	    // Let's provide a function to resolve this
	    // we'll keep the first
	    Map<Character, Character> m2 =
	                        Arrays.stream(chars).collect(
	               Collectors.toMap((Character k) -> 'a',
	                                Function.identity(),
	                               (v1, v2) -> v1));
	 
	    System.out.println(m2);
	 
	    // If we return null from our merge function,
	    // the latest is kept
	    Map<Character, Character> m3 =
	                        Arrays.stream(chars).collect(
	                Collectors.toMap((Character k) -> 'a',
	                                 Function.identity(),
	                                 (v1, v2) -> null));
	 
	    System.out.println(m3);
	 
	    // We can also request a different type of map
	    Map<Character, Character> m4 =
	                        Arrays.stream(chars).collect(
	                Collectors.toMap(
	                   (Character k) -> Character.toUpperCase(k),
	                                 Function.identity(),
	                                 (v1, v2) -> v1,
	                                 TreeMap::new));
	 
	    System.out.println(m4);
	  }
}
