package com.example.dev;

public class ClassB extends ClassC {
	Integer l;
	int i;
	String r;
	public static void main(String[] args) {
		getDetails();
	}
	
	public void myDetails() {
		System.out.println("hello");
	}
	
	public static void getDetails() {
		ClassC c = new ClassB(); 
		System.out.println(c.j);
		ClassB b = new ClassB();
		System.out.println(b.j);
		
	}
	
	}
	
	
	
	
	


