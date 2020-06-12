package com.team11.charityserver.controller;

import com.team11.charityserver.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("Please login！");
    }
}
