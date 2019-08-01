package com.jlawal.demo.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jlawal.demo.studentmgmt.model.Classroom;
import com.jlawal.demo.studentmgmt.model.Student;
import com.jlawal.demo.studentmgmt.model.Transcript;
import com.jlawal.demo.studentmgmt.repository.ClassroomRepository;
import com.jlawal.demo.studentmgmt.repository.StudentRepository;
import com.jlawal.demo.studentmgmt.repository.TranscriptRepository;

@SpringBootApplication
public class StudentMgmtApp implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private TranscriptRepository transcriptRepo;
	@Autowired
	private ClassroomRepository classroomRepo;

	public static void main(String[] args) {
		SpringApplication.run(StudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Classroom classroom1 = new Classroom("McLaughlin building", "M105");

		Transcript transcript = new Transcript("BS Computer Science");
		Student student = new Student("000-62-0001", "John", "Imho", "Lawal", 5.0, LocalDate.of(2019, 5, 24),
				saveTranscript(transcript), saveClassroom(classroom1));
		Student savedStudent = saveStudent(student);
		System.out.println(savedStudent);
	}

	Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	Transcript saveTranscript(Transcript transcript) {
		return transcriptRepo.save(transcript);
	}

	Classroom saveClassroom(Classroom classroom) {
		return classroomRepo.save(classroom);
	}
}
