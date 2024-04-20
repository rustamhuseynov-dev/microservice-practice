package az.developia.teacherservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.Data;

@RestController
@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "*")

public class TeacherController {
	@Autowired
	private TeacherRepository repository;
	
	@Autowired
	private RestTemplate template;

	@GetMapping
	public TeacherDataResponse findById() {
		TeacherDataResponse r = new TeacherDataResponse();
		List<TeacherEntity> teachers = repository.findAll();
		 
		List<TeacherDTO> dtos = new ArrayList<>();
		for (TeacherEntity en : teachers) {
			TeacherDTO dto = new TeacherDTO();
			dto.setId(en.getId());
			dto.setName(en.getName());
			StudentDataResponse resp = template.getForObject("http://student-service/students/teacher/" + en.getId(),
					StudentDataResponse.class);
			dto.setStudents(resp.getStudents());

			dtos.add(dto);
		}

		r.setTeachers(dtos);
		return r;
	}
}

@Data
class TeacherDataResponse {
	private List<TeacherDTO> teachers;

}

@Data
class StudentDataResponse {
	private List<StudentDTO> students;

}
