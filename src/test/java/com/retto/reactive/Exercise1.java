package com.retto.reactive;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
    	StreamSources.intNumbersStream()
    	.forEach( x -> System.out.println(x)); // Consumer function
    	System.out.println("---------------");
        StreamSources.intNumbersStream()
        .forEach(System.out::println); // method reference    	 
        System.out.println("---------------");
        
        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream()
        .filter(x -> x < 5)
        .forEach(System.out::println);
        System.out.println("---------------");
        
        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream()
        	.filter(x -> x > 5)
        	.skip(1)
        	.limit(2)
        	.forEach(System.out::println);
        System.out.println("---------------");

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        StreamSources.intNumbersStream()
        	.filter( x -> x > 5)
        	.findFirst()
        	.ifPresentOrElse(x -> System.out.println(x), () -> System.out.println(-1));
        System.out.println("---------------");

        // Print first names of all users in userStream
        StreamSources.userStream()
        	.map( user -> user.getFirstName())
        	.forEach(System.out::println);
        System.out.println("---------------");

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream()
        	.filter(x -> StreamSources.intNumbersStream().anyMatch( y -> y == x.getId()))
        	.map(t -> t.getFirstName())
        	.forEach(System.out::println);
        System.out.println("---------------");

    }

}
