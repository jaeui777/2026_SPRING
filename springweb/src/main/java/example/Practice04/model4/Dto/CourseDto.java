package example.Practice04.model4.Dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import example.Practice04.model4.Entity.CourseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class CourseDto {

    private Integer courseId;
    private String courseName;

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    // 학생 목록
    private List<StudentDto> studentDtos = new ArrayList<>();

    // toEntity : 과정 등록 용도
    public CourseEntity toEntity( )
    return CourseEntity.builder()
        .courseName(this.courseName)
        .build();

        public static CourseDto from( ){
        return CourseDto.builder().courseId()
        .courseId( entity.getCourseId())
        .courseName( entity.getCourseName())
        .updateAt( entity.getUpdateAt())
        .build()
        }
}
