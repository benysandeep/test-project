package com.example.dev;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {
	
	public static void main(String[] args) throws Exception {
		try {
			
			testException(-5);
			testException(-10);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
			//throw new Exception();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Releasing resources");
		}
		testException(15);
	}
	
	public static void testException(int i) throws FileNotFoundException, IOException {
		if (i < 0) {
			FileNotFoundException myException = new FileNotFoundException("Negative Integer " + i);
			throw myException;
		} else if (i > 10) {
			throw new IOException("Only supported for index 0 to 10");
		}
	}

}
