package az.developia.teacherservice;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class StudentDTO {

	private Integer id;

	private Timestamp register;

	private String name;

	private Integer teacherId;

}
