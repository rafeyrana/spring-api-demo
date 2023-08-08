package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() { // this is now an api returning an object of the student class
        return studentRepository.findAll();
        // the benefit of using JPA is that we dont have to implement the functionality for findall etc as it is all available as .functions on the repo
                                                                                             
    }
}
