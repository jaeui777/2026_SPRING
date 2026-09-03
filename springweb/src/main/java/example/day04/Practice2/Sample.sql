Drop DATABASE IF EXISTS mydb0903;
Create DATABASE mydb0903;
Use mydb0903;
Create table test(
    no int PRIMARY KEY Auto_increment ,
    content VARCHAR(255) ,
    writer VARCHAR(255)
)