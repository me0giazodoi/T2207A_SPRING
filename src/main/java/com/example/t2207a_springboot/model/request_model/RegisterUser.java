package com.example.t2207a_springboot.model.request_model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUser {
    public String fullName;
    public String email;
    public String password;
}
