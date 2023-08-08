package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")

    private Long id;
    private String name;
    private LocalDate dob;
    private String email;
    @Transient // makes the age 
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, LocalDate dob,  String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
       
        this.email = email;
    }

    public Student(Long id, String name,  String email) {
        this.id = id;
        this.name = name;

        this.email = email;
    }

    public Student(String name, String email) {
        this.name = name;

        this.email = email;
    }

   
    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {

        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", email=" + email + "}";

    }

}