package az.developia.studentservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.studentservice.entity.Student;
import az.developia.studentservice.repository.StudentRepository;
import az.developia.studentservice.response.StudentListResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentRestController {

	private final StudentRepository repository;

	@GetMapping(path = "/{teacherId}")
	public StudentListResponse findAllByTeacherId(@PathVariable Long teacherId) {

		StudentListResponse response = new StudentListResponse();
		List<Student> entities = repository.findAllByTeacherId(teacherId);
		response.setStudents(entities);
		return response;
	}
}
