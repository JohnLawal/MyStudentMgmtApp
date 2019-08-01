package com.jlawal.demo.studentmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jlawal.demo.studentmgmt.model.Transcript;

@Repository
public interface TranscriptRepository extends CrudRepository<Transcript,Long>{

}
