package com.test.dumpObject;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.model.Person;

public class Test_DumpObjToJson_ToFile {
	
	final static String FileName = "DumpJson.txt";
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		Person me = new Person( "Karen" , 23, false);
		Person dad = new Person( "Raffy" , 42 , false );
		Person mom = new Person( "Sofia" , 42 , false );
		
		me.setFather( dad );
		me.setMother( mom );
		
		writeJsonToFile( me );
		
		Person psJson = readJsonFromFile();
		
		System.out.println( psJson );
		System.out.println( psJson.getAge() );
		System.out.println( psJson.getUserName() );
		
	}
	
	public static void writeJsonToFile(Person ps) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File(FileName), ps);
	}
	
	public static Person readJsonFromFile() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Person ps = mapper.readValue(new File(FileName), Person.class);
		
		return ps;
	}
}
