package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class testPridicePersonSex {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setUserName("Supachai").setSex(true).setAge(20);
		
		Person p2 = new Person();
		p2.setUserName("Mint").setSex(false).setAge(20);
		/*
		System.out.println( Person.isMale.test(p1) );
		System.out.println( Person.isMale.test(p2) );
		*/
		List< Person > personList = new ArrayList<>();
		personList.add( p1 );
		personList.add( p2 );
		personList.stream()
					.allMatch( Person.isMale );
					/*.filter( Person.isMale )
					.findAny()
					.ifPresent( p -> System.out.println("is male") );*/
					/*.forEach( // p -> System.out.println( Person.isMale.test(p) )
							 p -> { 
								 //System.out.println( Person.isMale.test(p) ) ;
								 if(Person.isMale.test(p) == true) 
									 System.out.println("is male"); 
								else 
									System.out.println("is Female");
							 }
							);*/
							
							
	}

}
