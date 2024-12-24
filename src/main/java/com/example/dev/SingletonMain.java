package com.example.dev;

public class SingletonMain {

	public static void main(String[] args) {
		Singleton A = Singleton.getInstance();
		System.out.println(A.age);
		System.out.println(A.hashCode());
		Singleton B = Singleton.getInstance();
		System.out.println(B.hashCode());

	}

}
