package com.example.dev;

@FunctionalInterface
public interface StaticDefaultCheck {
	
	public void myDetails();
	
	default void NullCheck() {
		System.out.println("Null Check");
	}
	
	static void getDetails() {
		System.out.println("Below are details");
	}
		
	

}
