package com.test.binary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumericLiterals {
	
	public static void main(String[] arg){
		int thousand = 1_000;
		int ten_thousand = 10_000;
		
		System.out.println( thousand );
		System.out.println( ten_thousand );
		
		switchCaseString();
	}
	
	public static void switchCaseString(){
		Random rand = new Random();
		char ch = (char) (rand.nextInt(26)+97);
		switch( ch ){
		case 'a': case 'b' : System.out.println( ch ); break;
		default: System.out.println( String.valueOf(ch).toUpperCase() ) ;
		}
	}
	
	public static void suppressedException() throws Exception{
		new Exception("test exception");
	}
	
	public static void multicastException() throws Exception{
		try{
			
		}catch(NullPointerException | NumberFormatException | StringIndexOutOfBoundsException e){
			throw e;
		}
	}
	
	
	public static void DiamondOperator() throws Exception{
		List<String> StrOld = new ArrayList<String>();
		List<String> StrNew = new ArrayList<>();
	}
	
}
