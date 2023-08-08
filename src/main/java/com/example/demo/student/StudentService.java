package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class StudentService {
    public List<Student> getStudents() { // this is now an api returning an object of the student class
        return List.of(
			new Student(
				1L, "Mariam",LocalDate.of(2000, 10, 12),18, "mariam@example.com"
			)
		);// this is a simple api which sends this list as a json object
    }
}
