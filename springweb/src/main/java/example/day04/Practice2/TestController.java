package example.day04.Practice2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController // @Controller 안에 @Compoenet + ResponseBody
public class TestController {
        // DI : IOC(제어역전) 기반으로 스프링에 객체(빈)가 등록된 객체(빈) 주입
        @Autowired private TestService testService;
        

        // [1] 등록
        @PostMapping("/test")
        public boolean testWrite( @RequestBody TestEntity testEntity){
            return testService.testWrite( testEntity);
        }

        // [2] 전체조회
        @GetMapping("/test/entity")
        public List<TestEntity> testPrint() {
            return testService.testPrint();
        }

        // [3] 개별 조회
        @GetMapping("/test/detail")
        public TestEntity testEntity( @RequestParam ( name = "no") int no) {
            return testService.testDetail( no );
        }  

          @PutMapping( "/test" )
         public boolean testUpdate( @RequestBody TestEntity testEntity ){
        return testService.testUpdate( testEntity );
    }
      @DeleteMapping( "/test/{no}" )
    public boolean testDelete( @PathVariable(name = "no") int no ){
        return testService.testDelete( no );
    }
        }
        
        

   
        
    


        

