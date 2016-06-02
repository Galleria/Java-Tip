package com.test.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.test.model.Person;


public class GetSomethingFromCollectionToList {

	public static void main(String[] args) {
		Collection<Person> personList = initCollection();
		
		List<String> nameOfPersonList = personList.stream().map( Person::getUserName ).collect( Collectors.toList() );
		nameOfPersonList.stream().forEach(System.out::println);
		
		List<Boolean> sexOfPersonList = personList.stream().map( Person::isSex ).distinct().collect( Collectors.toList() );
		sexOfPersonList.stream().forEach(System.out::println);
		
		List<Integer> ageOfPersonList = personList.stream().map( Person::getAge ).distinct().collect( Collectors.toList() );
		ageOfPersonList.stream().forEach(System.out::println);
		
		distinctAndCountAge( personList );
		distinctAndCountName( personList );
		distinctAndCountSex( personList );
	}

	private static void distinctAndCountAge( Collection<Person> personList ){
		Map<Integer, Long> countList = personList.stream()
												.collect( Collectors.groupingBy( Person::getAge , Collectors.counting() ) );

		System.out.println("Age average Count ::");
		countList.forEach( (k,v) ->{ System.out.println("Item : " + k + " Count : " + v); } );	
		System.out.println();
	}
	
	private static void distinctAndCountName( Collection<Person> personList ){
		Map<String, Long> countList = personList.stream()
												.collect( Collectors.groupingBy( Person::getUserName , Collectors.counting() ) );

		System.out.println("Name average Count ::");
		countList.forEach( (k,v) ->{ System.out.println("Item : " + k + " Count : " + v); } );	
		System.out.println();
	}
	
	private static void distinctAndCountSex( Collection<Person> personList ){
		Map<Boolean, Long> countList = personList.stream()
												.collect( Collectors.groupingBy( Person::isSex , Collectors.counting() ) );

		System.out.println("Sex average Count ::");
		countList.forEach( (k,v) ->{ System.out.println("Item : " + k + " Count : " + v); } );	
		System.out.println();
	}
	
	private static Collection<Person> initCollection(){
		Collection<Person> list = new ArrayList<>();
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		
		p1.setUserName("Supachai").setSex(true).setAge(20);
		p2.setUserName("Kimchit").setSex(false).setAge(35);
		p3.setUserName("Wirapong").setSex(true).setAge(20);
		p4.setUserName("Kiattchai").setSex(true).setAge(28);
		
		list.add( p1 );
		list.add( p2 );
		list.add( p3 );
		list.add( p4 );
		return list;
	}
	
}
