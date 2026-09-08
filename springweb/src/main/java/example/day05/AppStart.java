package example.day05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA 엔티티 등록/수정 
public class AppStart {
    public static void main(String[] args) {
        // AppStart1.class -> AppStart.class 로 변경!
        // 콤마(,) 뒤에 args 도 빼먹지 말고 넣어주세요.
        SpringApplication.run(AppStart.class, args);
    }
}