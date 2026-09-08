package example.Practice04.model4.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class StudentDto {
    private Integer enrollId;
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
}
