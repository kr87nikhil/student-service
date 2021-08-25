package com.finaltask.studentservice.service;

import java.util.Arrays;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.finaltask.studentservice.model.Address;
import com.finaltask.studentservice.model.Student;

@Component
public class StudentService {
	private static ArrayList<Student> listOfStudents = new ArrayList<Student>();
	
	static {
		Address home_address = new Address("15 Foreshore Road", "Philadelphia", "PA", 19101);
		Address hostel_address = new Address("25 Market Street", "Philadelphia", "PA", 19101);
		Student student1 = new Student(2009120401, "John Smart", "01-06-1991", "john_smart@xyz.com", "1624958216", "Test User", Arrays.asList(home_address, hostel_address));
		Student student2 = new Student(2001110703, "Simon North", "01/02/1994", "simon_north@xyz.com", "9313549658", "Test User", Arrays.asList(hostel_address));
		listOfStudents.addAll(Arrays.asList(student1, student2)); 
	}
	
	public Student createStudent(Student student){
        long studentId = (long) (Math.floor(Math.random() * (9*Math.pow(10, 9))) + Math.pow(10, 9));
        student.setId(studentId);
        listOfStudents.add(student);
        return student;
    }
	
	public ArrayList<Student> getAllStudentDetails(){
        return listOfStudents;
	}
}
