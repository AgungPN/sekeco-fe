package dtos.user;

import enums.Role;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Long userId;
    private String username;
    private Role role;
    private Date createdAt;
    private Date updatedAt;

}
