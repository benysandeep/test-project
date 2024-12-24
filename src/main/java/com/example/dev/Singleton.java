package com.example.dev;

public class Singleton {
	
	public String name;
	
	private static Singleton singleton = null;
	
	public int age;

	private Singleton() {
	this.name="Hello";
	this.age=27;
	}
	
	public static synchronized Singleton getInstance() {
		if(null == singleton) {
			singleton = new Singleton();
		} 
		return singleton; 
	}
	

}
