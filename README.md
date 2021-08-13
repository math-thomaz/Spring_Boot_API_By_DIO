<h2>User API REST With Spring Boot</h2>

This is a project build on Digital Innovation One's course. Its an application where you can register, list, update and remove a user.

# About this project

https://springboot-userapi.herokuapp.com/api/v1/user

Despite its simplicity, there is some nice concepts utilized on this project. We applied MVC as a Design Pattern, 
relationship between entities and a great use of Spring-Boot's power, along with its dependencies, such as Lombok, Map Struct and
Jakarta Persistence.

# How to run
```bash
mvn spring-boot:run
```

# Testing
After run it, we recommend some API platform to test the requests, such as Postman or Insomnia. Now, try the requests below:

## POST Register User
url: <strong>localhost:8080/api/v1/user</strong>
body: JSON with the fields: "firstName", "lastName", "cpf" (format mask: 000.000.000-00), "birthDate", "phones", "type"
(choose between HOME, MOBILE or COMMERCIAL) and "number".

![Pic 1](https://github.com/math-thomaz/assets/blob/master/DIO/Java_Projects/Spring_API_By_DIO/POST.PNG)

## PUT Update User
url: <strong>localhost:8080/api/v1/user/:id</strong>
body: Same as POST Register User, with the "id" field as addition.

![Pic 2](https://github.com/math-thomaz/assets/blob/master/DIO/Java_Projects/Spring_API_By_DIO/PUT.PNG)

## GET List All Users
url: <strong>localhost:8080/api/v1/user</strong>
body: empty

![Pic 3](https://github.com/math-thomaz/assets/blob/master/DIO/Java_Projects/Spring_API_By_DIO/GETALL.PNG)

## GET List User By Id
url: <strong>localhost:8080/api/v1/user/:id</strong>
body: empty

![Pic 4](https://github.com/math-thomaz/assets/blob/master/DIO/Java_Projects/Spring_API_By_DIO/GETBYID.PNG)

## DELETE Remove User
url: <strong>localhost:8080/api/v1/user/:id</strong>
body: empty

![Pic 5](https://github.com/math-thomaz/assets/blob/master/DIO/Java_Projects/Spring_API_By_DIO/DELETE.PNG)

# Techs used
## Back-End
- Java 11
- Spring Boot
- Maven
- JPA
- Lombok
- Map Struct

## Deploy
- Heroku