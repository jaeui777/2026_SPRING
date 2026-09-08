package example.day05;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository < TestEntity , Integer >{
    // extends jplaRepository 
    // 1. 기본 CRUD 제공 받는다
    // 2. 페어링/정렬 제공 받는다.
    // 3. 쿼리 커스텀 제공 받는다.
}

