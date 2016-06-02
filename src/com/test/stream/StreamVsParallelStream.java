package com.test.stream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamVsParallelStream {
	private static long startTime;
    private static long endTime;
    
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for( double i=0 ; i< 100_000_000 ; i++){
			numbers.add( (int)Math.round( Math.random()*100 ) );
		}
		
		System.out.println("userStream :: ");
		userStream(numbers);
		
		System.out.println("userParallelStream :: ");
		userParallelStream(numbers);
		
	}
	
	public static void userStream(List<Integer> numbers){
		startTime = Calendar.getInstance().getTimeInMillis();
		List<Integer> ab = numbers.stream().sorted().collect( Collectors.toList() );
		endTime = Calendar.getInstance().getTimeInMillis();
	    System.out.println("userStream :: " + (endTime - startTime) + " ms : thread->"+Thread.activeCount());
	}

	public static void userParallelStream(List<Integer> numbers){
		startTime = Calendar.getInstance().getTimeInMillis();
		List<Integer> ab = numbers.stream().parallel().sorted().collect( Collectors.toList() );
		endTime = Calendar.getInstance().getTimeInMillis();
	    System.out.println("userParallelStream :: " + (endTime - startTime) + " ms : thread->"+Thread.activeCount());
	}
	
	
	
	/*
	Collection <Long> revFileIdList = allDocList
											.stream()
											.map( doc -> doc.getSupmntDocnId() )
											.collect( Collectors.toList() );
	*/

	
}
