package com.example.dev;

public class ExampleTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			System.out.println(FileWriting());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static int FileWriting() throws Exception {
		int a=3;
		try {
			if(a==3) {
				return 5/0;
			}
			
		} catch(Exception e) {
			System.out.println("it is executed");
			throw new Exception("exc");
			
		} finally {
			try {
			int c=10/0;
			} catch(Exception e) {
			e.printStackTrace();	
			}
			
			
		System.out.println("Hello");	
			
		}
		return 6;
		
	}

}
