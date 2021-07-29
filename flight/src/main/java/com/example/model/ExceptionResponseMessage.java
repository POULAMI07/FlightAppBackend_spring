package com.example.model;

public class ExceptionResponseMessage {
    private int status;
    private String errorMessage;


    public ExceptionResponseMessage() {
    }

    public ExceptionResponseMessage(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "{" +
            " status='" + getStatus() + "'" +
            ", errorMessage='" + getErrorMessage() + "'" +
            "}";
    }

}
