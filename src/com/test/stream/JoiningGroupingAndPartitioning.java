package com.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class JoiningGroupingAndPartitioning {

	public static void main(String args[])
	  {
	    Character[] chars =
	           new Character[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g' };
	 
	    // Join them all together
	    System.out.println(
	           Arrays.stream(chars).map(x -> x.toString())
	                               .collect(Collectors.joining()));
	 
	    // Join with a ,
	    System.out.println(
	           Arrays.stream(chars).map(x -> x.toString())
	                            .collect(Collectors.joining(",")));
	 
	    // Join with a , and surround the whole thing with []
	    System.out.println(Arrays.stream(chars)
	                             .map(x -> x.toString())
	                             .collect(
	                           Collectors.joining(",", "[", "]")));
	 
	    // Group into two groups
	    Map<String, List<Character>> group1 =
	           Arrays.stream(chars).collect(
	                           Collectors.groupingBy(
	          (Character x) -> x < 'd' ? "Before_D" : "D_Onward"));
	 
	    System.out.println(group1);
	 
	    // As before, but group values with like keys in a set
	    Map<String, Set<Character>> group2 =
	           Arrays.stream(chars).collect(
	                           Collectors.groupingBy(
	          (Character x) -> x < 'd' ? "Before_D" : "D_Onward",
	                                         Collectors.toSet()));
	 
	    System.out.println(group2);
	 
	    // Put the whole grouping structure in a TreeMap
	    Map<String, Set<Character>> group3 =
	           Arrays.stream(chars).collect(
	                           Collectors.groupingBy(
	          (Character x) -> x < 'd' ? "Before_D" : "D_Onward",
	                             TreeMap::new,
	                             Collectors.toSet()));
	 
	    System.out.println(group3);
	 
	    // Partition into two lists
	    Map<Boolean, List<Character>> partition1 =
	           Arrays.stream(chars).collect(
	                            Collectors.partitioningBy(
	                                 (Character x) -> x < 'd'));
	 
	    System.out.println(partition1);
	 
	    // Partition into two sets
	    Map<Boolean, Set<Character>> partition2 =
	           Arrays.stream(chars).collect(
	                            Collectors.partitioningBy(
	                                 (Character x) -> x < 'd',
	                                       Collectors.toSet()));
	 
	    System.out.println(partition2);
	  }

}
