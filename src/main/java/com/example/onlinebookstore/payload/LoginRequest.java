package com.example.onlinebookstore.payload;

import lombok.Data;

@Data
public class LoginRequest {
    String username;
    String password;
}