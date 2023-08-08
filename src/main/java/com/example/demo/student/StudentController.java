package com.example.demo.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// here we will keep all the resources here
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping() // this is the GET method
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping // this is the POST method
    public void addStudent(@RequestBody Student student) { // we take the student from the request body and map it
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}") // Corrected path // this is the DELETE method
    public void removeStudent(@PathVariable("studentId") Long studentId) {
        studentService.removeStudent(studentId);
    }

}
