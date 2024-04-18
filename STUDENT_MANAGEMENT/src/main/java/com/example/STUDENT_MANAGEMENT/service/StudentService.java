package com.example.STUDENT_MANAGEMENT.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.STUDENT_MANAGEMENT.entity.Student;
@Service
public interface StudentService {

	public List<Student> getAllStudents();
	public Student saveStudent(Student student);
	public Student getById(int id);
	public void deleteById(int id);
}
