package example.Practice05.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.Practice05.model.Entity.BoardEntity;
import example.Practice05.model.dto.BoardDto;
import example.Practice05.model.dto.CommentDto;
import example.Practice05.model.repository.BoardRepository;
import example.Practice05.model.repository.CommentRepository;
import jakarta.websocket.server.ServerEndpoint;

@Service
public class BoardService {
    @Autowired private BoardRepository boardRepository;
     public boolean 게시물등록( BoardDto boardDto ){
        BoardEntity boardEntity = boardDto.toEntity(); // dto --> entity 
        BoardEntity savedEntity = boardRepository.save( boardEntity ); // entity save 
        if( savedEntity.getId() >= 1 ) return true; // pk가 존재하면 성공 
        return false;
    }
     public List<BoardDto> 게시물전체조회( ){
        List<BoardEntity> boardEntities = boardRepository.findAll();  
        List<BoardDto> boardDtos = new ArrayList<>();
        boardEntities.forEach( (boardEntity) -> {    
            BoardDto boardDto = BoardDto.from(boardEntity);  
            boardEntity.getCommentEntities().forEach((commentEntity) -> {  
                CommentDto commentDto = CommentDto.from( commentEntity );
                boardDto.getComments().add(commentDto);
            });
            boardDtos.add(boardDto);
        });
        return boardDtos; 
    }
    
    public boolean 게시물삭제( Integer id , String password ){  
         BoardEntity boardEntity = boardRepository.findById( id ).orElse( null );
         if( boardEntity != null ){
            if( boardEntity.getPassword().equals( password ) ){
                boardRepository.deleteById( id );
                return true;
            }
        }
        return false;
    }
}


 


 

