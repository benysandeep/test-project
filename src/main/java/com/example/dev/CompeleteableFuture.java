package com.example.dev;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompeleteableFuture {
	
	public static void main(String[] args) {
		calSync();

	}
	
	public static void calSync(){
		
		CompletableFuture<String> cFuture = new CompletableFuture<>();
		cFuture.supplyAsync(()->{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cFuture.complete("Hello");
			return cFuture;
		});
		
		cFuture.thenAccept(result->System.out.println(result));
	}
	
	
	

}
