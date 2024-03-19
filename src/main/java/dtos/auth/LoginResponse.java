package dtos.auth;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginResponse {
    private Long userId;
    private String token;
    private String username;
    private String role;
}
