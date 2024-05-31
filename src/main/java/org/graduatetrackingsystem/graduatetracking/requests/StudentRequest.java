        package org.graduatetrackingsystem.graduatetracking.requests;

        import lombok.Builder;
        import lombok.Data;
        import org.graduatetrackingsystem.graduatetracking.dtos.StudentDto;

        @Builder
        @Data
        public class StudentRequest {
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
                private String Password;



            public StudentDto toDto() {
                return StudentDto.builder()
                        .image(this.getImage())
                        .cv(this.getCv())
                        .studentNumber(this.getStudentNumber())
                        .email(this.getEmail())
                        .fullName(this.getFullName())
                        .gender(this.getGender())
                        .birthdate(this.getBirthdate())
                        .birthplace(this.getBirthplace())
                        .maritalStatus(this.getMaritalStatus())
                        .phone(this.getPhone())
                        .address(this.getAddress())
                        .linkedin(this.getLinkedin())
                        .personalInfo(this.getPersonalInfo())
                        .department(this.getDepartment())
                        .program(this.getProgram())
                        .educationType(this.getEducationType())
                        .admissionYear(this.getAdmissionYear())
                        .graduationYear(this.getGraduationYear())
                        .diplomaGrade(this.getDiplomaGrade())
                        .employmentStatus(this.getEmploymentStatus())
                        .interestedAreas(this.getInterestedAreas())
                        .password(this.getPassword())
                        .build();
            }

        }

