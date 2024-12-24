package com.example.dev;

public class ClassA {
	
	
	
	public static void main(String args[]) {
		devideBy(1,0);
	}
	
	public static int devideBy(int a, int b) {
		int c = -1;
		try {
		c=a/b;
		} catch (Exception x) {
			System.out.println("exception");
			throw x;
		} finally {
			System.out.println("finally");
		}
		
		
		return c;
	}

}
