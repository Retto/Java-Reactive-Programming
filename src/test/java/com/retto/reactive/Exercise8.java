package com.retto.reactive;

import java.io.IOException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        /* ReactiveSources.intNumbersFluxWithException()
        	.subscribe(System.out::println, error -> System.out.println(error.getMessage())); */

    	// stop on error
        /* ReactiveSources.intNumbersFluxWithException()
        .doOnError(error -> System.out.println(error.getMessage()))
    	.subscribe(System.out::println); */

    	// continue on error (error hiding (or error swallowing error))
        // Print values from intNumbersFluxWithException and continue on errors
        /* ReactiveSources.intNumbersFluxWithException()
        	.onErrorContinue((error, item) -> System.out.println("Error:" + error.getMessage() + " - item:" + item))
        	.subscribe(System.out::println); */

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        /* ReactiveSources.intNumbersFluxWithException()
        	.onErrorResume(error -> Flux.just(-1, -2))
        	.subscribe(System.out::println); */ 
        
    	// try-catch analogy
        ReactiveSources.intNumbersFluxWithException()
    	.doFinally(signal -> {
    		if(signal == SignalType.ON_COMPLETE) {
    			System.out.println("Done!");
    		} else if(signal == SignalType.ON_ERROR) {
    			System.out.println("Error!");
    		}
    	}).subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
