package example.day03;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class Exam2 {
    public static void main(String[] args) {
    // 1.
    Student s1 = new Student(); // 1. NoArgsConstructor
    Student s2 = new Student("유재석", 100 , 90);
    s1.setKor(100); // 3.@Setter
    System.out.println(s2.getKor()); // 4.@Getter
    System.out.println(s2.toString()); // @ToString
    // 6. 빌더 패턴 이용한 객체 생성 , 장점 : 순서무관 , 선택적대입, 유연한객체생성
    Student s3 = Student.builder() // 빌더패턴 시작
                    .kor(100)
                    .name("강호동")
                    .math(95)
                    .build(); // 빌더패턴 끝
        // 즉] new 생성자명( ) vs 클래스명.builder().build();
        // 클래스명.메소드명() , 메소드가 static 이면 객체 필요없다
        //  VS 객체명.메소드명() 차이점:
    
}
} // class end
@NoArgsConstructor // 매개변수 없는 생성자 (자동) 생성
@AllArgsConstructor // 전체 매개변수 있는 생성자 ( 자동 ) 생성
// @RequiredArgsConstructor // fianl 멤버변수의 생성자 ( 자동 ) 생성
@Getter @Setter 
@Data // getter + setter + RequiredArgsConstructor + tostring 묶음
@Builder // 빌더 패턴 지원
class Student{
    // 1. 멤버변수
    private String name;
    private int kor;
    private int math;
    // 2. 생성자 -> 롬복 어노테이션 대체
    // 3. getter setter toString -> 롬복 어노테이션 대체
}
