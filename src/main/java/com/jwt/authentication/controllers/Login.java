package com.jwt.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(path="/login")
@Controller
public class Login {

    Login() {}

    @GetMapping("")
    @ResponseBody
    public String option() {
        return "options";
    }
    
    @PostMapping("")
    @ResponseBody
    public String login() {
        return "login";
    }

    @PostMapping("/password")
    @ResponseBody
    public String forgetPassword() {
        return "password";
    }
}
