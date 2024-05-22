    package org.graduatetrackingsystem.graduatetracking.entities;


    import jakarta.persistence.*;
    import lombok.Data;



    @Entity
    @Table(name = "students")
    @Data
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "password")
        private String password;
        @Lob
        @Column(name = "cv", columnDefinition = "LONGTEXT")
        private String cv;

        @Column(name = "student_number")
        private String studentNumber;

        @Column(name = "email",unique = true)
        private String email;

        @Column(name = "full_name")
        private String fullName;

        @Column(name = "gender")
        private String gender;

        @Column(name = "birthdate")
        private String birthdate;

        @Column(name = "birthplace")
        private String birthplace;

        @Column(name = "marital_status")
        private String maritalStatus;

        @Column(name = "phone")
        private String phone;

        @Column(name = "address")
        private String address;

        @Column(name = "linkedin")
        private String linkedin;

        @Column(name = "personal_info")
        private String personalInfo;

        @Column(name = "department")
        private String department;

        @Column(name = "program")
        private String program;

        @Column(name = "education_type")
        private String educationType;

        @Column(name = "admission_year")
        private int admissionYear;

        @Column(name = "graduation_year")
        private int graduationYear;

        @Column(name = "diploma_grade")
        private String diplomaGrade;

        @Column(name = "employment_status")
        private String employmentStatus;
        @Column(name = "interested_areas")
        private String interestedAreas;
        @Lob
        @Column(name = "image", columnDefinition = "LONGTEXT")
        private String image;

    }