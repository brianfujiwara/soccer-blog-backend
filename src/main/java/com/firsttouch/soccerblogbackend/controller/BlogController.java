package com.firsttouch.soccerblogbackend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {


    @GetMapping({"/hello"})
    public String Hello(){
        /// Testing authorization
        return "Hello Auth Works";

    }



}
