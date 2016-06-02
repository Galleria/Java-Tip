package com.test.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.test.model.Person;

public class ConvertListToMap {

	public static void main(String[] args) {
		 List<Person> list = new ArrayList<>();
	        list.add(new Person("Supachai", "bangkok"));
	        list.add(new Person("lisa","kansas"));
	        list.add(new Person("laboze", "hunter"));

	        //example 1
	        Map<String, String> result1 = list.stream().collect(
	                Collectors.toMap(Person::getUserName, Person::getCity));

	        System.out.println("Result 1 : " + result1);

	        //example 2
	        Map<String, String> result2 = list.stream().collect(
	                Collectors.toMap(x -> x.getUserName(), x -> x.getCity()));

	        System.out.println("Result 2 : " + result2);
	}

}
