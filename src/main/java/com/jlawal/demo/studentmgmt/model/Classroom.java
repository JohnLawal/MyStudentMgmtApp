package com.jlawal.demo.studentmgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classrooms")
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomId;
	private String buildingName;
	private String roomNumber;

	@OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<Student>();

	public Classroom() {
		super();
	}

	public Classroom(String buildingName, String roomNumber) {
		super();
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public Classroom(Long classroomId, String buildingName, String roomNumber, List<Student> students) {
		this.classroomId = classroomId;
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
		this.students = students;
	}

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void addStudent(Student student) {
		student.setClassroom(this);
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Classroom [classroomId=" + classroomId + ", buildingName=" + buildingName + ", roomNumber=" + roomNumber
				+ "]";
	}

}
