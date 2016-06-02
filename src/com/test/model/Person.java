package com.test.model;

import java.io.Serializable;
import java.util.function.Predicate;

public class Person implements Serializable{
	private static final long serialVersionUID = -3524729138509094697L;
	
	public static final Predicate<Person> isMale = m -> m.sex ;
	public static final Predicate<Person> above15 = m -> m.age > 15;
	public static final Predicate<Person> below40 = m -> m.age < 40;
	public static final Predicate<Person> between15To40 = above15.and(below40) ;
	
	String userName;
	int age;
	boolean sex;
	private String city;
	
	Person father;
	Person mother;
	
	public String getUserName() {
		return userName;
	}
	public Person setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public int getAge() {
		return age;
	}
	public Person setAge(int age) {
		this.age = age;
		return this;
	}
	public boolean isSex() {
		return sex;
	}
	public Person setSex(boolean sex) {
		this.sex = sex;
		return this;
	}
	public Person getFather() {
		return father;
	}
	public void setFather(Person father) {
		this.father = father;
	}
	public Person getMother() {
		return mother;
	}
	public void setMother(Person mother) {
		this.mother = mother;
	}
		
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Person(String userName, String city) {
		super();
		this.userName = userName;
		this.city = city;
	}
	
	public Person(String userName, int age, boolean sex) {
		super();
		this.userName = userName;
		this.age = age;
		this.sex = sex;
	}
	
	public Person() {
		super();
	}
	
	@Override
	public String toString() {
		if( (father != null) && (mother != null) )
		return "Person [userName=" + userName + ", age=" + age + ", sex=" + sex + ", father=" + father + ", mother="
				+ mother + "]";
		else
			return "Person [userName=" + userName + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
	
}
