package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student john = new Student("John", LocalDate.of(1998, 5, 3), "john@example.com");
            Student emily = new Student("Emily", LocalDate.of(1999, 7, 18), "emily@example.com");

            repository.saveAll(List.of(john, emily));
        };
    }
}
