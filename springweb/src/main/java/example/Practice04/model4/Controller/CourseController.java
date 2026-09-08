package example.Practice04.model4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.Practice04.model4.Dto.CourseDto;
import example.Practice04.model4.service.CourseService;

@RestController
@RequestMapping( "/api/course")
public class CourseController {
    @Autowired private CourseService courseService;

    @PostMapping ("")
    public boolean 고정등록(
        @RequestBody CourseDto courseDto ) (
    )

}
