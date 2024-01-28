package com.example.onlinebookstore.payload;

import com.example.onlinebookstore.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponse {
    private Long id;
    private String fullName;
    private String username;
    private Roles role;
}
