package example.Practice05.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice05.model.Entity.BoardEntity;
import example.Practice05.model.Entity.CommentEntity;
import example.Practice05.model.dto.CommentDto;
import example.Practice05.model.repository.BoardRepository;
import example.Practice05.model.repository.CommentRepository;

@Service 
public class CommentService {
@Autowired private CommentRepository commentRepository;
@Autowired private BoardRepository boardRepository;
   
    public boolean 댓글등록(CommentDto commentDto){
    BoardEntity boardEntity =
    boardRepository.findById(commentDto.getBoardId()).orElse(null);
    if(boardEntity == null){return false;}
    CommentEntity commentEntity = commentDto.toEntity();
    commentEntity.setBoardEntity(boardEntity);
    CommentEntity savedEntity =
    commentRepository.save(commentEntity);
    if(savedEntity.getId() >= 1){
    return true;
    }
    return false;
}
   public boolean 댓글삭제(Integer commentId, String password){

    CommentEntity commentEntity =
    commentRepository.findById(commentId).orElse(null);
    if(commentEntity != null){
        if(commentEntity.getPassword().equals(password)){
            commentRepository.deleteById(commentId);
            return true;
        }
    }
    return false;
}
}
 

