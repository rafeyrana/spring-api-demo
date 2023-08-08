package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    // t is the type of object that we want to work with and then the ID type is long
    // this interface is used to access the database
    // @Query("SELECT s FROM Student WHERE s.email = ?1") // this is jpql but 
    Optional<Student> findStudentByEmail(String email); // this transforms to an sql query 
}
