package com.example.dev;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		countChar();
		// TODO Auto-generated method stub

	}
	public static void countChar() {
		String input ="sandeep";
		
		input.chars().mapToObj(s->(char)s)
		     .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		     .entrySet().forEach(System.out::println);
				
	}

}
