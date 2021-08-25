package com.finaltask.studentservice.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.finaltask.studentservice.model.Student;
import com.finaltask.studentservice.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student-service/getAllStudentDetails")
    public ArrayList<Student> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }

    @PostMapping(value = "/student-service/createStudent", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student newStudent = studentService.createStudent(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("Id", newStudent.getId())
                .build().toUri();
        return ResponseEntity.created(location).body(newStudent);
    }
}
