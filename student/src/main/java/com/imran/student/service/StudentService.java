package com.imran.student.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.imran.student.entity.Student;

public interface StudentService {
	
	public int addStudent(String studentName, String grade);
	
	public List<Student> getStudents();
	
	public Student getStudent(int id);
	
	public String deleteStudent(int id);
	
	public int updateStudent(String studentName,int grade,int id);
	

}
