package example.Practice04.model4.Dto;

import java.time.LocalDateTime;

import example.Practice04.model4.Entity.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class EnrollDto {
    private Integer stduentId;
    private String studentName;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    // * toEntity : 학생등록 용도
   // + from : 출력 용도
  
}
