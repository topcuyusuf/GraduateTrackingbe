package org.graduatetrackingsystem.graduatetracking.ServiceIpml;



import org.graduatetrackingsystem.graduatetracking.dtos.StudentDto;
import org.graduatetrackingsystem.graduatetracking.dtos.StudentLoginDto;
import org.graduatetrackingsystem.graduatetracking.entities.Student;
import org.graduatetrackingsystem.graduatetracking.reponses.StudentLoginResponse;
import org.graduatetrackingsystem.graduatetracking.repositories.StudentRepository;
import org.graduatetrackingsystem.graduatetracking.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(long id) {
        return studentRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = toEntity(studentDto, new Student());
        String encodedPassword = passwordEncoder.encode(student.getPassword());
        student.setPassword(encodedPassword);

        // Log the size of the CV
        if (student.getCv() != null) {
            System.out.println("CV length: " + student.getCv().length());
        }
        return toDto(studentRepository.save(student));
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto studentDto) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student != null) {
            // Update only non-null fields from studentDto to student
            if (studentDto.getCv() != null) student.setCv(studentDto.getCv());
            if (studentDto.getStudentNumber() != null) student.setStudentNumber(studentDto.getStudentNumber());
            if (studentDto.getEmail() != null) student.setEmail(studentDto.getEmail());
            if (studentDto.getFullName() != null) student.setFullName(studentDto.getFullName());
            if (studentDto.getGender() != null) student.setGender(studentDto.getGender());
            if (studentDto.getBirthdate() != null) student.setBirthdate(studentDto.getBirthdate());
            if (studentDto.getBirthplace() != null) student.setBirthplace(studentDto.getBirthplace());
            if (studentDto.getMaritalStatus() != null) student.setMaritalStatus(studentDto.getMaritalStatus());
            if (studentDto.getPhone() != null) student.setPhone(studentDto.getPhone());
            if (studentDto.getAddress() != null) student.setAddress(studentDto.getAddress());
            if (studentDto.getLinkedin() != null) student.setLinkedin(studentDto.getLinkedin());
            if (studentDto.getPersonalInfo() != null) student.setPersonalInfo(studentDto.getPersonalInfo());
            if (studentDto.getDepartment() != null) student.setDepartment(studentDto.getDepartment());
            if (studentDto.getProgram() != null) student.setProgram(studentDto.getProgram());
            if (studentDto.getEducationType() != null) student.setEducationType(studentDto.getEducationType());
            if (studentDto.getAdmissionYear() != 0) student.setAdmissionYear(studentDto.getAdmissionYear());
            if (studentDto.getGraduationYear() != 0) student.setGraduationYear(studentDto.getGraduationYear());
            if (studentDto.getDiplomaGrade() != null) student.setDiplomaGrade(studentDto.getDiplomaGrade());
            if (studentDto.getEmploymentStatus() != null) student.setEmploymentStatus(studentDto.getEmploymentStatus());
            if (studentDto.getInterestedAreas() != null) student.setInterestedAreas(studentDto.getInterestedAreas());
            if (studentDto.getImage() != null) student.setImage(studentDto.getImage());
            if (studentDto.getPassword() != null) student.setPassword(studentDto.getPassword());

            // Ensure the ID is correctly set and not altered
            student.setId(studentId);

            student = studentRepository.save(student);
            return toDto(student);
        }

        return null;
    }


    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    private Student toEntity(StudentDto dto, Student entity) {
        if (dto.getStudentId() != null) {
            entity.setId(dto.getStudentId());
        }
        entity.setCv(dto.getCv());
        entity.setStudentNumber(dto.getStudentNumber());
        entity.setEmail(dto.getEmail());
        entity.setFullName(dto.getFullName());
        entity.setGender(dto.getGender());
        entity.setBirthdate(dto.getBirthdate());
        entity.setBirthplace(dto.getBirthplace());
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setLinkedin(dto.getLinkedin());
        entity.setPersonalInfo(dto.getPersonalInfo());
        entity.setDepartment(dto.getDepartment());
        entity.setProgram(dto.getProgram());
        entity.setEducationType(dto.getEducationType());
        entity.setAdmissionYear(dto.getAdmissionYear());
        entity.setGraduationYear(dto.getGraduationYear());
        entity.setDiplomaGrade(dto.getDiplomaGrade());
        entity.setEmploymentStatus(dto.getEmploymentStatus());
        entity.setInterestedAreas(dto.getInterestedAreas());
        entity.setPassword(dto.getPassword());
        entity.setImage(dto.getImage());
        return entity;
    }


    private StudentDto toDto(Student entity) {
        return StudentDto.builder()
                .studentId(entity.getId())
                .image(entity.getImage())  // image alanını DTO'ya set ediyoruz
                .cv(entity.getCv())
                .studentNumber(entity.getStudentNumber())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .gender(entity.getGender())
                .birthdate(entity.getBirthdate())
                .birthplace(entity.getBirthplace())
                .maritalStatus(entity.getMaritalStatus())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .linkedin(entity.getLinkedin())
                .personalInfo(entity.getPersonalInfo())
                .department(entity.getDepartment())
                .program(entity.getProgram())
                .educationType(entity.getEducationType())
                .admissionYear(entity.getAdmissionYear())
                .graduationYear(entity.getGraduationYear())
                .diplomaGrade(entity.getDiplomaGrade())
                .employmentStatus(entity.getEmploymentStatus())
                .interestedAreas(entity.getInterestedAreas())
                .password(entity.getPassword())
                .build();
    }

    StudentDto studentDto;

    @Override
    public StudentLoginResponse loginStudent(StudentLoginDto studentLoginDto) {
        Student student = studentRepository.findByEmail(studentLoginDto.getEmail());

        if (student != null) {
            boolean isPwdRight = passwordEncoder.matches(studentLoginDto.getPassword(), student.getPassword());
            if (isPwdRight) {
                return new StudentLoginResponse("Login Success", true, student.getId());
            } else {
                return new StudentLoginResponse("Password Not Match", false, null);
            }
        } else {
            return new StudentLoginResponse("Email not exists", false, null);
        }
    }


}




