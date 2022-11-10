# WebService

How to start the WebService application
---

1. Run `mvn clean install` to build your application
2. You need to run this in IDE with properties of "server" on ./src/main/java/WebServiceApplication
3. To check that your application is running enter url `http://localhost:8080`
4. Swagger link: http://localhost:8080/swagger
5. To connect to database you need to add login details to ./dbuser.properties both user and password in same manner (without e.g. quotation marks)

## ⚡ Technologies used inside project:
**Swagger**, **Java**, **Maven**, **Dropwizard**

## 🌱 Good practices used:
To create this app we did our best to write our code using SOLID principles, KISS and DRY;
Also we decided to uses cascade constructor design pattern.

