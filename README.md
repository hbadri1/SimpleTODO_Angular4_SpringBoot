## SimpleTODO_Angular4_SpringBoot
A simple TODO list application developed with Angular 4, Bootstrap , Spring boot and mongDb

### Used tools/frameworks
STS, VisulaCode
Bootstrap, Angular 4, Spring boot, Spring, mongoDB

### Installation

-> Clone Project

-> Build Front end

- cd frontEndTodoApp
- run _install npm_ to install all dependencies
- run _ng build -prod_ (you should have already installe node, npm and angular/cli

=> We have compiled and generated the prod version of our front-end part.

-> Run mongodb server: 
- cmd -> _mongod --dbpath c:\database_ (choose the path you like)

-> Build backend

- cd TodoApplication folder (the backend)
- run _mvn clean install_
- run _mvn spring-boot:run_


-> Run the application
go to: _localhost:8888_ and you should get you application running
