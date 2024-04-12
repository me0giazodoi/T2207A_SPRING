package com.example.t2207a_springboot.model.request_model;

import lombok.Data;

@Data
public class LoginUser {
    private String email;
    private String password;
}
