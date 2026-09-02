CREATE DATABASE IF NOT EXISTS mydb08266;
USE mydb08266;




CREATE TABLE waiting (
    w_no INT AUTO_INCREMENT PRIMARY KEY,
    phone VARCHAR(20) NOT NULL,
    people_count INT NOT NULL
);
insert into waiting(phone, people_count) values ('010-1234-5678', 3), ('010-5678-1234', 2);


SELECT * FROM waiting;