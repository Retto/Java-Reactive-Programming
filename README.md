# Java-Reactive-Programming
Simple Java reactive programming exercises

## Standart Java
**subscribe()** method is the key method to trigger activation of reactive code.

See **Exercise2.java** file
Program Counter on line 12
There are active **two** threads:
- main thread on line 12
- parallel-1 thread for reactive operations on line 12
![Screenshot_3](https://user-images.githubusercontent.com/3144356/196479900-140c6241-18ea-4175-ab15-48cf7ecd9e27.png)

Program Counter on line 17
There are active **three** threads:
- main thread on line 17
- parallel-1 thread for reactive operations on line 12
- parallel-2 thread for reactive operations on line 15
![Screenshot_4](https://user-images.githubusercontent.com/3144356/196479834-6fbfabe2-6210-4e71-9c5f-c1cd02dcce8b.png)

## Spring Boot
**WebFlux** and **Netty** are used for the Reactive programming paradigm in Spring Boot.

See **MyController.java** Rest controller for the simple example.

**hello()** method return **Mono\<String\>** **immediately** for an HTTP request. WebFlux and Netty manage the response under the hood. So, the **MyController** class is **non-blocking**. 

Try to delegate all functionality to **operators** to provide maximum utilization of the non-blocking approach. This is the key point!

See the image below. 
![Screenshot_7](https://user-images.githubusercontent.com/3144356/196479127-7adef124-f9ac-4b98-ad9b-2c5f3de19c2b.png)

## Starter video
Really well-prepared starter video
https://www.youtube.com/watch?v=A5nCPqPH3Fc

## Get Your Hands Dirty
Watch a more detailed starter video with practicing
https://www.youtube.com/playlist?list=PLqq-6Pq4lTTYPR2oH7kgElMYZhJd4vOGI

# More References
- https://projectreactor.io/
- https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html
- https://www.digitalocean.com/community/tutorials/spring-webflux-reactive-programming
