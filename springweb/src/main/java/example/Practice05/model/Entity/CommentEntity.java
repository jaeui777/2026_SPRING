package example.Practice05.model.Entity;

 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Table ( name = "comment")
@Builder 
@Data 
public class CommentEntity extends BaseTime {
  @Id 
 @GeneratedValue (strategy = GenerationType.IDENTITY )
 private Integer id;
 private String author;
 private String content;
 private String password;

 @ManyToOne 
 @JoinColumn ( name = "board_id")
 private BoardEntity boardEntity;
}
 