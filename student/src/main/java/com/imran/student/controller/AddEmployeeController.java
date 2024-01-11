package com.imran.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.imran.student.entity.Student;
import com.imran.student.service.imp.StudentServiceImp;

@Controller
public class AddEmployeeController {
	
	@Autowired
	StudentServiceImp studentSer;
	
	@GetMapping("/showForm")
    public String showForm() {
      
        return "form";
    }
	
	@GetMapping("/error")
    public String error() {
      
        return "error";
    }
	
	
	
	 @PostMapping("/submitForm")
	    public String submitForm(String studentName,String grade) {

        int id = studentSer.addStudent(studentName, grade);
        
        if(id != 0) {
	        return "showresult";
        }// Redirect to show the form again
        else {
        	
        return "error"	;
        }
	    }


}
