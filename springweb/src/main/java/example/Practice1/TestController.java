package example.Practice1;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

// @Component // 스프링 컨테이너 빈 등록
// @Controller // HTTP 서블릿 + @Component

@RestController // @ResponseBody : http(응답) content-type : application/json + @Controller
// 주로 뷰 반환 : @Controller , 값 반환: @RestController

@RequestMapping("/test")    // 해당 클래스내 메소드들의 공통URL 정의 
public class TestController {

    // [1] 게시물 등록 
    @PostMapping //http://localhost:8080/test
    public boolean testWrite(@RequestBody TestDto testDto) {
    System.out.println("TestController.testWrite()");
    return true; 
    }

    
    // [2] 게시물 전체 조회
    @GetMapping // http://localhost:8080/test
    public ArrayList<TestDto> testPrint() {
        System.out.println("전체 게시물 조회 요청");
        ArrayList<TestDto> list = new ArrayList<>();
        System.out.println("TestController.testPrint()");
        list.add(new TestDto(1,"내용1","작성자1"));
        list.add(new TestDto(2,"내용2","작성자2"));
        return list;
    }

   // [3] 게시물 개별 조회
    @GetMapping("/detail") //http://localhost:8080/test/detail?no=1
    public TestDto testDetail(@RequestParam("no") int no) {
        System.out.println("TestController.testDetail()");
        return new TestDto(1,"내용1","작성자1");
    }

    // [4] 게시물 삭제
    @DeleteMapping("/{no}") // http://localhost:8080/test/1
    public boolean testDelete(@PathVariable(name = "no") int no) {
        System.out.println("TestController.testDelete()");
        return true; 
    }

    // [5] 게시물 수정
    @PutMapping  // http://localhost:8080/test
    public boolean testUpdate(@RequestBody TestDto testDto) {
        System.out.println("TestController.testUpdate()");
        return true; 
    }
} // class end



@Data // getter setter toString 등등
@AllArgsConstructor
@NoArgsConstructor
@Builder
class TestDto{
    private int no;
    private String content;
    private String writer;
}