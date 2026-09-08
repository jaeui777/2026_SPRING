package example.Practice05.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example.Practice05.model.Entity.CommentEntity;

@Repository 
public interface CommentRepository extends JpaRepository <CommentEntity , Integer> {

    
}  