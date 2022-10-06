package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {
	Student getStudentById(int id);
	List<Student> getAllStudents();
	Student saveStudent(Student st);
	Student udpateStudent(Student st);
	Student deleteStudent(int id);
}
