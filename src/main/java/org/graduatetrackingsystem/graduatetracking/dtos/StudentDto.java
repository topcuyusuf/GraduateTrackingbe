package org.graduatetrackingsystem.graduatetracking.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

    private Long studentId;
    private String cv;
    private String studentNumber;
    private String email;
    private String fullName;
    private String gender;
    private String birthdate;
    private String birthplace;
    private String maritalStatus;
    private String phone;
    private String address;
    private String linkedin;
    private String personalInfo;
    private String department;
    private String program;
    private String educationType;
    private int admissionYear;
    private int graduationYear;
    private String diplomaGrade;
    private String employmentStatus;
    private String interestedAreas;
    private String image;  // image alanı
    private String password;
}
