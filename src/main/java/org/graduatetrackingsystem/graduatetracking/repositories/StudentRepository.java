package org.graduatetrackingsystem.graduatetracking.repositories;

import org.graduatetrackingsystem.graduatetracking.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    Optional<Student> findOneByEmailAndPassword(String email, String password);
    Student findByEmail(String email);
}
