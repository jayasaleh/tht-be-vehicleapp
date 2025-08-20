package com.i2s.vehicleapp.dto;

public class ErrorResponse<T> {
    private int code;
    private String message;
    private T data;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    // Getter & Setter
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
