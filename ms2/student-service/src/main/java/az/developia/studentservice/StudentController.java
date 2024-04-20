package az.developia.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")

public class StudentController {
	@Autowired
	private StudentRepository repository;

	@GetMapping(path = "/teacher/{teacherId}")
	public StudentDataResponse findById(@PathVariable Integer teacherId) {
		StudentDataResponse r = new StudentDataResponse();
		r.setStudents(repository.findAllByTeacherId(teacherId));
		return r;
	}
}

@Data
class StudentDataResponse {
	private List<StudentEntity> students;

}