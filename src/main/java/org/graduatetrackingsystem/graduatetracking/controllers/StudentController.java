package org.graduatetrackingsystem.graduatetracking.controllers;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.graduatetrackingsystem.graduatetracking.dtos.StudentDto;
import org.graduatetrackingsystem.graduatetracking.dtos.StudentLoginDto;
import org.graduatetrackingsystem.graduatetracking.entities.Student;
import org.graduatetrackingsystem.graduatetracking.reponses.StudentLoginResponse;
import org.graduatetrackingsystem.graduatetracking.reponses.StudentResponse;
import org.graduatetrackingsystem.graduatetracking.requests.StudentRequest;
import org.graduatetrackingsystem.graduatetracking.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
@Builder
@Data
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getAllStudents")
    public List<StudentResponse> getBasketList(){
        List<StudentResponse> getStudentList= studentService.getAllStudents().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return getStudentList;
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable String id) {
        return toResponse(studentService.getStudentById(Long.parseLong(id)));
    }

    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody StudentRequest newStudentRequest) {
        return toResponse(studentService.createStudent(newStudentRequest.toDto()));
    }

    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable(name = "id")long id,@RequestBody StudentRequest request){
        return toResponse(studentService.updateStudent(id,request.toDto()));
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginStudent(@RequestBody StudentLoginDto studentLoginDto) {
        StudentLoginResponse studentLoginResponse = studentService.loginStudent(studentLoginDto);
        return ResponseEntity.ok(studentLoginResponse);
    }


    public StudentResponse toResponse(StudentDto studentDto) {
        // Return a new StudentResponse object, using the builder pattern
        return StudentResponse.builder()
                .studentId(studentDto.getStudentId())
                .image(studentDto.getImage())
                .cv(studentDto.getCv())
                .studentNumber(studentDto.getStudentNumber())
                .email(studentDto.getEmail())
                .fullName(studentDto.getFullName())
                .gender(studentDto.getGender())
                .birthdate(studentDto.getBirthdate())
                .birthplace(studentDto.getBirthplace())
                .maritalStatus(studentDto.getMaritalStatus())
                .phone(studentDto.getPhone())
                .address(studentDto.getAddress())
                .linkedin(studentDto.getLinkedin())
                .personalInfo(studentDto.getPersonalInfo())
                .department(studentDto.getDepartment())
                .program(studentDto.getProgram())
                .educationType(studentDto.getEducationType())
                .admissionYear(studentDto.getAdmissionYear())
                .graduationYear(studentDto.getGraduationYear())
                .diplomaGrade(studentDto.getDiplomaGrade())
                .employmentStatus(studentDto.getEmploymentStatus())
                .interestedAreas(studentDto.getInterestedAreas())
                .password(studentDto.getPassword())
                .build();
    }

}

