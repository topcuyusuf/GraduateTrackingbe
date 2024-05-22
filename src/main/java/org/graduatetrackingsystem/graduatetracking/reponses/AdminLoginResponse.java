package org.graduatetrackingsystem.graduatetracking.reponses;

public class AdminLoginResponse {
    private String message;
    private boolean success;
    private Long adminID;

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

    public Long getAdminID() {
        return adminID;
    }

    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    public AdminLoginResponse() {
    }

    public AdminLoginResponse(String message, boolean success, Long adminID) {
        this.message = message;
        this.success = success;
        this.adminID = adminID;
    }
}
