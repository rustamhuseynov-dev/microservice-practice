package az.developia.teacherservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.teacherservice.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
