# Employees Web Demo
> The employees web demo application using Angular 8+ Frontent with SpringBoot (Java) Backend.


This is the demo for employees web application that uses the Spring Boot to implement a RESTful backend, and Angular to create a JavaScript-based frontend.  

## Technology Stack

| Component | Technology |
| --- | --- |
| Frontend | [Angular 8](https://angular.io/) |
| Backend (REST) | [SpringBoot](https://projects.spring.io/spring-bootava) (Java)|
| Database | [MySQL](https://www.mysql.com/) (5.7.29)|
| Persistence | [JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference) (Using Spring Data) |
| Client Build Tools | [angular-cli](https://github.com/angular/angular-cli), [Webpack](https://webpack.js.org/concepts/), [NPM](https://www.npmjs.com/) |
| Server Build Tools | [Maven](https://github.com/apache/maven) (Java)|

## Installation Setup

### Backend
```sh
cd employees-web-demo
mvn spring-boot:run
```
### Frontend
```sh
cd employees-web-demo/webapp
npm install
npm install @angular/material @angular/cdk
npm install hammerjs
npm install @angular/flex-layout rxjs-compat
ng serve --open
```
