package az.developia.teacherservice;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class TeacherDTO {
	 private Integer id;

	 
	private Timestamp register;

	private String name;
	
	private List<StudentDTO> students;
	
	  

	 
	
}