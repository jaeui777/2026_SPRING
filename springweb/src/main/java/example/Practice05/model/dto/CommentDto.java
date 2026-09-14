package example.Practice05.model.dto;

import java.time.LocalDateTime;

import example.Practice05.model.Entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor 
@AllArgsConstructor 
@Builder 
@Data 
public class CommentDto {
    private Integer id;
    private String author;
    private String content;
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Integer boardId;

    public CommentEntity toEntity() {
        return CommentEntity.builder()
        .content(this.content)
        .author(this.author)
        .password(this.password)
        .build();
    }
    
    public static CommentDto from( CommentEntity entity) {
        return CommentDto.builder()
        .id ( entity.getId() )
        .content ( entity.getContent() )
        .password ( entity.getPassword() )
        .author ( entity.getAuthor() )
        .createdAt ( entity.getCreatedAt() )
        .updatedAt ( entity.getUpdatedAt() )
        .boardId (entity.getBoardEntity().getId() )
        .build();
    }
}
 