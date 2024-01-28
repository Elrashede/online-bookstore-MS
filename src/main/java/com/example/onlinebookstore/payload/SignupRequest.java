package com.example.onlinebookstore.payload;

import com.example.onlinebookstore.model.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {

    private String username;

    private String email;
    private String name;

    private Set<String> role;

    private String password;


}
