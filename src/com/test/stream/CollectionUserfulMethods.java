package com.test.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import com.test.model.Person;

public class CollectionUserfulMethods {

	public static void main(String[] args) {
		Integer[] numbersArray = new Integer[] { 1, 2, 3, 4, 5 };
		
		System.out.println(
				Arrays.stream(numbersArray).collect(Collectors.counting()));

		System.out.println(
				Arrays.stream(numbersArray).collect(Collectors.summingInt((Integer x) -> x)));
		
		System.out.println(
				Arrays.stream(numbersArray).collect(Collectors.averagingInt((Integer x) -> x)));
		
		System.out.println(
				Arrays.stream(numbersArray).collect(Collectors.maxBy(Integer::compare)).get());
		
		System.out.println(
				Arrays.stream(numbersArray).collect(Collectors.minBy(Integer::compare)).get());
		
		System.out.println(
				Arrays.stream(numbersArray) .collect(Collectors.summarizingInt((Integer x) -> x)));

	}

}
