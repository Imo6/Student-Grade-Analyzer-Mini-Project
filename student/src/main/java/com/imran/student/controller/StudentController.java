package com.imran.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imran.student.entity.Student;
import com.imran.student.repository.StudentRepository;
import com.imran.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService mystudentService;
	
	@Autowired
	private StudentRepository studentRepo;;

//	@PostMapping
//    public ResponseEntity<Student> createUser(@RequestBody Student student){
//   // 	Student user1= mystudentService.addStudent(student);
//        return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
//    }
	
	@GetMapping
	public List<Student> getAllStudent(){
		return mystudentService.getStudents();	
	}
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable int id) {
		return mystudentService.getStudent(id);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudentRecord(@PathVariable int id) {
		System.out.println("Initial id---"+id);
		return mystudentService.deleteStudent(id);
		
	}
	
	 @PutMapping("/{id}")
	 public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
		int i = mystudentService.updateStudent(updatedStudent.getStudentName(),updatedStudent.getGrade(),id);
		 if(i>0) {
		 return "Record Updated"; 
		 }
		 else {
			return "Sorry, record not updated";
		 }
	 }
	 
	 @GetMapping("/gethighestGrade")
	 public Student getMaxGrade() {
		 Student student = studentRepo.getMaxGrade();
		
		 return student;
	 }
	 
	 @GetMapping("/getaverageGrade")
	 public double getAvgGrade() {
		 Double avgGrade = studentRepo.getAvgGrade();
		
		 return avgGrade;
	 }
	

}
