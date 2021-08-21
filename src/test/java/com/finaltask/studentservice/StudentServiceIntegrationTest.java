package com.finaltask.studentservice;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.finaltask.studentservice.service.StudentService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentServiceIntegrationTest {
	@Autowired
	private StudentService studentService;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void whenLoadContext_thenStudentServiceAutowired() {
		assertThat(studentService).isNotNull();
	}
}
