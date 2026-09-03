package example.day04.Practice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 앱스타트엔 필요함 (내장 톰캣, 컴포넌트 스캔 해야하기 때문)
public class AppStart1 {
    public static void main(String[] args) {
        
         SpringApplication.run( AppStart1.class );
    }
}
