package com.example.onlinebookstore.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

    private Long id;
    private String token;
    private String type ;
    private String username;
    private String email;
    private List<String> roles;



}
