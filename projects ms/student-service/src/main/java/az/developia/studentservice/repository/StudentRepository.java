package az.developia.studentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.studentservice.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findAllByTeacherId(Long teacherId);

}
