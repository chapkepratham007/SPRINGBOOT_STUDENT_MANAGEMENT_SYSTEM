package com.example.STUDENT_MANAGEMENT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.STUDENT_MANAGEMENT.entity.Student;
import com.example.STUDENT_MANAGEMENT.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	public StudentService service;
	
	@GetMapping("/home")
	public String home() {
		return "home"; //html file view page
	}
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students",service.getAllStudents());
		return "students";
	}
	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		Student student =new Student();//hold the object
		model.addAttribute("student", student);
		return "create-student";
	}
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id,Model model) {
		model.addAttribute("student", service.getById(id));
		return "edit_student";
	}
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id,@ModelAttribute("student") Student student) {
		Student existingstudent=service.getById(id);
		existingstudent.setFirstName(student.getFirstName());
		existingstudent.setLastName(student.getLastName());
		existingstudent.setEmail(student.getEmail());
		service.saveStudent(existingstudent);
		return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deleteById(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/students";
	}
}
