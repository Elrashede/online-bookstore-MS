Online BookStore Managment System
---------------------------------

Environments:
JDK 17
My SQL Workbench to test DB
    ---> before running the project, please run this script ( create database online_bookstore;) to create a local database.
    ---> after running the project, please run this script 
                INSERT INTO online_bookstore.role(id,name) VALUES(1,'CUSTOMER');
                INSERT INTO online_bookstore.role(id,name) VALUES(2,'ADMIN');

APIS to test:
  -get book details by id
  -update book details by id
  -get books by category
  -check if the book is available for borrowing or not.
  -add new user with specific roles (CUSTOMER or ADMIN)
  -login user to get a token to enable the authority (there is an issue and i'm working on it)
  

 
