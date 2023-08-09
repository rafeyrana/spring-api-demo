package com.example.demo.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path = "{studentId}") // this is the DELETE method
    public void removeStudent(@PathVariable("studentId") Long studentId) {
        studentService.removeStudent(studentId);
    }
    @PutMapping(path = "{studentId}") // this is the PUT method
    public void updateStudent(
        @PathVariable("studentId") Long studentId,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email
    )
    {
        studentService.updateStudent(studentId, name, email);
    }


}
