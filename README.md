## Spring Boot Rest Template

Project serves as a client by consuming RESTful web services w/ Spring Data Rest.
> Spring Data Rest provides a quick and easy way to expose CRUD operations on entities as RESTful endpoints, thus providing rapid prototyping of RESTful APIs.
   
Spring Data Rest creates RESTful endpoints by consuming controller from [spring6-rest-mvc](https://github.com/laurakciic/spring6-rest-mvc) project.

## Technologies
- Spring Data Rest, Spring Pageable, OAuth, JUnit, Mockito

## Notes 
- project must run in conjunction with [spring6-auth-server](https://github.com/laurakciic/spring6-auth-server) and [spring6-rest-mvc](https://github.com/laurakciic/spring6-rest-mvc) projects

Uses [spring6-auth-server](https://github.com/laurakciic/spring6-auth-server) to obtain the JWT token and utilizes it to work with the resource server to export resources from [spring6-rest-mvc](https://github.com/laurakciic/spring6-rest-mvc) using this RestTemplate project.
