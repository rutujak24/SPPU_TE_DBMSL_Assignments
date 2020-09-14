DROP DATABASE IF EXISTS `assign_a3`;
CREATE DATABASE `assign_a3`; 
USE `assign_a3`;



CREATE TABLE customer(
	cust_no INT NOT NULL AUTO_INCREMENT,
    cust_fname VARCHAR(20),
    cust_lname VARCHAR(20),
    cust_company VARCHAR(25),
    
    city VARCHAR(20),
    cust_phone VARCHAR(10),
    primary key (cust_no)
);

insert into customer values(1,'diya','patel','BMC','pune','9781232782');
insert into customer values(2,'riya','shah','ETF','pune','9681232122');
insert into customer values(3,'sara','patil','IndCan','mumbai','9781232122');
insert into customer values(4,'drishti','joshi','BMC','nagpur','8981232122');
insert into customer values(5,'henna','shah','NTF','pimpri','9781652122');
insert into customer values(6,'fatema','katawala','BEST','raipur','9781237622');
insert into customer values(7,'shreya','shah','VESIT','delhi','9781228762');
insert into customer values(8,'anuja','dhobale','Fintech','mumbai','9785532122');
insert into customer values(9,'anuksha','pal','Capgemini','kolhapur','6781232122');
insert into customer values(10,'ishita','das','DB','pune','9781782122');

CREATE TABLE author(
	author_no INT PRIMARY KEY AUTO_INCREMENT,
    author_name VARCHAR(20),
    country VARCHAR(20)
);

insert into author values(1,'Snowy Brown','Germany');
insert into author values(2,'Balkrishan','India');
insert into author values(3,'Ramakant','India');
insert into author values(4,'Downy Flasks','France');
insert into author values(5,'JK Rowling','Germany');
insert into author values(6,'Handsome Jony','USA');


CREATE TABLE publisher(
	publisher_no INT PRIMARY KEY AUTO_INCREMENT,
    publisher_name VARCHAR(20),
    publisher_addr VARCHAR(30),
    birth_year YEAR
);

insert into publisher values(1,'Lalu','Germany',1934);
insert into publisher values(2,'Bhola','India',1975);
insert into publisher values(3,'Raghu','India',2000);
insert into publisher values(4,'Kabuliwala','France',1983);
insert into publisher values(5,'John','Germany',1975);
insert into publisher values(6,'O Henry','USA',1968);



CREATE TABLE book(
	ISBN VARCHAR(13) PRIMARY KEY,
    title VARCHAR(30),
    unit_price INT,
    author_no INT,
    publisher_no INT,
    pub_year YEAR
);

insert into book(ISBN,title,unit_price,author_no,publisher_no,pub_year) values("1",'In Search of Lost Time',400,5,3,1903);
insert into book(ISBN,title,unit_price,author_no,publisher_no,pub_year) values("2",'Ulysses',500,6,4,1934);
insert into book(ISBN,title,unit_price,author_no,publisher_no,pub_year) values("3",'Don Quixote',434,7,5,1945);
insert into book(ISBN,title,unit_price,author_no,publisher_no,pub_year) values("4",'The Great Gatsby',540,8,6,1955);
insert into book(ISBN,title,unit_price,author_no,publisher_no,pub_year) values("5",'One Hundred Years of Solitude',340,9,7,1954);
insert into book(ISBN,title,unit_price,author_no,publisher_no,pub_year) values("6",'Moby Dick',600,10,8,1967);
insert into book(ISBN,title,unit_price,author_no,publisher_no,pub_year) values("7",'War and Peace',700,11,9,1923);
insert into book(ISBN,title,unit_price,author_no,publisher_no,pub_year) values("8",'Hamlet',900,12,10,1904);

CREATE TABLE orders(
	order_no INT AUTO_INCREMENT,
    cust_no INT,
    ISBN VARCHAR(13),
    qty INT,
    odate DATE,
    primary key(order_no)
);

ALTER TABLE orders
ADD FOREIGN KEY(cust_no)
REFERENCES customer(cust_no)
ON DELETE CASCADE;

ALTER TABLE orders
ADD FOREIGN KEY(ISBN)
REFERENCES book(ISBN)
ON DELETE CASCADE;

#ALTER TABLE book
#ADD FOREIGN KEY(author_no)
#REFERENCES author(author_no)
#ON DELETE CASCADE;

#ALTER TABLE book
#ADD FOREIGN KEY(publisher_no)
#REFERENCES publisher(publisher_no)
#ON DELETE CASCADE;




insert into orders(cust_no,ISBN,qty,odate) values (3,1,1,'2019-05-30');
insert into orders(cust_no,ISBN,qty,odate) values (5,3,2,'2020-06-10');
insert into orders(cust_no,ISBN,qty,odate) values (8,5,1,'2020-03-30');


select * from customer where (city='Pune' or city='Mumbai') and (cust_fname like 'P%' or cust_fname like 'H%');

select distinct(city) from customer;

update book set unit_price=1.05*unit_price where pub_year=2015;

select author_name from author where country = 'India' union select author_name from author where country='Australia';

select * from publisher where (birth_year in (2015,2016));

select * from book where unit_price = (select max(unit_price) from book);


select title from book where unit_price between 300 and 400;


select title,author_no,publisher_no from book where pub_year in (2002,2004,2006);

delete from customer where city='Pune';


