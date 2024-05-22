package org.graduatetrackingsystem.graduatetracking.services;

import org.graduatetrackingsystem.graduatetracking.dtos.StudentDto;
import org.graduatetrackingsystem.graduatetracking.dtos.StudentLoginDto;
import org.graduatetrackingsystem.graduatetracking.entities.Student;
import org.graduatetrackingsystem.graduatetracking.reponses.StudentLoginResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(long id);
    StudentDto createStudent(StudentDto studentDto);
    StudentDto updateStudent(Long studentId, StudentDto studentDto);
    void deleteStudent(Long id);
    StudentLoginResponse loginStudent(StudentLoginDto studentLoginDto);

}
