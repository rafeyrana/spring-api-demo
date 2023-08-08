package com.example.demo.student;

import java.util.Optional;
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
        // the benefit of using JPA is that we dont have to implement the functionality
        // for findall etc as it is all available as .functions on the repo

    }

    public void addNewStudent(Student student) {
        System.out.println(student);
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email already exists");
        } else {
            studentRepository.save(student);
        }
        // since this is the service we will be implementing the business logic here
    }

    public void removeStudent(Long studentId) {
        boolean valid = studentRepository.existsById(studentId);
        if (!valid) {
            throw new IllegalStateException("student for this id does not exist");
        }
        studentRepository.deleteById(studentId);

    }
}
