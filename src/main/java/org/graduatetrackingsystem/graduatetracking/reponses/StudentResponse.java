package org.graduatetrackingsystem.graduatetracking.reponses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {
    private Long studentId;
    private String image;
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
    private String password;
}