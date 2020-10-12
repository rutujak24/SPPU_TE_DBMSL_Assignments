
# 1 .Create database ASS_B1 
create database ASS_B1;
use ASS_B1;

#2 Create table Emp and Dept 

create table Dept(
deptId int NOT NULL, 
deptName varchar(10),
PRIMARY KEY (deptId)
); 

create table Emp( 
empId int NOT NULL,
empName varchar(20),
empSal int ,
empDeptId int,
PRIMARY KEY (empId),
FOREIGN KEY (empDeptId) REFERENCES Dept(deptID)
); 

#3.Set appropriate primary key and Foreign key. 
insert into Dept values(1, "Computer");
insert into Dept values(2, "IT");
insert into Dept values(3, "Entc");

#Insert few Record. 
insert into Emp values(1,'diya',5000, 1);
insert into Emp values(2,'riya',6000, 1);
insert into Emp values(3,'sara',7000, 2);
insert into Emp values(4,'drishti',4000,3);
insert into Emp values(5,'henna',2000,2);
insert into Emp values(6,'fatema',3000,1);
insert into Emp values(7,'shreya',8000,3);
insert into Emp values(8,'anuja',4500,2);
insert into Emp values(9,'anuksha',5800,2);
insert into Emp values(10,'ishita',3000,3);
insert into Emp values(11,'isha',25000,1);
insert into Emp values(12,'kavya',35000,2);
insert into Emp values(13,'tarun',15000,1);
insert into Emp values(14,'hema',75000,2);
insert into Emp values(15,'radha',12000,3);
insert into Emp values(16,'anuj',80000,3);
insert into Emp values(17,'amit',68000,1);
insert into Emp values(18,'rohit',12000,2);


select * from Emp;

#5.Display information of those  emp whose salary is greater than 20000. 
SELECT * FROM Emp WHERE empSal > 20000;

# 6.List the employee details in the ascending order of their basic salary 
SELECT * FROM Emp ORDER BY empSal;

#7.List employees belonging to department 30, 40, or 10 
SELECT * FROM Emp WHERE (empDeptId = 1 OR empDeptId= 2);

# 8.List the employee details whose salary is between 10000 to 30000. 
SELECT * FROM Emp WHERE (empSal > 10000 AND empSal<30000);

# 9. .List the employee details whose name starts with A and salary is greater than 20000. 
SELECT * FROM Emp WHERE (empName like "a%" AND empSal>20000);

#10.List the names of emp whose are working in 'Computer' department. 
SELECT * FROM Emp WHERE empDeptId =1;

#11.Change deptName from 'Computer' to 'Computer Engineering'. 
ALTER TABLE Dept MODIFY COLUMN deptName VARCHAR(100);
UPDATE Dept SET deptName = "Computer Engineering" WHERE deptName = "Computer";

#12.List the total salary, maximum and minimum salary and average salary of the  employees, for department 30.  
SELECT  SUM(empSal), AVG(empSal), MAX(empSal), MIN(empSal)
FROM Emp
WHERE empDeptId = 3;

#13.List average sal of each deptID. 
SELECT empDeptId, avg(empSal)
FROM Emp
GROUP BY empDeptId;
