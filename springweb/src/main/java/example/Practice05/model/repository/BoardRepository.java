package example.Practice05.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice05.model.Entity.BoardEntity;

@Repository 
public interface BoardRepository extends JpaRepository <BoardEntity , Integer >{ }  