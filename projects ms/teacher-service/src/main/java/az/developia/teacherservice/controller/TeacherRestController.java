package az.developia.teacherservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import az.developia.teacherservice.entity.Teacher;
import az.developia.teacherservice.repository.TeacherRepository;
import az.developia.teacherservice.response.StudentListResponse;
import az.developia.teacherservice.response.TeacherListResponse;
import az.developia.teacherservice.response.TeacherResp;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/teachers")
@RequiredArgsConstructor
public class TeacherRestController {

	private final TeacherRepository repository;

	private final RestTemplate restTemplate;

	@GetMapping
	public TeacherListResponse findAll() {

		TeacherListResponse response = new TeacherListResponse();

		List<Teacher> entities = repository.findAll();

		response.setTeachers(entities);

		return response;

	}

	@GetMapping(path = "/with-student")
	public TeacherListResponse findAllWithStudents() {

		List<TeacherResp> teachersWithStudents = new ArrayList<>();
		TeacherListResponse listResponse = new TeacherListResponse();
		List<Teacher> entities = repository.findAll();
		for (Teacher teacher : entities) {
			TeacherResp response = new TeacherResp();
			response.setId(teacher.getId());
			response.setName(teacher.getName());
			StudentListResponse studentListResponse = restTemplate
					.getForObject("http://student-service/students/" + teacher.getId(), StudentListResponse.class);
			response.setStudents(studentListResponse.getStudents());
			teachersWithStudents.add(response);

		}

		listResponse.setTeachersWithStudents(teachersWithStudents);

		return listResponse;

	}

}
