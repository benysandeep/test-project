package com.example.dev;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Question {

	public static void main(String[] args) {
	String a = "123";
	int k = Arrays.stream(a.split("")).collect(Collectors.summingInt(Integer::valueOf));
    System.out.println(k);
	}
	
	public static void show(Person p) {
		System.out.println("Object");
	}
	
	public static void show(String p) {
		System.out.println("String");
	}

}
