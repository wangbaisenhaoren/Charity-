package com.team11.charityserver.controller;

import com.team11.charityserver.model.RespBean;
import com.team11.charityserver.model.User;
import com.team11.charityserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public RespBean addUser(@RequestBody User user) {
        if (!userService.checkUserExists(user.getUsername())) {
            user.setRoleId(3);
            BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()).trim());
            if (userService.addUser(user) == 1) {
                return RespBean.ok("Register successfully！");
            } else {
                return RespBean.error("Cannot register！");
            }
        }
        return RespBean.error("Repeat register！");
    }

    @PutMapping("/user")
    public RespBean updateUser(@RequestBody User user) {
        if (userService.updateUser(user) == 1) {
            return RespBean.ok("Update successfully！");
        }
        return RespBean.error("Cannot update user! ");
    }

    @GetMapping("/user")
    public User getUserByUserId(@RequestParam(required = false) Integer userId) {
        return userService.getUserByUserId(userId);
    }
}
