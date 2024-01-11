package com.imran.student.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.imran.student.entity.Student;
import com.imran.student.repository.StudentRepository;
import com.imran.student.service.StudentService;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public int addStudent(String studentName, String grade) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.setStudentName(studentName);
		s.setGrade(Integer.valueOf(grade));
		studentRepository.save(s);
		return s.getStudentID();
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findByStudentid(id);
	}

	@Override
	public String deleteStudent(@PathVariable int id) {
	 int i = studentRepository.deleteStudentid(id);
		System.out.println("rows deleted: "+i);
		if(i>0) {
		return "Record Deleted Sucessfully";
		}else {
			return "No Record Found";
		}
	 
	}

	@Override
	public int updateStudent(String studentName,int grade,int id)
	{
	int i = studentRepository.updateStudentid(studentName, grade, id);
	System.out.println("Rows Updated---"+i);
	return i;	
	}
   
    
}
