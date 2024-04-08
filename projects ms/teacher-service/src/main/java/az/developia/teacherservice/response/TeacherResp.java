package az.developia.teacherservice.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherResp {

	private Long id;

	private String name;

	private List<StudentResp> students;

}
