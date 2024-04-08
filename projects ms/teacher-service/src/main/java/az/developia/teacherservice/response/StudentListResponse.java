package az.developia.teacherservice.response;

import java.util.List;

import lombok.Data;

@Data
public class StudentListResponse {
	private List<StudentResp> students;

}
