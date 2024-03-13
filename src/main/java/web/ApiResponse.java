package web;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse<T> {
    private String message;
    private int status;
    private T data;
    private List<String> errors;
}
