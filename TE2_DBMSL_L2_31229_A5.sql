desc customer;
+---------------+-------------+------+-----+---------+-------+
| Field         | Type        | Null | Key | Default | Extra |
+---------------+-------------+------+-----+---------+-------+
| cust_id       | int         | NO   | PRI | NULL    |       |
| name          | varchar(25) | YES  |     | NULL    |       |
| dateofpayment | date        | YES  |     | NULL    |       |
| scheme        | varchar(25) | YES  |     | NULL    |       |
| status        | varchar(1)  | YES  |     | NULL    |       |
+---------------+-------------+------+-----+---------+-------+
5 rows in set (0.21 sec)

desc fine;
+-----------+------+------+-----+---------+-------+
| Field     | Type | Null | Key | Default | Extra |
+-----------+------+------+-----+---------+-------+
| cust_idin | int  | YES  |     | NULL    |       |
| Date      | date | YES  |     | NULL    |       |
| pay_amt   | int  | YES  |     | NULL    |       |
+-----------+------+------+-----+---------+-------+
3 rows in set (0.01 sec)

-> delimiter #

->create procedure Cal_fine(in cust_idin int, in namein varchar(20))
    -> begin
    -> declare idate date;
    -> declare diff int;
    -> declare pay_amt int;
    -> select dateofpayment into idate from customer where customer.cust_id=cust_idin and customer.name=namein;
    -> select datediff(curdate(), idate) into diff;
    -> if (diff >=15 and diff<=30) then
    -> set pay_amt = diff*5;
    -> elseif diff>30 then
    -> set pay_amt=diff*50;
    -> else set pay_amt=0;
    -> end if;
    -> update customer set status="O" where customer.cust_id=cust_idin and customer.name=namein;
    -> insert into fine values(cust_idin, curdate(), pay_amt);
    -> end;
    -> #
    
    select * from customer;
+---------+--------+---------------+--------+--------+
| cust_id | name   | dateofpayment | scheme | status |
+---------+--------+---------------+--------+--------+
|       1 | Sachin | 2019-11-17    | Java   | O      |
|       2 | Sidhee | 2019-11-18    | COA    | I      |
|       3 | Shruti | 2019-08-18    | COA    | I      |
|       4 | Shilpa | 2020-02-24    | DELD   | I      |
|       5 | Rekha  | 2020-05-19    | ML     | I      |
|       6 | Rutuja | 2020-06-20    | DSA    | I      |
+---------+--------+---------------+--------+--------+
6 rows in set (0.01 sec)

select * from fine;
+-----------+------------+---------+
| cust_idin | Date       | pay_amt |
+-----------+------------+---------+
|         1 | 2020-09-14 |   15100 |
+-----------+------------+---------+
1 row in set (0.01 sec)
