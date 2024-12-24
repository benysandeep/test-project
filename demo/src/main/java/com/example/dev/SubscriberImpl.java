package com.example.dev;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscriberImpl implements Subscriber<String> {
    
	private static final Logger log = LoggerFactory.getLogger(SubscriberImpl.class);
	@Override
	public void onSubscribe(Subscription s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNext(String t) {
		// TODO Auto-generated method stub
		log.info("Email Recieved" +t);
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}

}
