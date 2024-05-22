package org.graduatetrackingsystem.graduatetracking.reponses;

import lombok.Builder;
import lombok.Data;

public class StudentLoginResponse {
    private String message;
    private boolean success;
    private Long studentId;  // Add studentId field

    public StudentLoginResponse() {
    }

    public StudentLoginResponse(String message, boolean success, Long studentId) {
        this.message = message;
        this.success = success;
        this.studentId = studentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
