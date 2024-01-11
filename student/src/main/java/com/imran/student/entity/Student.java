package com.imran.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "studentID")
    private int studentid;

    private String studentName;
    private int grade;
    
    public Student() {
    	
    }
	public Student(int studentID, String studentName, int grade) {
		
		this.studentid = studentID;
		this.studentName = studentName;
		this.grade = grade;
	}
	public int getStudentID() {
		return studentid;
	}
	public void setStudentID(int studentID) {
		this.studentid = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
    
    
}