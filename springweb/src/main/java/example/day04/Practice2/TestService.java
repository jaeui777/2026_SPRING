package example.day04.Practice2;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
	
@Service // 해당 클래스가 비지니스로직 객체(빈)등록
public class TestService {
    @Autowired private TestRepository testRepository;


    // [1]
    public boolean testWrite( TestEntity  testEntity){

        // 1. 리포지토리 이용한 insert ㅓ리하기 , .save 입력받은값이 들어있는 엔터티
        TestEntity savedEntity = testRepository.save(testEntity);
        // 2. .save 성공시 영속 (자바 < -- 연결된상태 --> DB) 된 엔터티
        if( savedEntity.getNo() >=1 ){ return true; } // pk가 존재하면 성공
        return false;
    }
    // [2]
    public List<TestEntity> testPrint(){
        List<TestEntity> list = testRepository.findAll();
        return list;
    }

    // [3]
    public TestEntity testDetail ( int no) {
        // 1. 리포지토리 이용한 select 처리하기 , findById ( pk 번호 )
        // Optional 클래스란? 객체 사용시 null예외 가 발생하는 경우 안전하게 메소드 제공
        Optional<TestEntity> optional = testRepository.findById( no );
        if ( optional.isPresent()) {
            TestEntity entity = optional.get();
            return entity;
        }
        return null;
    }
    @Transactional
    public boolean testUpdate( TestEntity testEntity ){
        // 1. findById 이용한 수정할 엔티티 확인/조회
        Optional<TestEntity> optional = testRepository.findById(testEntity.getNo() );
        if( optional.isPresent() ){  // 2. 조회 결과 존재하면 
            TestEntity entity = optional.get(); // 3. 엔티티 꺼내기 
            // 4. 영속성을 이용한 엔티티 setter 수정한다. 주의할점: @Transactional
            entity.setContent( testEntity.getContent() );
            return true;
        }
        return false;
    }
    
        public boolean testDelete( int no ){
        Optional<TestEntity> optional = testRepository.findById( no );
        if( optional.isPresent() ){
            testRepository.delete( optional.get() );
            return true;
        }
        return false; 
    }
}
