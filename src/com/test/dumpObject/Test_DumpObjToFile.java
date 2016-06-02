package com.test.dumpObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.test.model.Person;

public class Test_DumpObjToFile {

	final static String FileName = "DumpObject.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		Person me = new Person( "Karen" , 23, false);
		Person dad = new Person( "Raffy" , 42 , false );
		Person mom = new Person( "Sofia" , 42 , false );
		
		me.setFather( dad );
		me.setMother( mom );
		
		writeToObject(me);
		 
		Person psObject = (Person) readObject();
		
		System.out.println( psObject );
		System.out.println( psObject.getAge() );
		System.out.println( psObject.getUserName() );
		 
	}

	public static void writeToObject(Object obj) throws FileNotFoundException, IOException{
		 
		 ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FileName));
		 objectOutputStream.writeObject( obj );
		 objectOutputStream.close();
		 
	}
	
	public static Object readObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream objectInputStream = new ObjectInputStream( new FileInputStream(FileName));

		Person pr = (Person) objectInputStream.readObject();
		objectInputStream.close();
		
		return pr;
	}
}
