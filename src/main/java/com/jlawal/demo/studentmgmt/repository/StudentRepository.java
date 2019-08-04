package com.jlawal.demo.studentmgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jlawal.demo.studentmgmt.model.Student;

import com.jlawal.demo.studentmgmt.model.Classroom;

@Transactional
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	@Query("select s from Student s where s.cgpa >= ?1 order by s.firstName")
	List<Student> findStudentsWithCgpaGreaterThan3(float cgpa);

	@Modifying
	@Query("update Student s set s.classroom = ?1 where s.studentId = ?2")
	void update(Classroom classroom, long id);
}
