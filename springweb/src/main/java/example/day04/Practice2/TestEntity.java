package example.day04.Practice2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // 데이터베이스 테이블과 자바 클래스와 연결(매핑)
@Table( name = "test") // 연결할 테이블명 지정 ,생략시 클래스명
public class TestEntity {
    @Id // PRIMARY KEY
    @GeneratedValue( strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
      private Integer no;
      private String content;
      private String writer;
}
