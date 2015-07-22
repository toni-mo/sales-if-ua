# REST-Domains-examples



### must to be installed next things:
***************************************************

1. java SE 1.8.

2. apache-maven-3.2.5.

3. MySql Server 5.5 (Linux command: sudo apt-get install mysql-server-5.5)

### Database steps:
***************************************************

1. Create database with name = "salesifua"

2. mysql -u root -p

3.  CREATE DATABASE database salesifua;


### Run server 
***************************************************

1. From console go to project directory
 
2. Enter command mvn jetty:run

Links for using:
### Links to rest controller that's using hibernate
***************************************************

1. http://localhost:8080/Practice/goods/ method = GET -- get good list 

2. http://localhost:8080/Practice/goods?id= method = GET -- get good by id

3. http://localhost:8080/Practice/goods method = POST -- save or update good

4. http://localhost:8080/Practice/goods method = DELETE -- delete good

5. http://localhost:8080/Practice/goods/page?page=&amount= and Map into request body like "{"name":"asc"}"
method = POST -- pagination with sorting

8. http://localhost:8080/Practice/goods/search?name= method = GET -- search good by 
  name with ignore case

9. http://localhost:8080/Practice/goods/filter?from=&to= method = GET -- search any good which
  are in scope from and to

