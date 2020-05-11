# Learn Spring Boot by Annotations

## Overview

I created this [Spring Boot](https://spring.io/projects/spring-boot) project to showcase some of the most important Spring Annotations (e.g. @Component). For more background information, checkout my blog post on [dev.to](https://dev.to/pmgysel).

## Functionality of app

This is a simple Spring Boot RESTful web service.

REST endpoints:
* PUT /api/weather with WeatherRJ as body: Save weather data for a city
* GET /api/weather/<city name>: Query weather data of a city

WeatherRJ data object:
{
  "city": String,
  "temperature": Int
}

Moreover, this app performs a regular background task, calculating the average temperature of all weather data. This task runs every 20 seconds.

## Run the app yourself

Prerequisites:
* Java 8 JDK
* Maven
* Git
* curl

Download the code and run the app:

```bash
git clone https://github.com/pmgysel/spring-boot-annotations.git
cd spring-boot-annotations
mvn clean install
java -jar target/spring-boot-annotations-0.0.1-SNAPSHOT.jar
```

Now you can create and read weather data using the exposed REST endpoints.

curl on Linux:

```bash
curl -H "Content-Type: application/json" -X PUT -d '{"city":"zurich","temperature":22}' http://localhost:8080/api/weather
curl -X GET http://localhost:8080/api/weather/zurich
```

curl on Windows:

```bash
curl -H "Content-Type: application/json" -X PUT -d "{\"city\":\"zurich\",\"temperature\":22}" http://localhost:8080/api/weather
curl -X GET http://localhost:8080/api/weather/zurich
```

## Built with

The following frameworks and libraries were used:
* Spring Boot
* H2 database
* Spring-Data-JPA
* Spring-Web
* Java 8
* Maven
