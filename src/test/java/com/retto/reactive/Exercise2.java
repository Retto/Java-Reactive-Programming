package com.retto.reactive;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
    	ReactiveSources.intNumbersFlux().subscribe( 
        		number -> System.out.println(number), 
        		err -> System.err.println(err.getMessage()),
        		() -> System.out.println("Completed")
        		);
    	
        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));    	

        System.out.println("Press a key to end");
        System.in.read(); 
    }

}
