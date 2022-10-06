package com.student.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private int idCtr = 101; 
	private Map<Integer, Student> students = new HashMap<>();
	{
		Student st = new Student(idCtr++, "Shivraj", "Rajpoot", "shivrajs1@gmail.com");
		students.put(st.getId(), st);
		st = new Student(idCtr++, "Ram", "Suryavanshi", "rams1@gmail.com");
		students.put(st.getId(), st);
		st = new Student(idCtr++, "Ravan", "Lankesh", "ravanl1@gmail.com");
		students.put(st.getId(), st);
		st = new Student(idCtr++, "Hanuman", "Anjaneya", "hanumana1@gmail.com");
		students.put(st.getId(), st);
	}

	public List<Student> getAllStudents() {
		return new ArrayList<>(students.values());
	}

	@Override
	public Student getStudentById(int id) {
		Student st = null;
		if(students.containsKey(id)) {
			st = students.get(id);
		}
		return st;
	}

	@Override
	public Student saveStudent(Student st) {
		st.setId(idCtr);
		return students.put(idCtr++, st);
	}

	@Override
	public Student udpateStudent(Student st) {
		if(students.containsKey(st.getId())) {
			students.put(st.getId(), st);
		}
		return students.get(st.getId());
	}

	@Override
	public Student deleteStudent(int id) {
		Student st = null;
		if(students.containsKey(id)) {
			st = students.remove(id);
		}
		return st;
	}
}
