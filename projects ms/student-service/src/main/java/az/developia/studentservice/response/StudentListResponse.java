package az.developia.studentservice.response;

import java.util.List;

import az.developia.studentservice.entity.Student;
import lombok.Data;

@Data
public class StudentListResponse {
	private List<Student> students;

}
