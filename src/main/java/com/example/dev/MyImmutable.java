package com.example.dev;

public final class MyImmutable {
	//Class is declared final so no child class
	//all variable are final ad private.
	//there is no setter methods
	//Parametrize constrcutors initialize all field , Deep copy if required
	//Deep copy in method getter methods instead of original obj
	
	private final int ab;
	


	private final String b;
	
	public int getA() {
		return ab;
	}

	public String getB() {
		return b;
	}
	
	public MyImmutable(int i, String b) {
		this.ab=i;
		this.b=b;
	}
	
	

}
