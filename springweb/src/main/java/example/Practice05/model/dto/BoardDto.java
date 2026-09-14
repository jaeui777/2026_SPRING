    package example.Practice05.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.Practice05.model.Entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
    @AllArgsConstructor 
    @Builder 
    @Data 
    public class BoardDto {
    private Integer id;
    private String author;
    private String content;
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder.Default
    private List<CommentDto> comments = new ArrayList<>(); 

    public BoardEntity toEntity() {
        return BoardEntity.builder()
        .id(this.id)
        .content(this.content)
        .author(this.author)
        .password(this.password)
        .build();
    }
    
    public static BoardDto from( BoardEntity entity) {
        return BoardDto.builder()
        .id ( entity.getId() )
        .content ( entity.getContent() )
        .password ( entity.getPassword() )
        .author ( entity.getAuthor() )
        .createdAt ( entity.getCreatedAt() )
        .updatedAt ( entity.getUpdatedAt() )
        .build();
    }
    }
 