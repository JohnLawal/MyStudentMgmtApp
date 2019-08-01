package com.jlawal.demo.studentmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jlawal.demo.studentmgmt.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long>{

}
