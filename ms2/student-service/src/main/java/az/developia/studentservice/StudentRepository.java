package az.developia.studentservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

	List<StudentEntity> findAllByTeacherId(Integer teacherId);
}
