package com.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.entity.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/")
	public String home() {
		return "redirect:/students";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello World!");
		return "hello";
	}

	@GetMapping("/students")
	public String students(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "show-students";
	}
	
	@GetMapping("/students/{id}")
	public String students(Model model, @PathVariable(name="id")int id) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "show-student";
	}
	
	@GetMapping("/students/new")
	public String createNewStudent(Model model) {
		model.addAttribute("student", new Student());
		return "create-student";
	}
	
	@PostMapping("/students/new")
	public String addNewStudent(Model model, @ModelAttribute(name="student")Student student) {
		model.addAttribute("student", studentService.saveStudent(student));
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(Model model, @PathVariable(name="id")int id) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit-student";
	}
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable(name="id")int id, @ModelAttribute(name="student")Student student) {
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		studentService.udpateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable(name="id")int id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
}
