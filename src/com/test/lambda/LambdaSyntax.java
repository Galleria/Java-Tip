package com.test.lambda;

import java.util.function.Consumer;

public class LambdaSyntax {
	
	//lambda syntax 
	//parameter -> expression body
	MathOperation addition = (int a, int b) -> a + b;
	
	//int ab(int a, int b) -> { a % b };
	
	public static void main(String[] arg){
		
	}
	
	interface MathOperation {
	      int operation(int a, int b);
	}
}
