package dtos.auth;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginResponse {
    private String token;
    private String username;
    private String role;
}
