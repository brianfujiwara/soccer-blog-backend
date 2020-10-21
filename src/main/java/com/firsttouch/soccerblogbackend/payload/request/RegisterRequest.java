package com.firsttouch.soccerblogbackend.payload.request;


import lombok.Data;
import lombok.Getter;



/// This is the Data Transfer Object(DTO). Data from the register form that will be used to make User Object.
@Data
public class RegisterRequest {


    private String email;


    private String username;

    private String password;
}
