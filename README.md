# Sales-if-ua

### Environment configuration::
***************************************************

1. java SE 1.8.

2. apache-maven-3.2.5.

3. MySql Server 5.5 (Linux command: sudo apt-get install mysql-server-5.5)

4. Node.js

5. Bower

   npm install -g bower

6. Browse required libraries In your console go to the {system path}/sales-if-ua/src/main/webapp/app and type following comand:

   bower install


### Database steps:
***************************************************

1. Create user "salesifua" with password "salesifua" ubuntu command - create user "salesifua"@"localhost" identified by "salesifua"; grant all on . to "salesifua"@"localhost";

2. mysql -u salesifua -p salesifua

3. CREATE DATABASE salesifua character set utf8;

### Run server:
***************************************************

1. mvn jetty:run

### Home page:
***************************************************

1. http://localhost:8080/Practice/#/home

### SWAGGER documentation:
***************************************************

1. http://localhost:8080/Practice/api-docs
