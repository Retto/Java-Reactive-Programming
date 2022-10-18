package com.retto.reactive;

import java.io.IOException;

/**
 * Note: Subscribe method triggers to execution
 * 
 * @author Kobiz
 *
 */
public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
//        ReactiveSources.intNumbersFlux()
//        	.log()
//        	.filter(number -> number > 5)
//        	.subscribe(System.out::println);

        // Print 10 multiplied by each value from intNumbersFlux that's greater than 5
//        ReactiveSources.intNumbersFlux()
//        	.filter(number -> number > 5)
//        	.map(number -> number * 10)
//        	.subscribe(System.out::println);      	

        // Print 10 multiplied by each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        /* ReactiveSources.intNumbersFlux()
    	.filter(number -> number > 5)
    	.take(3)
    	.map(number -> number * 10)
    	.subscribe(System.out::println); */      	
        
        // Print each value from intNumbersFlux that's greater than 20. 
        // Print -1 if no elements are found
        /* ReactiveSources.intNumbersFlux()
    	.filter(number -> number > 20)
    	.defaultIfEmpty(-1)
    	.subscribe(System.out::println); */        

        // Switch ints from intNumbersFlux to the right user from userFlux
    	// Note map => flatMap 
    	// FluxFilter => object
    	// Flux<Flux<User>>  => Flux<User> 
        /* ReactiveSources.intNumbersFlux()
        	.flatMap(number -> ReactiveSources.userFlux().filter(user -> user.getId() == number).take(1))
        	.subscribe(System.out::println); */

        // Print only distinct numbers from intNumbersFluxWithRepeat
        /* ReactiveSources.intNumbersFluxWithRepeat()
        	.distinct()
        	.subscribe(System.out::println); */
        

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.intNumbersFluxWithRepeat()
        .log()
    	.distinctUntilChanged()
    	.subscribe(System.out::println);

        
        System.out.println("Press a key to end");
        System.in.read();
    }

}
