package example.day02.day02실습;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        // 2.Spring 실행 , SpringBoot [ x ]
        // SpringApplication.run( 현재클래스명.class );     
        // 클래스.class : 클래스 메타정보(멤버변수/생성자/메소드) 반환
        // SpringApplication.run( springboot정보 );
        SpringApplication.run(AppStart.class);
        // 3. ctrl+F5 : 실행 , 주의할점 : 2개 이상 실행 불가능
        // 4. 실행 확인 : HTTP
    } // main end
} // class end
