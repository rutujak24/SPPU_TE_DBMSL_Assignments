use A6;

CREATE TABLE Student(
	roll_no INT PRIMARY KEY,
    name VARCHAR(20),
    marks INT,
    status CHAR(1)
);

INSERT INTO Student VALUES(1, 'Suyash', 80, 'P');
INSERT INTO Student VALUES(2, 'Shreejay', 80, 'P');
INSERT INTO Student VALUES(3, 'Amit', 80, 'P');
INSERT INTO Student VALUES(4, 'Vicky', 80, 'P');


CREATE TABLE StudentOld(
	roll_no INT PRIMARY KEY,
    name VARCHAR(20),
    marks INT,
    status CHAR(1)
);

INSERT INTO StudentOld VALUES(3, 'Amit', 80, 'P');
INSERT INTO StudentOld VALUES(4, 'Vicky', 80, 'P');
INSERT INTO StudentOld VALUES(5, 'Prashant', 80, 'P');
INSERT INTO StudentOld VALUES(6, 'Advait', 80, 'P');

DELIMITER $$
CREATE PROCEDURE add_students()
BEGIN
	DECLARE finished INT DEFAULT 0;
    DECLARE roll INT DEFAULT 0;
    DECLARE name VARCHAR(20) DEFAULT "";
    DECLARE marks INT DEFAULT 0;
    DECLARE status CHAR(1) DEFAULT "";
    
    -- declare cursor for students table
    DECLARE curStudent 
		CURSOR FOR
			SELECT * FROM Student;
            
	-- declare not found exception handler
    DECLARE CONTINUE HANDLER FOR
    NOT FOUND SET finished = 1;
    
    OPEN curStudent;
    
    getStudent:	LOOP
			FETCH curStudent INTO roll, name, marks, status;
            IF finished = 1 THEN
				LEAVE getStudent;
			END IF;
            
            -- insert data into old student table if its not there already
            IF NOT EXISTS(SELECT 1 FROM StudentOld WHERE roll_no = roll) THEN
				INSERT INTO StudentOld VALUES(roll, name, marks, status);
			END IF;
            
	END LOOP getStudent;
    
END $$
DELIMITER ;

CALL add_students();

SELECT * FROM StudentOld;