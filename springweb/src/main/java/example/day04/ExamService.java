package example.day04;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service // 비즈니스로직 담당하는 객체 등록
@RequiredArgsConstructor
public class ExamService {
   // * 리포지토리객체 (주입) 불러오기
   private final ExamRepository examRepository;
  public List<ExamEntity> 전체조회() {
    return examRepository.findAll();
  } 

  // [2] 저장
  public boolean 저장( ExamEntity entity ){
    // 리포지토리 호출
    // 리포지토리객체.save( 저장할 entity ) : insert 지원
    // save함수의 반호나값은 영속된 엔티티 반환
    ExamEntity saved = examRepository.save( entity );
    if(saved.getEno() >= 1) return true;
    return false;
  }

  // [3] 삭제
  public boolean 삭제 ( int no ) {
        // 리포지토리 호출
        // 리포지토리 객체.delateById( 삭제할PK번호 )
        // 반환타입 없음
        examRepository.deleteById(no);
        return true;

  }
@Transactional // 트랜젝션이란 ? 여러개 SQL 하나의 단위로 묶음
  // 만약에 여러개 SQL중에 하나라도 SQL 오류이면 전체 rollback
  // [4] 수정
  public boolean 수정( ExamEntity entity) {
    // 1. 영속된 엔티티 조회
    // 리포지토리객체, findById( 조회할pk번호 ) : select SQL 지원
    // 반환타입 : Optional<엔터티>
    // Optional 클래스란? 본문(객체) 감싼 클래스( 왜? null 예외 안전하게 사용)
        // --> 만약에 조회 결과 엔터티가 없을 때 .getEno() 오류가 발생
        // Optional<객체타입> 변수명; 객체 래핑하여 null 검사 지원
    Optional<ExamEntity> optional = examRepository.findById(entity.getEno());
     // 2. 조회된 결과 엔터티 여부 확인
     if(optional.isPresent()){
    ExamEntity savedEntity = optional.get();
        
    savedEntity.setEname( entity.getEname());
    return true;
}
// * 
return false;
  }
}


