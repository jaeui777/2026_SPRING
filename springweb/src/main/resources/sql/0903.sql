# day05 / TestEntity sample , SQL 대소문자 대신에 _(언더바)
use mydb0903;
INSERT INTO test( name , desc1 , price , create_date , update_date )
        value ( "코카콜라" , "맛있는 탄산음료1" , 1000 , now() , now()),
        ( "사이다" , "맛있는 탄산음료2" , 1500 , now() , now()),
        ( "환타" , "맛있는 탄산음료3" , 700 , now() , now());