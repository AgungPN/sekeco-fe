package dtos;

import lombok.Data;

import java.util.List;

public class ApiResponse {
    protected String message;
    protected int status;
    protected List<String> errors;
    // TODO: in extends, add attributes data
}
