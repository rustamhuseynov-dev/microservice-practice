package az.developia.teacherservice.response;

import java.util.List;

import az.developia.teacherservice.entity.Teacher;
import lombok.Data;

@Data
public class TeacherListResponse {

	private List<Teacher> teachers;

	private List<TeacherResp> teachersWithStudents;
}
