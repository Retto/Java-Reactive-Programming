package com.retto.reactive;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe( 
        		number -> System.out.println(number), 
        		err -> System.err.println(err.getMessage()),
        		() -> System.out.println("Completed")
        		);

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<Integer>());

        System.out.println("Press a key to end");
        System.in.read();
    }    
}

class MySubscriber<T> extends BaseSubscriber<T> {
	
	@Override
	protected void hookOnSubscribe(Subscription subscription) {
		System.out.println("Subscribe happened");
		request(1);
	}
	
	@Override
	protected void hookOnNext(T value) {
		System.out.println(value.toString() + " received");
		request(1);
	}
		
	@Override
	protected void hookOnComplete() {
		System.out.println("Completed");
	}
	
	@Override
	protected void hookOnError(Throwable throwable) {
		System.err.println(throwable.getMessage());
	}
	
	
}