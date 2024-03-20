package dtos;

import lombok.Data;

import java.util.List;

public class ApiResponse {
    protected String message;
    protected int status;
    public List<String> errors;
}
