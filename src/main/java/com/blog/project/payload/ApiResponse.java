package com.blog.project.payload;

public class ApiResponse {

    private String message;
    private boolean success;

    //no args constructor
    public ApiResponse() {}
    //all args constructor
    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
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
}
