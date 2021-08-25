package com.finaltask.studentservice.model;

import java.util.List;

public class Student {
	private long id;
	private String studentName;
	private String dateOfBirth;
	private String email;
	private String phoneNumber;
	private String guardianName;
	private List<Address> address;
	
	public Student(long id, String studentName, String dateOfBirth, String email, String phoneNumber, String guardianName, List<Address> address) {
		this.setId(id);
		this.setStudentName(studentName);
		this.setDateOfBirth(dateOfBirth);
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setGuardianName(guardianName);
		this.setAddress(address);
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}
	
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public long getId() {
		return this.id;
	}
	
	public String getStudentName() {
		return this.studentName;
	}
	
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getGuardianName() {
		return this.guardianName;
	}
	
	public List<Address> getAddress() {
		return this.address;
	}
}
